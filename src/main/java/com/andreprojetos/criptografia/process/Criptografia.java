package com.andreprojetos.criptografia.process;

import java.math.BigInteger;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.management.openmbean.InvalidKeyException;

public class Criptografia {

	//ROT13
	public static String codificaRot13(String le) {
		char c;
		int i;
		char code;
		String code1 = "";
		String frase = "";

		for (i = 0; i < le.length(); i++) {
			c = le.charAt(i);
			code1 = "";

			if (c > 96 && c < 123) {
				// soma 13 para que percorra 13 letras a frente (de A até Z)
				code = (char) (c + 13);
				if ((char) (code) > 122) {
					// caso seja maior que z, retorna 26 letras
					code = (char) (code - 26);
				}

				// transfere para String
				code1 += code;

			} else if (c > 64 && c < 91) {// caso seja letra maiuscula

				// soma 13 para que percorra 13 letras a frente (de A até Z)
				code = (char) (c + 13);
				if ((char) (code) > 90) {
					// caso seja maior que z, retorna 26 letras
					code = (char) (code - 26);
				}

				// transfere para String
				code1 += code;
			} else {
				code1 += c;
			}
			// concatena com parte da frase codificada
			frase = frase.concat(code1);
		}

		// retorna a frase codificada ou decodificada se executar novamente
		return frase;
	}

	// metodo decodificador do Rot 13
	public static String decodificaRot13(String pala) {
		// executa novamente o metodo codificador, pois a frase retorna ao
		// estado anterior
		return codificaRot13(pala);
	}

	// metodo para codificar em cesar
	public static String codificaCesar(String frase, int chave) {
		char c;
		char p = 32;
		String cripto = "";
		for (int i = 0; i < frase.length(); i++) {
			c = frase.charAt(i);

			// caso minuscula
			if (c > 96 && c < 123) {
				p = (char) (c + chave);
				if ((char) p > 122) {
					p = (char) (p - 26);
				}
			} else if (c > 64 && c < 91) { // caso maiuscula
				p = (char) (c + chave);
				if ((char) p >= 65) {
					p = (char) (p - 26);
				}
			} else { // todos os outros casos
				p = c;
			}

			String letra = "";
			letra += p;
			cripto = cripto.concat(letra);
		}
		return cripto;
	}

	public static String descriptografiaDeCesar(String codigo, int chave) {
		char c;
		char p = 32;
		String descript = "";
		for (int i = 0; i < codigo.length(); i++) {
			c = codigo.charAt(i);

			if (c > 96 && c < 123) { // caso minuscula
				p = (char) (c - chave);
				if ((char) p <= 96) {
					p = (char) (p + 26);
				}
			} else if (c > 64 && c < 91) { // caso maiuscula
				p = (char) (c - chave);
				if ((char) p <= 64) {
					p = (char) (p + 26);
				}
			} else { // todos os outros caso permanecem com seus caracteres
						// constantes
				p = c;
			}
			String letra = "";
			letra += p;
			descript = descript.concat(letra);
		}
		return descript;
	}

	// O algoritmo das pontas
	public static String codificaPontas(String palavra) {
		String codigo = "";
		int tamMax = palavra.length() - 1;
		double meio;
		// define a metade do tamanho
		if (tamMax % 2 == 0) {
			meio = tamMax / 2;
		} else {
			meio = tamMax / 2 + 0.5;
		}
		// percorre a string encriptografando
		for (int i = 0; i <= meio; i++) {
			String a = "";
			a += palavra.charAt(i);
			String b = "";
			b += palavra.charAt(tamMax);
			tamMax--;
			if (tamMax == meio) {
				codigo = codigo.concat(a);
			} else {
				tamMax--;
				codigo = codigo.concat(a).concat(b);
			}
		}
		return codigo;
	}

	public static String decodificaPontas(String codigo) {
		String decodificado = "";
		String a = "";
		String b = "";
		String c = "";
		for (int i = 0; i < codigo.length(); i++) {
			if (i % 2 == 0) {
				// recebe os caracteres impares, ou pares em logica de vetor
				a += codigo.charAt(i);
			} else {
				// os pares, ou impares em lógica de vetor
				b += codigo.charAt(i);
			}
		}
		// inverte a leitura de b
		for (int i = (b.length() - 1); i >= 0; i--)
			c += b.charAt(i);
		return decodificado = a.concat(c);
	}

	
	public static String codificaCesarMelhorado(String frase, String chave) {
		String codificado = "";
		char letra;
		int j = 0, i = 0;
		while (j < frase.length()) {
				int key;
				key = chave.charAt(i) - 64;
				if(key > 26)
					key -= 32;
				//caso maiuscula
				if(frase.charAt(j) > 64 && frase.charAt(j) < 91){
					letra = (char) (frase.charAt(j) + key);
					if(letra > 91)
						letra -= 26;
				}else if(frase.charAt(j) > 96 && frase.charAt(j) < 123){
					//caso minuscula
					letra = (char) (frase.charAt(j) + key);
					if(letra > 122)
						letra -= 26;
				}else{
					//qualquer outro caso
					letra = frase.charAt(j);
				}
				codificado += letra;
				j++;
				i++;
				if(i==chave.length())
					i = 0;
		}
		return codificado;
	}
	//decodificação 
	public static String decodificaCesarMelhorado(String frase, String chave) {

		String decodificado = "";
		char letra;
		int j = 0,i=0;
		while (j < frase.length()) {
			int key;
			key = chave.charAt(i) - 64;
			if(key > 26)
				key -= 32;
			//caso maiuscula
			if(frase.charAt(j) > 64 && frase.charAt(j) < 91){
				letra = (char) (frase.charAt(j) - key);
				if(letra < 64)
					letra += 26;
				}else if(frase.charAt(j) > 96 && frase.charAt(j) < 123){
					//caso minuscula
					letra = (char) (frase.charAt(j) - key);
					if(letra < 96)
						letra += 26;
				}else{
					//qualquer outro caso
					letra = frase.charAt(j);
				}
				decodificado += letra;
				j++;
				i++;
				if(i==chave.length())
					i=0;
		}
		return decodificado;
	}
	
	
}