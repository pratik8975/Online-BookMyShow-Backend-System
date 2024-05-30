package in.vp.main.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
//@Access(AccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Booking_Details")

public class Book_Page {
	@Id
	@GeneratedValue
	@Column(name="Book_id")
	private UUID id;
	private String location;
	private String theater;
	@Size(max = 4,message = "plz booking max 4 seat")
	private List<String> bookedSeats;
	private String time;
	private String food;
	private Integer price;
	private Integer totalPrice;
	
	
	@ManyToOne
	@JoinColumn(name="user_Id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="movies_Id")
	private Movies movies;
	
	@ManyToOne
	@JoinColumn(name = "cardpay_id")
	private CardPaymentTicket cardPay;
	

}
