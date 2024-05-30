package in.vp.main.dto;

import java.util.List;

import lombok.Data;
@Data
public class BookingRequestDto {
	private String userName;
	private String userEmail;
	private String moviesName;
	private String moviesposter;
	private String location;
	private String theater;
	private List<String> bookedSeats;
	private String time;
	private String food;
	private Integer price;
	private Integer totalPrice;

}
