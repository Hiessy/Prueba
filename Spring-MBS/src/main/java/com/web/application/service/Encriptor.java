package com.web.application.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encriptor {

	public static String getHash(String toHash) {

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
