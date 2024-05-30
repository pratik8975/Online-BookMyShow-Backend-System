package in.vp.main.dto;

import java.sql.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class MoviesResponseDto {
	   private UUID movies_id;
	    private String moviesPoster;
	    private String moviesName;
	    private Date releaseDate;
	    private String category;
	    private String genre;
	    private float rating;
	    private String country;
}
