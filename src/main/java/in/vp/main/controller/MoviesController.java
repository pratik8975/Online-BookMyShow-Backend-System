package in.vp.main.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vp.main.dto.MoviesRequestDto;
import in.vp.main.dto.MoviesResponseDto;
import in.vp.main.entity.Movies;
import in.vp.main.service.MoviesService;


@RestController
public class MoviesController {
@Autowired
MoviesService moviesService;

@PostMapping("/addmovies")
public MoviesResponseDto Addmoviesname(@RequestBody  MoviesRequestDto moviesRequestDto) {
	
	return moviesService.AddMovies(moviesRequestDto);
}
 
@GetMapping("/getmovies")
public java.util.List<Movies> getAllMovies(){
	
	return moviesService.getAllMovies();
}
@GetMapping("get/{movies_id}")
public Optional<Movies> getByIdMovies(@PathVariable UUID movies_id) {
	
	return moviesService.getById(movies_id);
}

}
