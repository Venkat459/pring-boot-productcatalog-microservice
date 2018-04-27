package com.productcatalog.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.productcatalog.model.Product;
import com.productcatalog.service.ProductService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	Map<String, String> add(@RequestBody Product product) {

		logger.info("New Resource Request(Post) request received");

		Map<String, String> response = new HashMap<String, String>();
		try {
			productService.create(product);
			response.put("status", "success");
		} catch (Exception e) {
			logger.error("Error occurred while trying to create product", e);
			response.put("status", "fail");
		}

		return response;
	}

	@RequestMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	Map<String, String> update(@PathVariable Long productId, @RequestBody Product product) {

		logger.info("update (PUT) request received");

		Map<String, String> response = new HashMap<String, String>();
		try {
			Boolean prouctExists = productService.isProductExist(productId);
			if (prouctExists) {
				product.setId(productId);
				productService.update(product);
			}

			response.put("status", "success");
		} catch (Exception e) {
			logger.error("Error occurred while trying to updating product", e);
			response.put("status", "fail");
		}

		return response;
	}

	@RequestMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	Map<String, String> delete(@PathVariable Long productId) {

		logger.info("delete (DELETE) request received for productId" + productId);

		Map<String, String> response = new HashMap<String, String>();
		try {
			Boolean productExists = productService.isProductExist(productId);
			logger.info("isProductId:" + productId + "exist in the database?" + productExists);
			if (productExists) {
				productService.deleteProduct(productId);
				logger.info("Deleted product for productId:" + productId + "successfully");
			}
			response.put("status", "success");
		} catch (Exception e) {
			logger.error("Error occurred while trying to delete product", e);
			response.put("status", "fail");
		}

		return response;
	}

	@RequestMapping(value = "{productId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	Product get(@PathVariable Long productId) {

		logger.info("get (GET) request received for productId :" + productId);
		Product s = null;

		try {
			s = productService.getProduct(productId);
			if (s != null) {
				return s;
			}
		} catch (Exception e) {
			logger.error("Error occurred while trying to get Product", e);

		}

		return s;
	}

	@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	List<Product> all() {

		logger.info("get (GET) request for all resoruces received");
		List<Product> products = null;

		try {
			products = productService.getAllProducts();
		} catch (Exception e) {
			logger.error("Error occurred while trying to get all products", e);

		}

		return products;
	}

	@RequestMapping(value = "/prouductType/{productType}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	List<Product> findProductsByName(@PathVariable String productType) {

		logger.info("get (GET) request to find products by productType received:" + productType);
		List<Product> products = null;

		try {
			products = productService.findProductsByName(productType);
			if (products != null && (!products.isEmpty())) {
				return products;
			}
		} catch (Exception e) {
			logger.error("Error occurred while trying to by productType", e);

		}

		return products;
	}
}
