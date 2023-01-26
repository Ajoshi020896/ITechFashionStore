package com.fashionstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fashionstore.Helper.CSVHelper;
import com.fashionstore.Service.CsvReaderService;

@RestController
@RequestMapping("/csv")
public class CsvReaderController {

	@Autowired
	private CsvReaderService csvReaderService;

	@PostMapping("/csvreader")
	public String fileReader(@RequestParam("file") MultipartFile file) {
		String message = null;
		if (CSVHelper.hasCSVFormat(file)) {
			try {
				message = csvReaderService.fileReader(file);
			} catch (Exception e) {
				
				return e.getMessage();
			}
		}
		return message;
	}

	@GetMapping("/csvreaderfromdb")
	public String fileReaderFromDb() {
		String message = null;

		try {
			message = csvReaderService.fileReaderFromDb();
		} catch (Exception e) {
			return "Something bad with controller";
		}
		return message;
	}
}
