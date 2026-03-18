package com.stavre.ssiach12ex5.repository;

import com.stavre.ssiach12ex5.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

//    ge

    @Query("Select p from Product p where p.name like %:text% AND p.owner=?#{authentication.name}")
    List<Product> findProductByNameContains(String text);
}
