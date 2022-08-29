package com.fashionstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashionstore.Entities.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
