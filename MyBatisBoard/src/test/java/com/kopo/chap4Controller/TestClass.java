package com.kopo.chap4Controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestClass {

	public static void main(String[] args) {
		String before = "0000";
		System.out.println("before : " + before);
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		messageDigest.update(before.getBytes());
		String after = String.format("%064x", new BigInteger(1, messageDigest.digest()));
		System.out.println("after : " + after);
	}
	String test = "<% %>";
}
