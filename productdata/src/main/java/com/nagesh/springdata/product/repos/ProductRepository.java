package com.nagesh.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.nagesh.springdata.product.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	
}
