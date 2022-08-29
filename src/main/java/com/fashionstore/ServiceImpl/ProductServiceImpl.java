package com.fashionstore.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.fashionstore.Entities.Product;
import com.fashionstore.Exception.EntityNotFoundException;
import com.fashionstore.Repository.ProductRepository;
import com.fashionstore.Service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
	
		Product productDb=productRepository.save(product);
		
		return productDb;
	}

	@Override
	public List<Product> getAllProducts() {
	 
		List<Product> products=productRepository.findAll();
		
		if(products.isEmpty()) {
			
			throw new EntityNotFoundException("601","No Products found");
			
		}
		return products;
	}

	@Override
	public Product getProductById(Long productId) {
		
		Optional<Product> optionalProduct=productRepository.findById(productId);
		
		if(optionalProduct.isEmpty()) {
			
			throw new EntityNotFoundException("601","No Product found with "+productId+" Id");
		}
		
		else {
			
			Product product=optionalProduct.get();
			
			return product;
		}
	}
	
	

}
