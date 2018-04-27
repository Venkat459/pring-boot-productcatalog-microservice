package com.productcatalog.service;

import java.util.List;

import com.productcatalog.model.Product;


public interface ProductService {

	void create(Product product);

	void update(Product product);

	Product getProduct(Long id);

	void deleteProduct(Long id);

	public List<Product> getAllProducts();

	public Boolean isProductExist(Long productId);
	
	public List<Product> findProductsByName(String productType);
}
