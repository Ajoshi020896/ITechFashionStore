package com.fashionstore.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashionstore.Entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {



}
