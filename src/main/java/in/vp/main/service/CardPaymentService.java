package in.vp.main.service;

import in.vp.main.dto.CardPaymentRequestDto;
import in.vp.main.dto.CardPaymentResponseDto;

public interface CardPaymentService {

	CardPaymentResponseDto payment(CardPaymentRequestDto cardpaymentReqDto);
	

}
