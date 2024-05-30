package in.vp.main.entity;

import java.util.List;
import java.util.UUID;

import org.aspectj.internal.lang.annotation.ajcPrivileged;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
//@Access(AccessType.FIELD)
@Data
@NoArgsConstructor
@ajcPrivileged
@Table(name = "cardpay_id")
public class CardPaymentTicket {
	@Id
	@GeneratedValue
	@Column(name="cardpay_id")
	private UUID id;
	
	private String cardHolder;
	
	private String cardNo;
	
	private String expDate;
	
	
	@OneToMany(mappedBy = "cardPay",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	
	private List<Book_Page> bookingPage;

}
