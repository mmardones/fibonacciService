package com.matias.testrestservice.service;

import org.springframework.stereotype.Service;

import com.matias.testrestservice.error.FibonacciException;

@Service
public class TokenService {
	static final private String TOKEN = "2CX56733221DA21SQE11DTB5H"; 
	
	public boolean validateToken(String token) throws FibonacciException{
		try {
			if(!TOKEN.equals(token)) {
	    		throw new FibonacciException("Debes ingresar un token valido");
	    	}else { 
	    		return true;
	    	}
		}catch(Exception e) {
			throw new FibonacciException("Debes ingresar un token valido");
		}
	}
}
	
