package com.nagesh.springdata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

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
		assertEquals("Tv", product.getName());
		System.out.println(">>>>>>>>" + product.getId());

	}

	@Test
	public void testUpdate() {

		Product product = repository.findById(2).get();
		product.setPrice(20000d);
		repository.save(product);

	}

	@Test
	public void testDelete() {
		if (repository.existsById(3)) {
			repository.deleteById(3);
		}
	}

	@Test
	public void testCount() {

		System.out.println(repository.count());
	}

	@Test
	public void testFindByName() {

		List<Product> products = repository.findByName("IWatch");
		products.forEach(p -> System.out.println(p.getPrice()));

	}

	@Test
	public void testFindByNameAndDescription() {

		List<Product> products = repository.findByNameAndDescription("Tv", "From Samsung Inc");
		products.forEach(p -> System.out.println(p.getPrice()));

	}

	@Test
	public void testFindByPriceGreaterThan() {

		List<Product> products = repository.findByPriceGreaterThan(1000d);
		products.forEach(p -> System.out.println(p.getPrice()));

	}

	@Test
	public void testFindByDescriptionContains() {

		List<Product> products = repository.findByDescriptionContains("Apple");
		products.forEach(p -> System.out.println(p.getPrice()));

	}

	@Test
	public void testFindByPriceBetween() {

		List<Product> products = repository.findByPriceBetween(400d,3000d);
		products.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void testFindByDescriptionLike() {

		List<Product> products = repository.findByDescriptionLike("%LG%");
		products.forEach(p -> System.out.println(p.getName()));
	}
	
	
}
