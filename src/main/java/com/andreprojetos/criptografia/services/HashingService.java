package com.andreprojetos.criptografia.services;

import java.security.NoSuchAlgorithmException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andreprojetos.criptografia.process.Hashing;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class HashingService {
	
	@GetMapping("/hash/hex")
	public String hexadecimal(@RequestParam(value = "valor") String valor) {
		return Hashing.hexadecimal(valor);
	}
	
	@GetMapping("/hash/sha1")
	public String sha1(@RequestParam(value = "valor") String valor) {
		try {
			return Hashing.sha1(valor);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			return e.toString();
		}
	}
	
	@GetMapping("/hash/sha256")
	public String sha256(@RequestParam(value = "valor") String valor) {
		try {
			return Hashing.sha256(valor);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			return e.toString();
		}
	}
	
	@GetMapping("/hash/md5")
	public String md5(@RequestParam(value = "valor") String valor) {
		try {
			return Hashing.md5(valor);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			return e.toString();
		}
	}
	
	@GetMapping("/hash/")
	public String hashAberto(@RequestParam(value = "modo") String modo, @RequestParam(value="valor") String valor) {
		try {
			return Hashing.hash(modo, valor);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
