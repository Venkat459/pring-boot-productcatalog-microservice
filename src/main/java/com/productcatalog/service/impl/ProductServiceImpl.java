package com.productcatalog.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productcatalog.dao.ProductRepository;
import com.productcatalog.model.Product;
import com.productcatalog.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductRepository productRepository;
	

	@Override
	public void create(Product product) {
		productRepository.save(product);
	}

	@Override
	public void update(Product product) {
		productRepository.save(product);
	}
	
	@Override
	public Boolean isProductExist(Long productId) {
		Boolean isProductExist = false;
		if (productId != null) {
			isProductExist = productRepository.existsById(productId);
		}
		return isProductExist;
	}

	@Override
	public Product getProduct(Long productId) {
		Optional<Product> findById = productRepository.findById(productId);
		Product p = findById.get();
		return p;
	}

	@Override
	public void deleteProduct(Long productId) {
		if (isProductExist(productId)) {
			productRepository.deleteById(productId);
		}
		
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> findProductsByName(String productType) {
		logger.info("productType:" + productType);
		return productRepository.findProductsByName(productType);
	}


}
