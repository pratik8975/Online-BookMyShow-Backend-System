package in.vp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vp.main.dto.BookingRequestDto;
import in.vp.main.dto.BookingResponseDto;
import in.vp.main.dto.CardPaymentResponseDto;
import in.vp.main.service.BookService;
import jakarta.validation.Valid;

@RestController
public class BookController {
	@Autowired 
	BookService bookService;
	@PostMapping("/book_now")
	public ResponseEntity<BookingResponseDto>  addBooking(@Valid @RequestBody BookingRequestDto bookingReq){
		
		return new ResponseEntity<BookingResponseDto>(bookService.addBooking(bookingReq),HttpStatus.CREATED);
	}
	
	@GetMapping("/view-tickets")
	public ResponseEntity<List<CardPaymentResponseDto>> getAllTicket(){
		
		return new ResponseEntity<List<CardPaymentResponseDto>>(bookService.getAllticket(),HttpStatus.OK);
		
	}
	

}
