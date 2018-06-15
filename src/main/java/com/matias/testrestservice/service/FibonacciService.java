package com.matias.testrestservice.service;

import org.springframework.stereotype.Service;

import com.matias.testrestservice.error.FibonacciException;

@Service
public class FibonacciService {
	public Integer fibonacci(Integer n) throws FibonacciException{		
	    if (n>1){
	       return fibonacci(n-1) + fibonacci(n-2); 
	    }
	    else if (n==1) {  // caso base
	        return 1;
	    }
	    else if (n==0){  // caso base
	        return 0;
	    }
	    else{ //error
	        System.out.println("Debes ingresar un tamaño mayor o igual a 1");
	        //return -1; 
	        throw new FibonacciException("Debes ingresar un tamaño mayor o igual a 1");
	    }
	}
}
