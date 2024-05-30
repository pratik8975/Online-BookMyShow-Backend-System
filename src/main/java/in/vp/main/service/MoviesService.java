package in.vp.main.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import in.vp.main.dto.MoviesRequestDto;
import in.vp.main.dto.MoviesResponseDto;
import in.vp.main.entity.Movies;

public interface MoviesService {

	public MoviesResponseDto AddMovies(MoviesRequestDto moviesRequestDto);

	public List<Movies> getAllMovies();

	public Optional<Movies>  getById(UUID movies_id);

}
