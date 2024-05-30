package in.vp.main.service;

import java.util.List;

import in.vp.main.dto.MyOrderResponseDto;

public interface MYOrderService {

	List<MyOrderResponseDto> allOrders(String email);

}
