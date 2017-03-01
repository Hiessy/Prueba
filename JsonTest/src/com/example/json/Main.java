package com.example.json;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.type.TypeReference;

import com.example.json.model.Access;
import com.example.json.model.Address;
import com.example.json.model.User;
import com.example.json.model.response.ServerResponse;

/*
 * Tipo de respuesta de ejemplo del servidor
 * 
 * {
 * "metaData":
 * 		{"httpStatus":"OK","message":"User found succesfully","info":"User search request"},
 * "data":
 * 		{"nombre":"Martin","apellido":"Diaz","telefono":"54 11 44315780","contraseña":"prueba123","dni":"27093141","mail":"martin@mail.com","sexo":"M","fechDeNacimiento":"06/03/1979","address":	
 * 																										[{"pais":"Argentina","provincia":"CABA","barrio":"Caballito","direccion":"direccion larga"},{"pais":"Argentina","provincia":"CABA","barrio":"Cogland","direccion":"direccion larga 2"}]}
 * }
 * 
 * 
 */
public class Main {

	public static void main(String[] args) {

		// Declaro un objeto del tipo ServerResponse para que reciva la
		// respuesta de la consulta del tipo GET.
		// Fijate que toda consulta Devuelve dos objetos: metadata(con
		// informacion del estado de la consulta) y data con la informacion que
		// se solicito
		ServerResponse<User> serverResponseGet = hacerGet();

		// Declaro un objeto del tipo ServerResponse para que reciva la
		// respuesta de la consulta del tipo POST.
		ServerResponse<Access> serverResponsePost = hacerPost();

		ServerResponse<User> serverResponsePostwithBody = hacerPostConBody();
		
		System.out.println("***************************************************************************");
		System.out.println("*****************************Resultado del GET*****************************");
		System.out.println("***************************************************************************");

		System.out.println(serverResponseGet.getMetaData());
		System.out.println(serverResponseGet.getData());
		System.out.println(serverResponseGet.getData().getContraseña());

		System.out.println("****************************************************************************");
		System.out.println("*****************************Resultado del POST*****************************");
		System.out.println("****************************************************************************");

		System.out.println(serverResponsePost.getMetaData());
		System.out.println(serverResponsePost.getData());
		System.out.println(serverResponsePost.getData().getToken());
		
		System.out.println("****************************************************************************");
		System.out.println("************************Resultado del POST con Body*************************");
		System.out.println("****************************************************************************");

		System.out.println(serverResponsePostwithBody.getMetaData());
		System.out.println(serverResponsePostwithBody.getData());
		System.out.println(serverResponsePostwithBody.getData().getContraseña());
	}

	public static ServerResponse<Access> hacerPost() {

		// Declaro un Objeto Mapper para se encarga de tomar el InputStream e
		// intanciar el objeto que lo recibe y le asigna los valores de cada
		// attributo
		ObjectMapper mapper = new ObjectMapper();
		// Declaro el objeto que va a recibir la respuesta de la consulta, en
		// este caso es ServerResponse del tipo User
		ServerResponse<Access> serverResponse = null;

		try {
			// Creo un objeto de URL con la URL de consulta
			URL url = new URL("http://localhost:8080/validate?email=martin@mail.com&string=prueba123");

			// Abro una conexion, como estoy usando una conexion Http porque el
			// servicio es RESTful necesito convertir el objeto resultante
			// del metodo openConnection a (HttpURLConnection) para despues
			// decirle que la conexion tiene que usar el metodo POST
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Le agrego el metodo de conexion POST; GET; DELETE; PUT
			connection.setRequestMethod("POST");

			// Declaro un InputStream (flujo de datos) para que el mapper que
			// declare arriba tenga datos de entrada. Los datos de entrada los
			// obtengo de la connexion con el metodo getInputStream();
			InputStream is = connection.getInputStream();

			// Leo los valores con el metodo del mapper.readValue, ese metodo se
			// carga de instanciar la clase ServerResponse y guardarle los datos
			// de la respuesta del servidor
			serverResponse = mapper.readValue(is, new TypeReference<ServerResponse<Access>>() {
			});

			// Cierro el stream de datos por prolijidad
			is.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return serverResponse;
	}
	public static ServerResponse<User> hacerPostConBody() {

		ObjectMapper mapper = new ObjectMapper();
		ServerResponse<User> serverResponse = null;

		try {
			URL url = new URL("http://localhost:8080/register");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			
			//Configura el header para que sea Contet-Type; Application/json
			connection.setRequestProperty("Content-Type", "application/json");
			//Configuro el listener para que espere una respuesta
			connection.setDoOutput(true);
			connection.connect(); 
			
			//Creo que objeto que voy a convertir en el body, para mayor facilidad lo isntancio y lo convierto en string
			User user = new User();
			
			user.setNombre("Martin");
			user.setApellido("Diaz");
			user.setDni("27093141");
			user.setFechDeNacimiento("06/03/1979");
			user.setMail("martin@mail.com");
			user.setContraseña("password");
			user.setSexo("M");
			user.setTelefono("44315780");
			List<Address> address = new ArrayList<Address>();
			address.add(new Address("AR","Capital Federal", "Caballito", "Av. Rivadavia 5900"));
			
			user.setAddress(address);
			//Utilizando la libreria de jackson lo convierto en ObjectNode para que me arme la estructura del Json,
			// el objeto node lo voy a usar como string
	        ObjectNode node = mapper.valueToTree(user);
	        
	        //Obtengo el lector de stream de la conexion
			OutputStream os = connection.getOutputStream();			
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(os, "UTF-8");
			//escribo mi objeto json al servidor
			outputStreamWriter.write(node.toString());
			//libero memoria
			outputStreamWriter.flush();
			outputStreamWriter.close();			
		
			//continua normalment
			InputStream is = connection.getInputStream();
			serverResponse = mapper.readValue(is, new TypeReference<ServerResponse<User>>() {});
			is.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return serverResponse;
	}
	public static ServerResponse<User> hacerGet() {

		// Declaro un Objeto Mapper para se encarga de tomar el InputStream e
		// intanciar el objeto que lo recibe y le asigna los valores de cada
		// attributo
		ObjectMapper mapper = new ObjectMapper();
		// Declaro el objeto que va a recibir la respuesta de la consulta, en
		// este caso es ServerResponse del tipo User
		ServerResponse<User> serverResponse = null;

		try {
			// Creo un objeto de URL con la URL de consulta
			URL url = new URL("http://localhost:8080/find?email=martin@mail.com");

			// El metodo de la url de openStream hace un GET automaticamente a
			// la conexion y me devuelve un flujo de datos que lo guardo para
			// que lo procese el mapper
			InputStream is = url.openStream();

			// Leo los valores con el metodo del mapper.readValue, ese metodo se
			// carga de instanciar la clase ServerResponse y guardarle los datos
			// de la respuesta del servidor
			serverResponse = mapper.readValue(is, new TypeReference<ServerResponse<User>>() {
			});

			// Cierro el stream de datos por prolijidad
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serverResponse;
	}
}
