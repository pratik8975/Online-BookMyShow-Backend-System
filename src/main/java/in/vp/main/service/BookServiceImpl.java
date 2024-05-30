package in.vp.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vp.main.dto.BookingRequestDto;
import in.vp.main.dto.BookingResponseDto;
import in.vp.main.dto.CardPaymentResponseDto;
import in.vp.main.entity.Book_Page;
import in.vp.main.entity.Movies;
import in.vp.main.entity.User;
import in.vp.main.repository.BookRepository;
import in.vp.main.repository.CardPaymentRepository;
import in.vp.main.repository.MoviesRepository;
import in.vp.main.repository.UserRepository;


@Service
public class BookServiceImpl implements BookService {
	
 @Autowired
  UserRepository userRepository;
 @Autowired
 MoviesRepository moviesRepository;
 @Autowired
 BookRepository bookRepository;
 @Autowired
 CardPaymentRepository cardPaymentRepository;
  

	@Override
	public BookingResponseDto addBooking(BookingRequestDto bookingPageReq) {
	
		
		String email=bookingPageReq.getUserEmail();
		User user=userRepository.findByEmail(email);
		
		String	movieName=bookingPageReq.getMoviesName();
	
		Movies	movie=moviesRepository.findByMoviesName(movieName);
		
		
		
		Book_Page bookingpage=new Book_Page();
		bookingpage.setMovies(movie);
		bookingpage.setUser(user);
		
//		Book_Page bbBook_Page=cardPaymentRepository.save(bookno);
		
	
		
		BeanUtils.copyProperties(bookingPageReq, bookingpage);
		Book_Page	addbooking=bookRepository.save(bookingpage);
//		System.out.println(addbooking);
		
		
//		this.modelMapper.map(addbooking, BookingPageResponseDto.class);
		
		BookingResponseDto Book=new BookingResponseDto();
		Book.setId(addbooking.getId());
		Book.setUserName(user.getFirstName());
		Book.setUserEmail(user.getEmail());
		Book.setMoviesName(movie.getMoviesName());
		Book.setMoviesposter(movie.getMoviesPoster());
		Book.setLocation(addbooking.getLocation());
		Book.setTheater(addbooking.getTheater());
		Book.setBookedSeats(addbooking.getBookedSeats());
		Book.setTime(addbooking.getTime());
		Book.setFood(addbooking.getFood());
		Book.setPrice(addbooking.getPrice());
		Book.setTotalPrice(addbooking.getTotalPrice());
		
			 
			
			
		
		
		return Book ;
 }	
	
	@Override
	public List<CardPaymentResponseDto> getAllticket() {
		
		List<CardPaymentResponseDto> getAll=new ArrayList<>();
		
		   List<Book_Page>  getBooking=bookRepository.findAll();
	
		  
		  for(Book_Page book:getBooking) {
			  
			  	CardPaymentResponseDto cp=new CardPaymentResponseDto();
				cp.setUsername(book.getUser().getFirstName());
				cp.setUserEmail(book.getUser().getEmail());
				cp.setMoviesName(book.getMovies().getMoviesName());
				cp.setPoster(book.getMovies().getMoviesPoster());
				cp.setLocation(book.getLocation());
				cp.setTheater(book.getTheater());
				cp.setBookedSeats(book.getBookedSeats());
				cp.setTime(book.getTime());
				cp.setFood(book.getFood());
				cp.setPrice(book.getPrice());
				cp.setTotalPrice(book.getTotalPrice());
				cp.setCardHolder(book.getCardPay().getCardHolder());
				cp.setCardNo(book.getCardPay().getCardNo());
				cp.setExpDate(book.getCardPay().getExpDate());
				cp.setId(book.getCardPay().getId());
			  
			  getAll.add(cp);
			  
		  }
		   
		   
		return getAll;
	}

}
