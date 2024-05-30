package in.vp.main.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.This;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import in.vp.main.dto.MoviesRequestDto;
import in.vp.main.dto.MoviesResponseDto;
import in.vp.main.entity.Movies;
import in.vp.main.repository.MoviesRepository;


@Service
public class MoviesServiceImpl implements MoviesService{
@Autowired
MoviesRepository moviesRepository;
@Autowired
ModelMapper modelMapper;
	@Override
	public MoviesResponseDto AddMovies(MoviesRequestDto moviesRequestDto) {
		
		   Movies movies =this.DtoToMovies(moviesRequestDto);
			Movies movies2= moviesRepository.save(movies);
			MoviesResponseDto  moviesResponseDto=  this.moviesTODto(movies2);
			return moviesResponseDto;
	}
  public MoviesResponseDto moviesTODto(Movies movies) {
	 // MoviesResponseDto moviesResponseDto=new MoviesResponseDto();
	  MoviesResponseDto   moviesResponseDto=   this.modelMapper.map(movies, MoviesResponseDto.class);
			   return moviesResponseDto;
	 
  }
  
  public Movies DtoToMovies(MoviesRequestDto moviesResponseDto) {
     // Movies movies= new Movies();
      Movies movies= this.modelMapper.map(moviesResponseDto, Movies.class);

      		return movies;
  }
@Override
public List<Movies> getAllMovies() {
	
	return moviesRepository.findAll();
}
@Override
public  Optional<Movies> getById(UUID movies_id) {
	
	
	return moviesRepository.findById(movies_id);
}

}
