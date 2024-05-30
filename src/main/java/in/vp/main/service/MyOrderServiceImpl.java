package in.vp.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vp.main.dto.MyOrderResponseDto;
import in.vp.main.entity.Book_Page;
import in.vp.main.repository.BookRepository;
import in.vp.main.repository.UserRepository;

@Service
public class MyOrderServiceImpl implements MYOrderService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	BookRepository bookRepository;

	@Override
	public List<MyOrderResponseDto> allOrders(String email) {
		
		ArrayList<MyOrderResponseDto>	myorder=new ArrayList();
		List<Book_Page> book_Page= bookRepository.findByEmail(email);
		
		
   for(Book_Page mybook : book_Page) {
			
			MyOrderResponseDto order=new MyOrderResponseDto();
			order.setCardid(mybook.getCardPay().getId());
			order.setUsername(mybook.getUser().getFirstName());
			order.setUserEmail(mybook.getUser().getEmail());
			order.setMovieName(mybook.getMovies().getMoviesName());
			order.setPoster(mybook.getMovies().getMoviesPoster());
			order.setLocation(mybook.getLocation());
			order.setTheater(mybook.getTheater());
			order.setBookedSeats(mybook.getBookedSeats());
			order.setTime(mybook.getTime());
			order.setFood(mybook.getFood());
			order.setPrice(mybook.getPrice());
			order.setTotalPrice(mybook.getTotalPrice());
			order.setCardNo(mybook.getCardPay().getCardNo());
			order.setCardHolder(mybook.getCardPay().getCardHolder());
			order.setExpDate(mybook.getCardPay().getExpDate());
			
			myorder.add(order);
			
			
		}
		return myorder;
	}
	

}
