package com.fashionstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashionstore.Entities.Order;
import com.fashionstore.Entities.Sprinter;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	Order findByOrderId(Long orderId);

}
