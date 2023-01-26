package com.fashionstore.Service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface CsvReaderService {

	String fileReader(MultipartFile file) throws IOException;

	String fileReaderFromDb() throws IOException;

}
