package in.vp.main.service;

import java.util.List;

import in.vp.main.dto.BookingRequestDto;
import in.vp.main.dto.BookingResponseDto;
import in.vp.main.dto.CardPaymentResponseDto;
import jakarta.validation.Valid;

public interface BookService {

	BookingResponseDto addBooking(@Valid BookingRequestDto bookingReq);

	List<CardPaymentResponseDto> getAllticket();
	

}
