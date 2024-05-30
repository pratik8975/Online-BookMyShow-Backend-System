package in.vp.main.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vp.main.dto.CardPaymentRequestDto;
import in.vp.main.dto.CardPaymentResponseDto;
import in.vp.main.entity.Book_Page;
import in.vp.main.entity.CardPaymentTicket;
import in.vp.main.entity.Movies;
import in.vp.main.entity.User;
import in.vp.main.exception.ResourceNotFoundException;
import in.vp.main.repository.BookRepository;
import in.vp.main.repository.CardPaymentRepository;
import in.vp.main.repository.MoviesRepository;
import in.vp.main.repository.UserRepository;

@Service

public class CardPaymentServiceImpl  implements CardPaymentService{

	@Autowired
	BookRepository bookingRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	MoviesRepository movieRepo;
	
	@Autowired
	CardPaymentRepository cardPaymentRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	
	
	@Override
	public CardPaymentResponseDto payment(CardPaymentRequestDto cardReq) {
		
	String userEmail=cardReq.getUserEmail();
	User user=userRepo.findByEmail(userEmail);
	
	if(user==null) {
		throw new ResourceNotFoundException("user is not found"+user.getEmail());
	}
	
		String	movieName=cardReq.getMoviesName();
		Movies	movie=movieRepo.findByMoviesName(movieName);
		
		if(movie==null) {
			throw new ResourceNotFoundException("movie name is not found"+movie.getMoviesName());
		}
		
		//BookingPage   bookingpage=bookingRepo.findByUser(user);
		Book_Page bookingpage=bookingRepo.findByUserIdAndMoviesId(user.getUser_Id(), movie.getMovies_Id());
		
		if(bookingpage==null) {
			throw new ResourceNotFoundException("booking details is not found based on Movie name: "+movie.getMoviesName()+" and Username: "+user.getEmail());
		}
		
		
			CardPaymentTicket card=new CardPaymentTicket();
//			card.setBookingPage(bookingpage);
			
			BeanUtils.copyProperties(cardReq,card);
							
			CardPaymentTicket	card1=cardPaymentRepo.save(card);
		      bookingpage.setCardPay(card1);
		      bookingRepo.save(bookingpage);
			
				CardPaymentResponseDto cardResponse=new CardPaymentResponseDto();
				cardResponse.setId(card1.getId());
				cardResponse.setUsername(bookingpage.getUser().getFirstName());
				cardResponse.setUserEmail(bookingpage.getUser().getEmail());
				cardResponse.setMoviesName(bookingpage.getMovies().getMoviesName());
				cardResponse.setPoster(bookingpage.getMovies().getMoviesPoster());
				cardResponse.setLocation(bookingpage.getLocation());
				cardResponse.setTheater(bookingpage.getTheater());
				cardResponse.setBookedSeats(bookingpage.getBookedSeats());
				cardResponse.setTime(bookingpage.getTime());
				cardResponse.setFood(bookingpage.getFood());
				cardResponse.setPrice(bookingpage.getPrice());
				cardResponse.setTotalPrice(bookingpage.getTotalPrice());
				cardResponse.setCardNo(card1.getCardNo());
				cardResponse.setCardHolder(card1.getCardHolder());
				cardResponse.setExpDate(card1.getExpDate());
		
		
		return cardResponse;
	}

}
