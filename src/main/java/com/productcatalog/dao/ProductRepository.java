package com.productcatalog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.productcatalog.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	/**
     * Finds products by using the productType as a search criteria.
     * @param productType  
     * @return  A list of product records which productType is an exact match with the given name.
     *          If no product is found, this method returns an empty list.
     */
	
	@Query("SELECT p FROM Product p WHERE p.productType = :productType")
    public List<Product> findProductsByName(@Param("productType") String productType);
}

