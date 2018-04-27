package com.productcatalog.restcontrooler;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productcatalog.model.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.DEFAULT)
public class ProductControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getProductByIdTest1() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/products/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void getAllBookProductsByProductNameTest2() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/products/prouductType/books").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void getAllToyProductsByProductNameTest3() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/products/prouductType/toys").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void updateProductByIdTest4() throws Exception {
		Product p = new Product();
		p.setProductDescription("updated description through test method");
		p.setProductName("updated productName through test method");
		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(Include.NON_NULL);
		String jsonPerson = om.writeValueAsString(p);
		mvc.perform(MockMvcRequestBuilders.put("/products/1").content(jsonPerson)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	@Test
	public void createProductTest5() throws Exception {
		Product p = new Product();
		p.setProductDescription("updated description through test method");
		p.setProductName("updated productName through test method");
		p.setProductType("books");
		p.setPrice(100.0d);
		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(Include.NON_NULL);
		String jsonPerson = om.writeValueAsString(p);
		mvc.perform(MockMvcRequestBuilders.post("/products").content(jsonPerson).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	@Test
	public void getAllProductsTest6() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/products").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void deleteProductByIdTest7() throws Exception {
		mvc.perform(MockMvcRequestBuilders.delete("/products/6").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
