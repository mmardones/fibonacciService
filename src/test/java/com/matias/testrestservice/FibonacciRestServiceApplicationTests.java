package com.matias.testrestservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.Assert.*;

import com.matias.testrestservice.controller.FibobacciController;
import com.matias.testrestservice.error.FibonacciException;
import com.matias.testrestservice.service.FibonacciService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FibonacciRestServiceApplicationTests {

	@Autowired
	private FibonacciService fibonacciService;
	
	private MockMvc mockMvc;
	private static final String URL1 = "/api/servicioFibonacci/{numero}";
	private static final String URL = "/api/servicioFibonacci/8";
	private static final String URLivalid = "/api/servicioFibonacci/-1";
	private final FibobacciController configurationController = new FibobacciController();
	
	@Before
	public void beforeTest() {
		mockMvc = MockMvcBuilders.standaloneSetup(configurationController).build();
	}
	
	@Test
	public void shouldReturnHttpCode404OnPUT() throws Exception {
		mockMvc.perform(put(URL)).andExpect(status().isMethodNotAllowed());
	}
	@Test
	public void shouldReturnHttpCode400OnGetWithoutParameter() throws Exception {
		mockMvc.perform(get(URL)).andExpect(status().isBadRequest());
	}/*
	@Test
	public void shouldReturnHttpCode500OnGetParameter() throws Exception {
		mockMvc.perform(get(URL).header("token","dxcfeCX567332jh43sSQE11DTB5H")).andExpect(status().isBadRequest());
	}
	@Test
	public void shouldReturnHttpCode500OnGetParameterinvalid() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(URLivalid).header("token","2CX56733221DA21SQE11DTB5H")).andExpect(status().isBadRequest());
		
	}	
	@Test	
	public void EmployeeTest() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get(URL).header("token","2CX56733221DA21SQE11DTB5H"))
          .andDo(print())  
          .andExpect(MockMvcResultMatchers.status().isOk()); 
        
	}*/
	
    @Test
    public void testFibonacci() throws FibonacciException {
		Integer numero = 2;
        Integer result = null;
		result = fibonacciService.fibonacci(numero);
		assertEquals((Integer) 1,(Integer) result);
    }
    @Test(expected = FibonacciException.class)
    public void testFibonacciException() throws FibonacciException {
        Integer numero = -1;
        Integer result = fibonacciService.fibonacci(numero);
    }
}
