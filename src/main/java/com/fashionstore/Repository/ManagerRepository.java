package com.fashionstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashionstore.Entities.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

	Manager findByManagerEmailAndManagerPassword(String emailId, String password);

}
