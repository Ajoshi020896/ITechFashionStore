package com.fashionstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashionstore.Entities.CsvFileReader;

@Repository
public interface CsvReaderRepository extends JpaRepository<CsvFileReader, String> {

}
