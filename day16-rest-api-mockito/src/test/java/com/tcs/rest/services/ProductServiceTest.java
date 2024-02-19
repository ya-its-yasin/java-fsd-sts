package com.tcs.rest.services;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tcs.rest.repository.ProductRepository;
import com.tcs.rest.resource.Product;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@InjectMocks
	private ProductService service;
	
	@Mock
	private ProductRepository repo;
	
	@BeforeEach
	void setUp()
	{
		Optional<Product> optional = Optional.of(new Product(9,"Smart washing machine", 125000.0));
		System.out.println((optional.get()));
		Mockito.when(repo.findById(9)).thenReturn(optional);
	}
	
	@Test
	public void testGetProduct()
	{
		double expected_price = 125000;
		Product prod = service.getProduct(9).get();
		assertEquals(expected_price,prod.getPrice());
	}
	
	
}














