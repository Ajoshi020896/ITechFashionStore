package com.fashionstore.Service;

import java.util.List;

import com.fashionstore.Entities.Product;

public interface ProductService {

	Product addProduct(Product product);

	List<Product> getAllProducts();

	Product getProductById(Long productId);

}
