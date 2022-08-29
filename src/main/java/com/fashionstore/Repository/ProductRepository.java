package com.fashionstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashionstore.Entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
