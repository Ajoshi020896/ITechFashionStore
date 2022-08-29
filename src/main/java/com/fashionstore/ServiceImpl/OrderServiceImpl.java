package com.fashionstore.ServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashionstore.DTO.AddingOrdersDTO;
import com.fashionstore.DTO.CustomerOrderResponseDTO;
import com.fashionstore.DTO.FinalOrderResponseDTO;
import com.fashionstore.DTO.ProductOrderResponseDTO;
import com.fashionstore.DTO.SprinterOrderResponseDTO;
import com.fashionstore.Entities.Customer;
import com.fashionstore.Entities.Order;
import com.fashionstore.Entities.OrderStatus;
import com.fashionstore.Entities.Product;
import com.fashionstore.Entities.Sprinter;
import com.fashionstore.Exception.BusinessException;
import com.fashionstore.Repository.CustomerRepository;
import com.fashionstore.Repository.OrderRepository;
import com.fashionstore.Repository.SprinterRepository;
import com.fashionstore.Service.OrderService;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private SprinterRepository sprinterRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public FinalOrderResponseDTO addOrder(AddingOrdersDTO addingOrdersDTO) {

		Customer dBCustomer = null;

		FinalOrderResponseDTO finalResponse = new FinalOrderResponseDTO();

		SprinterOrderResponseDTO sprinterResponse = new SprinterOrderResponseDTO();// inside final response

		//Sprinter sprinterFromOptional = null;

		Optional<Customer> optionalCustomer = customerRepository.findById(addingOrdersDTO.getCustomerId());
		if (optionalCustomer.isEmpty()) {

			throw new BusinessException("601",
					"Customer with given " + addingOrdersDTO.getCustomerId() + " not present");
		}

		else {

			dBCustomer = optionalCustomer.get();
			CustomerOrderResponseDTO responseCustomer = new CustomerOrderResponseDTO();
			responseCustomer.setCustomerId(dBCustomer.getCustomerId());
			responseCustomer.setCustomerName(dBCustomer.getCustomerName());
			responseCustomer.setCustomerMobileNo(dBCustomer.getCustomerMobileNo());
			responseCustomer.setCustomerAddress(dBCustomer.getCustomerAddress());
		}

		Optional<Sprinter> optionalSprinter = sprinterRepository.findById(addingOrdersDTO.getSprinterId());
		if (optionalSprinter.isEmpty()) {

			throw new BusinessException("601",
					"Sprinter with given Id " + addingOrdersDTO.getSprinterId() + " not present");
		}

		Sprinter sprinterFromOptional = optionalSprinter.get();
		String sprinterName = sprinterFromOptional.getSprinterName();

		BeanUtils.copyProperties(sprinterFromOptional,sprinterResponse);

		List<Product> products = addingOrdersDTO.getProducts();

		Order order = new Order();
		order.setOrderStatus(OrderStatus.PENDING);
		order.setOrderType(addingOrdersDTO.getOrderType());

	

		order.setDelieveryBy(sprinterName);
		order.setDelieveryDate(new Date());

		order.setCustomer(dBCustomer);
		order.setOrderDate(new Date());
		order.setProducts(products);
		order.setSprinter(sprinterFromOptional);
		
		Order dBOrder=null;
       try
       {
	      dBOrder = orderRepository.save(order);// saving object to db
       }
       catch(Exception e) {
    	   e.printStackTrace();
    	   System.out.println("saving not working");
       }

		finalResponse.setOrderId(dBOrder.getOrderId());
		finalResponse.setOrderStatus(dBOrder.getOrderStatus());

		CustomerOrderResponseDTO finalCustomerOrderResponseDTO = new CustomerOrderResponseDTO();

		finalCustomerOrderResponseDTO.setCustomerId(dBOrder.getCustomer().getCustomerId());
		finalCustomerOrderResponseDTO.setCustomerName(dBOrder.getCustomer().getCustomerName());
		finalCustomerOrderResponseDTO.setCustomerMobileNo(dBOrder.getCustomer().getCustomerMobileNo());
		finalCustomerOrderResponseDTO.setCustomerAddress(dBOrder.getCustomer().getCustomerAddress());
		finalResponse.setCustomerResponse(finalCustomerOrderResponseDTO);

		List<Product> dBOrderProducts = dBOrder.getProducts();

		Double TotalOrderPrice = 0.0;

		for (Product product : dBOrderProducts) {

			TotalOrderPrice = TotalOrderPrice + product.getProductPrice();
		}

		List<ProductOrderResponseDTO> finalProductOrderResponseDTO = dBOrderProducts.stream()
				.map(product -> modelMapper.map(product, ProductOrderResponseDTO.class)).collect(Collectors.toList());

		finalResponse.setProductResponse(finalProductOrderResponseDTO);
		finalResponse.setProductCount((long) products.size());
		finalResponse.setTotalOrderPrice(TotalOrderPrice);
		finalResponse.setSprinterResponse(sprinterResponse);

		return finalResponse;

	}
}
