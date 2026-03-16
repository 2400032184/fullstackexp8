package com.ecommerce.product.repository;

import com.ecommerce.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    // Derived query methods
    List<Product> findByCategory(String category);
    
    List<Product> findByPriceBetween(Double min, Double max);
    
    // JPQL queries
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> findAllSortedByPrice();
    
    @Query("SELECT p FROM Product p WHERE p.price > :price ORDER BY p.price ASC")
    List<Product> findProductsAbovePrice(@Param("price") Double price);
    
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> findByJpqlCategory(@Param("category") String category);
}
