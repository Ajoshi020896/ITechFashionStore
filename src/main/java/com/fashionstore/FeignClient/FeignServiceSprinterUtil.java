package com.fashionstore.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "SprinterFeign", url = "http://localhost:8082/itechfashionstoreservice1/sprinter")
public interface FeignServiceSprinterUtil {
	
	@GetMapping("/getallproductsbysprinter")
	ResponseEntity<?> getallproductsbysprinter();

}
