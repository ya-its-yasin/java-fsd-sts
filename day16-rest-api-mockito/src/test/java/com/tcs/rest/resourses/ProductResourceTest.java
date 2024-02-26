package com.tcs.rest.resourses;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.rest.resource.Product;
import com.tcs.rest.resources.ProductResource;
import com.tcs.rest.services.ProductService;

@WebMvcTest(ProductResource.class)
public class ProductResourceTest {

	@MockBean
	ProductService service;
	
	@Autowired
	MockMvc mockMvc; // makes a dummy REST call like GET, POST etc
	
	@Test
	public void TestAddProduct() throws Exception{
		Product product = new Product(1,"Apple iPhone 15", 120000);
		when(service.addProduct(product)).thenReturn(true);
		
		mockMvc.perform(post("/addproduct")
				.contentType(MediaType.APPLICATION_JSON)
				.content(
						new ObjectMapper().
						writeValueAsString(product))
				);
	}
	
	
}















