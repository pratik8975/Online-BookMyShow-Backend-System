package in.vp.main.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vp.main.entity.Movies;

public interface MoviesRepository extends JpaRepository<Movies, UUID> {

	Movies findByMoviesName(String movieName);

}
