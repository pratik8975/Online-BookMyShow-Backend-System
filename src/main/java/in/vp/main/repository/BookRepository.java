package in.vp.main.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.vp.main.entity.Book_Page;

public interface BookRepository extends JpaRepository<Book_Page, UUID> {




	@Query("SELECT b FROM Book_Page b WHERE b.user.user_Id = :user_Id AND b.movies.movies_Id = :movies_Id")
	Book_Page findByUserIdAndMoviesId(@Param("user_Id") UUID userId, @Param("movies_Id") UUID moviesId);
	
	@Query("SELECT b FROM Book_Page b JOIN b.user u WHERE u.email= :email")
	List<Book_Page> findByEmail(String email);
}
