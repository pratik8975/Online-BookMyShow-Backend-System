package in.vp.main.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MoviesRequestDto {
    private String moviesPoster;
    private String moviesName;
    private Date releaseDate;
    private String category;
    private String genre;
    private float rating;
    private String country;

}
