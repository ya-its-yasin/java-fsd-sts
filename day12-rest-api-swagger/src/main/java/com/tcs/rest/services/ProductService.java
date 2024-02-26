package com.tcs.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.rest.repository.ProductRepository;
import com.tcs.rest.resource.Product;

@Service
public class ProductService {

	@Autowired
	ProductRepository repo;
	
	public List<Product> getProducts()
	{
		List<Product> list = repo.findAll();
		for(Product i : list)
		{
			System.out.println(i);
		}
		return list;
	}

	public Optional<Product> getProduct(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public boolean addProduct(Product product) {
		
		if(repo.save(product)!=null)
			return true;
		return false;
		
	}

	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		if(repo.findById(product.getPid()).get() != null)
		{
			repo.save(product);
			return true;
		}
		return false;
	}

	public boolean deleteProduct(int pid) {
		// TODO Auto-generated method stub
		if(repo.findById(pid) != null)
		{
			repo.deleteById(pid);
			return true;
		}
		return false;
	}
}
