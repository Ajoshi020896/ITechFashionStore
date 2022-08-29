package com.fashionstore.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SprinterOrderResponseDTO {
	
	private String sprinterName;
	private Long sprinterMobileNo;
	private String sprinterConvenceType;
	
	
	 //BeanUtils.copyProperties(bw.getWrappedInstance(), testBean2);

}
