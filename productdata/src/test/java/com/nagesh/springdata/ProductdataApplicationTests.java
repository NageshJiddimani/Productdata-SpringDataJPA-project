package com.nagesh.springdata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nagesh.springdata.product.entities.Product;
import com.nagesh.springdata.product.repos.ProductRepository;

@SpringBootTest
class ProductdataApplicationTests {

	@Autowired
	ProductRepository repository;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate() {

		Product product = new Product();
		product.setId(3);
		product.setName("oppo");
		product.setDescription("osm");
		product.setPrice(1500d);
		
		repository.save(product);
	}

	@Test
	public void testRead() {
		
		Product product = repository.findById(2).get();
		assertNotNull(product);
		assertEquals("Samsung", product.getName());
		System.out.println(">>>>>>>>" + product.getId());
		
	}
	@Test
	public void testUpdate() {
		
		Product product = repository.findById(2).get();
		product.setPrice(2000d);
		repository.save(product);
		
	}
	
	@Test
	public void testDelete() {
		if(repository.existsById(3)) {
			repository.deleteById(3);
		}	
	}
	
	@Test
	public void testCount() {
		
		System.out.println(repository.count());
	}

}
