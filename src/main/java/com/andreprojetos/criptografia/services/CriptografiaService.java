package com.andreprojetos.criptografia.services;

import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.management.openmbean.InvalidKeyException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andreprojetos.criptografia.process.Criptografia;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CriptografiaService {

	Criptografia crip = new Criptografia();
	
	@GetMapping("/cipher")
	public String main() {
		return "Made by: André Kaled Duarte";
	}
	
	@GetMapping("/cipher/rot")
	public String criptografaRot13(@RequestParam(value = "valor") String valor) {
		return crip.codificaRot13(valor);
	}
	
	@GetMapping("/cipher/cesar")
	public String criptografaCesar(@RequestParam(value = "valor") String valor, @RequestParam(value = "chave") int chave) {
		return crip.codificaCesar(valor, chave);
	}
	
	@GetMapping("/cipher/cesar+")
	public String criptografaCesarMelhorado(@RequestParam(value = "valor") String valor, @RequestParam(value = "chave") String chave) {
		return crip.codificaCesarMelhorado(valor, chave);
	}
	
	@GetMapping("/cipher/pontas")
	public String criptografaPontas(@RequestParam(value = "valor") String valor) {
		return crip.codificaPontas(valor);
	}
	
	@GetMapping("/decipher/rot")
	public String descriptografaRot13(@RequestParam(value = "valor") String valor) {
		return crip.decodificaRot13(valor);
	}
	
	@GetMapping("/decipher/cesar")
	public String descriptografaCesar(@RequestParam(value = "valor") String valor, @RequestParam(value = "chave") int chave) {
		return crip.descriptografiaDeCesar(valor, chave);
	}
	
	@GetMapping("/decipher/cesar+")
	public String descriptografaCesarMelhorado(@RequestParam(value = "valor") String valor, @RequestParam(value = "chave") String chave) {
		return crip.decodificaCesarMelhorado(valor, chave);
	}
	
	@GetMapping("/decipher/pontas")
	public String descriptografaPontas(@RequestParam(value = "valor") String valor) {
		return crip.decodificaPontas(valor);
	}

	
	
}
