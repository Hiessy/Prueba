package com.example.json;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.codehaus.jackson.map.ObjectMapper;

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

	//Declaro un objeto del tipo ServerResponse para que reciva la respuesta de la consulta del tipo GET. 
	//Fijate que toda consulta Devuelve dos objetos: metadata(con informacion del estado de la consulta) y data con la informacion que se solicito
	ServerResponse<User> serverResponseGet = hacerGet();

	//Declaro un objeto del tipo ServerResponse para que reciva la respuesta de la consulta del tipo POST. 
	ServerResponse<User> serverResponsePost = hacerPost();

	System.out.println("***************************************************************************");
	System.out.println("*****************************Resultado del GET*****************************");
	System.out.println("***************************************************************************");

	System.out.println(serverResponseGet.getMetaData());
	System.out.println(serverResponseGet.getData());

	System.out.println("****************************************************************************");
	System.out.println("*****************************Resultado del POST*****************************");
	System.out.println("****************************************************************************");

	System.out.println(serverResponsePost.getMetaData());
	System.out.println(serverResponsePost.getData());
    }

    public static ServerResponse<User> hacerPost() {
	
	//Declaro un Objeto Mapper para se encarga de tomar el InputStream e intanciar el objeto que lo recibe y le asigna los valores de cada attributo
	ObjectMapper mapper = new ObjectMapper();
	//Declaro el objeto que va a recibir la respuesta de la consulta, en este caso es ServerResponse del tipo User
	ServerResponse<User> serverResponse = null;
	
	try {
	    //Creo un objeto de URL con la URL de consulta
	    URL url = new URL("http://localhost:8080/validate?email=martin@mail.com&string=prueba123");
	    
	    //Abro una conexion, como estoy usando una conexion Http porque el servicio es RESTful necesito convertir el objeto resultante 
	    //del metodo openConnection a (HttpURLConnection) para despues decirle que la conexion tiene que usar el metodo POST
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    //Le agrego el metodo de conexion POST; GET; DELETE; PUT
	    connection.setRequestMethod("POST");

	    //Declaro un InputStream (flujo de datos) para que el mapper que declare arriba tenga datos de entrada. Los datos de entrada los obtengo de la connexion con el metodo getInputStream();
	    InputStream is = connection.getInputStream();
	    
	    //Leo los valores con el metodo del mapper.readValue, ese metodo se carga de instanciar la clase ServerResponse y guardarle los datos de la respuesta del servidor
	    serverResponse = mapper.readValue(is, ServerResponse.class);
	    
	    //Cierro el stream de datos por prolijidad
	    is.close();
	} catch (Exception e) {

	    e.printStackTrace();
	}

	return serverResponse;
    }

    public static ServerResponse<User> hacerGet() {
	
	//Declaro un Objeto Mapper para se encarga de tomar el InputStream e intanciar el objeto que lo recibe y le asigna los valores de cada attributo
	ObjectMapper mapper = new ObjectMapper();
	//Declaro el objeto que va a recibir la respuesta de la consulta, en este caso es ServerResponse del tipo User
	ServerResponse<User> serverResponse = new ServerResponse<User>();

	try {
	    //Creo un objeto de URL con la URL de consulta
	    URL url = new URL("http://localhost:8080/find?email=martin@mail.com");
	    
	    //El metodo de la url de openStream hace un GET automaticamente a la conexion y me devuelve un flujo de datos que lo guardo para que lo procese el mapper
	    InputStream is = url.openStream();
	    
	    //Leo los valores con el metodo del mapper.readValue, ese metodo se carga de instanciar la clase ServerResponse y guardarle los datos de la respuesta del servidor
	    serverResponse = mapper.readValue(is, ServerResponse.class);
	    
	    //Cierro el stream de datos por prolijidad
	    is.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return serverResponse;
    }
}
