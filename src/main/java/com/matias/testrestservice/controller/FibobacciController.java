package com.matias.testrestservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matias.testrestservice.error.FibonacciException;
import com.matias.testrestservice.service.FibonacciService;
import com.matias.testrestservice.service.TokenService;

@RestController
@RequestMapping(value = "/api")
public class FibobacciController {
	//inicializar variable
	@Autowired
	private FibonacciService fibonacciService;
	@Autowired
	private TokenService tokenService;
	
	
    /*@RequestMapping(value = "/servicioFibonacci",  method = RequestMethod.GET)    
    public Integer getFibonacci(@RequestParam(value="numero") Integer numero) throws FibonacciException {    
    	System.out.println("numero ="+ numero);
    	return fibonacciService.fibonacci(numero);
    }*/
     
    @RequestMapping(value = "/servicioFibonacci/{numero}",  method = RequestMethod.GET) 
    public Integer getFibonacci2(@RequestHeader(value = "token") String token, @PathVariable Integer numero) throws FibonacciException {  
    	if(tokenService.validateToken(token)) {  
    		System.out.println("numero ="+ numero);    		
    		return fibonacciService.fibonacci(numero);
    	}else
    		throw new FibonacciException("Debes ingresar un token valido"); 	
    	
    }    
    
}