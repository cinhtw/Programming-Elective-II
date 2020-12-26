package com.example.canteen.dao;

import com.example.canteen.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product findProductById(Integer id);
}
