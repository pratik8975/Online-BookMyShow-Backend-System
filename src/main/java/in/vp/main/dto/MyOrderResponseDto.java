package in.vp.main.dto;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class MyOrderResponseDto {
	private UUID Cardid;
	private String username;
	private String userEmail;
	private String movieName;
	private String poster;
	private String location;
	private String theater;
	private List<String> bookedSeats;
	private String time;
	private String food;
	private Integer totalPrice;
	private Integer price;
	private String cardHolder;
	private String cardNo;
	private String expDate;
}
