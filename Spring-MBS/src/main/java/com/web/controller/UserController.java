package com.web.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import scala.annotation.meta.setter;

import com.web.model.ServerResponse;
import com.web.model.request.User;
import com.web.model.request.Address;
import com.web.model.response.MetaData;
import com.web.model.response.Access;

@Controller
@EnableAutoConfiguration
public class UserController {

	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	//
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<ServerResponse<User>> registerUser(@RequestBody User user) {

		ServerResponse<User> userResponse = new ServerResponse<User>();
		MetaData userMetaData = new MetaData();

		userMetaData.setInfo("User registration request");

		try {
			userMetaData.setMessage("User registration succesfull");
			userMetaData.setHttpStatus(HttpStatus.OK);
			// TODO validation method
			userResponse.setData(user);
			LOGGER.info("User was registered succesfully");

		} catch (Exception e) {
			userMetaData.setMessage("Unable to register User: " + e.getMessage());
			userMetaData.setHttpStatus(HttpStatus.BAD_REQUEST);
			LOGGER.error("User not registered error" + e.getMessage());
		}

		userResponse.setMetaData(userMetaData);
		return new ResponseEntity<ServerResponse<User>>(userResponse, HttpStatus.OK);
	}

	// http://localhost:8080/validate?email=martin@mail.com&string=prueba123
	@RequestMapping(value = "/validate", params = { "email", "string" }, method = { RequestMethod.POST })
	public ResponseEntity<ServerResponse<Access>> validate(@RequestParam("email") String email, @RequestParam("string") String pass) {

		ServerResponse<Access> accesResponse = new ServerResponse<Access>();
		MetaData accessMetaData = new MetaData();
		accessMetaData.setInfo("User validation request");
		try {

			accessMetaData.setHttpStatus(HttpStatus.OK);
			accesResponse.setMetaData(accessMetaData);
			// TODO validation method

			accesResponse.setData(checkUserAuthorization(email, pass));
			accessMetaData.setMessage("User validate succesfully");
			LOGGER.info("User was validated succesfully");

		} catch (Exception e) {
			accessMetaData.setHttpStatus(HttpStatus.BAD_REQUEST);
			accessMetaData.setMessage("Unable to validate user");
			accesResponse.setMetaData(accessMetaData);
			LOGGER.error("User not validation error" + e.getMessage());
		}

		return new ResponseEntity<ServerResponse<Access>>(accesResponse, HttpStatus.OK);
	}

	// http://localhost:8080/find?email=martin@mail.com
	@RequestMapping(value = "/find", params = "email", method = RequestMethod.GET)
	public ResponseEntity<ServerResponse<User>> validate(@RequestParam("email") String email) {

		ServerResponse<User> userSearchResponse = new ServerResponse<User>();
		MetaData userSearchMetaData = new MetaData();
		userSearchMetaData.setInfo("User search request");
		try {

			userSearchMetaData.setHttpStatus(HttpStatus.OK);
			userSearchResponse.setMetaData(userSearchMetaData);
			userSearchMetaData.setMessage("User found succesfully");
			// TODO get user method

			userSearchResponse.setData(getUserByEmail(email));
			if (userSearchResponse.getData() == null)
				throw new RuntimeException("User not found");

			LOGGER.info("User was found succesfully");
		} catch (Exception e) {
			userSearchMetaData.setHttpStatus(HttpStatus.BAD_REQUEST);
			userSearchResponse.setMetaData(userSearchMetaData);
			userSearchMetaData.setMessage("User search error: " + e.getMessage());
			LOGGER.error("User not found error" + e.getMessage());
		}

		return new ResponseEntity<ServerResponse<User>>(userSearchResponse, HttpStatus.OK);
	}

	private User getUserByEmail(String email) {
		User user = null;
		List<Address> adress = null;

		if (email.equals("martin@mail.com")) {
			user = new User();
			adress = new ArrayList<Address>();
			Address addr = new Address();
			Address addr2 = new Address();

			user.setMail("martin@mail.com");
			user.setNombre("Martin");
			user.setApellido("Diaz");
			user.setDni("27093141");
			user.setFechDeNacimiento("06/03/1979");
			user.setSexo("M");
			user.setTelefono("54 11 44315780");
			user.setContraseña("prueba123");
			addr.setPais("Argentina");
			addr.setProvincia("CABA");
			addr.setBarrio("Caballito");
			addr.setDireccion("direccion larga");

			addr2.setPais("Argentina");
			addr2.setProvincia("CABA");
			addr2.setBarrio("Cogland");
			addr2.setDireccion("direccion larga 2");

			adress.add(addr);
			adress.add(addr2);
			user.setAddress(adress);
		}
		return user;
	}

	private Access checkUserAuthorization(String email, String pass) {

		Access access = new Access();

		if (pass.equals("prueba123")) {
			access.setHash(getHash(email + ":" + pass));
			access.setAccepted(true);
		} else {
			access.setAccepted(false);
		}

		return access;
	}

	private String getHash(String toHash) {

		MessageDigest messageDigest = null;
		StringBuffer sb = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(toHash.getBytes());
			byte[] mdbytes = messageDigest.digest();
			sb = new StringBuffer();
			for (int i = 0; i < mdbytes.length; i++) {
				sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sb.toString();
	}
}
