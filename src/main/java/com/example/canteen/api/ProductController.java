package com.example.canteen.api;

import com.example.canteen.model.Product;
import com.example.canteen.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/Customeradd")
    public String addProduct(@RequestParam String name, @RequestParam Double price) {
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
