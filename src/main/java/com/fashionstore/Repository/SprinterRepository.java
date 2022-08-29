package com.fashionstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashionstore.Entities.Sprinter;
@Repository
public interface SprinterRepository extends JpaRepository<Sprinter, Long> {
	

}
