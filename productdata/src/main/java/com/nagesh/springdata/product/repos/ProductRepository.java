package com.nagesh.springdata.product.repos;
 
import org.springframework.data.repository.CrudRepository;

import com.nagesh.springdata.product.entities.Product;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	List<Product> findByName(String name);

	List<Product> findByNameAndDescription(String name, String Description);

	List<Product> findByPriceGreaterThan(Double price);

	List<Product> findByDescriptionContains(String description);

	List<Product> findByPriceBetween(Double price1, Double price2);

	List<Product> findByDescriptionLike(String Description);

}
