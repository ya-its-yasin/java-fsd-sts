package com.tcs.rest.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.rest.resource.Product;
import com.tcs.rest.services.ProductService;

@RestController
@RequestMapping("/product/v1")
public class ProductResource {

	@Autowired
	ProductService service;

	@GetMapping
	public String check() {
		return "/product/v1";
	}

	@GetMapping("/allproducts")
	public List<Product> showAllProducts() {
		return service.getProducts();
	}

	@GetMapping("product/{id}")
	public Optional<Product> fetchProduct(@PathVariable int id) {
		return service.getProduct(id);
	}

	@PostMapping(path = "/addproduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addProduct(@RequestBody Product product) {
		if (service.addProduct(product))
			return "Successfully added";
		return "failed to add";
	}

	@PutMapping(path = "/modifyproduct", 
				   consumes = MediaType.APPLICATION_JSON_VALUE,
				  produces = MediaType.APPLICATION_JSON_VALUE )
											
	public String updateProduct(@RequestBody Product product)
	{
		if(service.updateProduct(product))
			return "Successfully updated";
		return "failed to update";
	}
	
	@DeleteMapping(path= "/deleteproduct",
			 consumes = MediaType.APPLICATION_JSON_VALUE,
			  produces = MediaType.APPLICATION_JSON_VALUE )
	public String deletProduct(@RequestBody Product obj)
	{
		if(service.deleteProduct(obj.getPid()))
			return "Successfully deleted";
		return "failed to delete";
	}

}
