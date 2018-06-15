package com.matias.testrestservice2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PathVariable;

import com.matias.testrestservice.controller.FibobacciController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FibonacciRestServiceApplicationTests {
	
	private MockMvc mockMvc;
	private static final String URL = "/api/servicioFibonacci/";
	private final FibobacciController configurationController = new FibobacciController();
	
	@Test
	public void contextLoads() {
		
	}
	@Test
	public void shouldReturnHttpCode200OnGet() throws Exception {
		mockMvc.perform(get(URL+15).header("token", "2CX56733221DA21SQE11DTB5H")).andExpect(status().isOk());
		
	}
	@Test
	public void shouldReturnHttpCode404OnPUT() throws Exception {
		mockMvc.perform(put(URL)).andExpect(status().isMethodNotAllowed());
	}
	@Test
	public void shouldReturnHttpCode400OnGetWithoutParameter() throws Exception {
		mockMvc.perform(get(URL+9)).andExpect(status().isBadRequest());
	}
	@Test
	public void shouldReturnHttpCode500OnGetParameter() throws Exception {
		mockMvc.perform(get(URL+32).header("token", "424821SQE11DTDWGV385H")).andExpect(status().isBadRequest());
	}
	@Test
	public void shouldReturnHttpCode500OnGetParameterinvalid() throws Exception {
		mockMvc.perform(get(URL+-1).header("token", "2CX56733221DA21SQE11DTB5H")).andExpect(status().isOk());
		
	}
}
