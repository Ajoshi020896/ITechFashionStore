package com.fashionstore.ServiceImpl;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fashionstore.Entities.CsvFileReader;
import com.fashionstore.Repository.CsvReaderRepository;
import com.fashionstore.Service.CsvReaderService;
import com.opencsv.CSVWriter;

@Service
public class CsvReaderServiceImpl implements CsvReaderService {

	@Autowired
	private CsvReaderRepository csvReaderRepository;

	@Override
	public String fileReader(MultipartFile file) throws IOException {

		InputStream is = file.getInputStream();

		BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		CSVParser csvParser = new CSVParser(fileReader,
				CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

		List<CSVRecord> csvRecords = csvParser.getRecords();
		List<CsvFileReader> finalList = new ArrayList();

		for (CSVRecord csvRecord : csvRecords) {
			CsvFileReader csvFileReader = new CsvFileReader();
			csvFileReader.setId(csvRecord.get("id"));
			csvFileReader.setName(csvRecord.get("name"));
			csvFileReader.setSurname(csvRecord.get("surname"));
			csvFileReader.setAge(csvRecord.get("age"));
			csvFileReader.setProfession(csvRecord.get("profession"));
			finalList.add(csvFileReader);
		}
		List<CsvFileReader> list = csvReaderRepository.saveAll(finalList);

		if (list.isEmpty()) {
			return "API not Working";

		} else {
			return "hurrah !! API is working";
		}

	}

	@Override
	public String fileReaderFromDb() throws IOException {
		System.out.println("working");
		CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\HP\\Desktop\\New folder\\sample.csv"));
		System.out.println("csvgenerated");
		List<CsvFileReader> dbData=csvReaderRepository.findAll();
		System.out.println("got the data");
		String[] headings= {"id","age","name","surname","profession"};
		writer.writeNext(headings);
		System.out.println("headings set");
		
		for(CsvFileReader reader:dbData) {
			String[] s=new String[5];
			s[0]=reader.getId();
			s[1]=reader.getAge();
			s[2]=reader.getName();
			s[3]=reader.getProfession();
			s[4]=reader.getSurname();
			writer.writeNext(s);
			System.out.println("API WOrkING FINES");
			
		}
		
		return null;
		
		
		
	}
}
