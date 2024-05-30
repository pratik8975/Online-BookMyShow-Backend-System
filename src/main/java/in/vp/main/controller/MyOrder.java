package in.vp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import in.vp.main.dto.MyOrderResponseDto;
import in.vp.main.service.MYOrderService;

@RestController
public class MyOrder {
	@Autowired
	MYOrderService myOrderService;

	@PostMapping("/myorder/{email}")
	public ResponseEntity<List<MyOrderResponseDto>> getAllOrders(@PathVariable String email){
		
		return new ResponseEntity<List<MyOrderResponseDto>>(myOrderService.allOrders(email),HttpStatus.OK);
	}
}
