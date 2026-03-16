package com.ecommerce.product.controller;

import com.ecommerce.product.entity.Product;
import com.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;
    
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return productRepository.findByCategory(category);
    }
    
    @GetMapping("/filter")
    public List<Product> filterByPrice(@RequestParam Double min, @RequestParam Double max) {
        return productRepository.findByPriceBetween(min, max);
    }
    
    @GetMapping("/sorted")
    public List<Product> getSortedByPrice() {
        return productRepository.findAllSortedByPrice();
    }
    
    @GetMapping("/expensive/{price}")
    public List<Product> getExpensiveProducts(@PathVariable Double price) {
        return productRepository.findProductsAbovePrice(price);
    }
    
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
