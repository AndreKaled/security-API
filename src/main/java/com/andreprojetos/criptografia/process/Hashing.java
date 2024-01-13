package com.andreprojetos.criptografia.process;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

public class Hashing {
	
	public static String hexadecimal(String valor) {
		String hex = String.format("%040x", new BigInteger(1, valor.getBytes()));
		return hex;
	}
	
	public static String sha1(String valor) throws NoSuchAlgorithmException {
		try {
			//gerando hash sha1
	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-1");
	        
	        //gera o hash do argumento 'valor'
	        byte[] array = md.digest(valor.getBytes());
	        
	        //converte hash de byte para string em hexadecimal
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	        }
	        return sb.toString();
	    } catch (java.security.NoSuchAlgorithmException e) {
	    	
	    }
	    return null;
	}

	public static String sha256(String valor) throws NoSuchAlgorithmException {
		try {
			//gerando hash sha256
	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
	        
	        //gera o hash do argumento 'valor'
	        byte[] array = md.digest(valor.getBytes());
	        
	        //converte hash de byte para string em hexadecimal
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	        }
	        return sb.toString();
	    } catch (java.security.NoSuchAlgorithmException e) {
	    	
	    }
	    return null;
	}
	
	public static String md5(String valor) throws NoSuchAlgorithmException {
		try {
			//gerando hash md5
	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
	        
	        //gera o hash do argumento 'valor'
	        byte[] array = md.digest(valor.getBytes());
	        
	        //converte hash de byte para string em hexadecimal
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	        }
	        return sb.toString();
	    } catch (java.security.NoSuchAlgorithmException e) {
	    	
	    }
	    return null;
	}

	public static String hash(String modo, String valor) throws NoSuchAlgorithmException {
		//gerando hash no modo escolhido
	    java.security.MessageDigest md = java.security.MessageDigest.getInstance(modo);
	        
	    //gera o hash do argumento 'valor'
	    byte[] array = md.digest(valor.getBytes());
	        
	    //converte hash de byte para string em hexadecimal
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
        	sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	    }
        for(Provider s: Security.getProviders())
        	System.out.println(s.toString());
	    return sb.toString();
	} 
}
