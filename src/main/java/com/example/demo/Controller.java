package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    public String addCustomer(@RequestParam String name, @RequestParam Double price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        productRepository.save(product);
        return "Added new product to repo!";
    }

    @GetMapping("/list")
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Product findProductById(@PathVariable Integer id) {
        return productRepository.findProductById(id);
    }
}
