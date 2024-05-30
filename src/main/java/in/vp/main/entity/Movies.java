package in.vp.main.entity;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
//@Access(AccessType.FIELD)
@Data
@NoArgsConstructor
@Table(name = "Movies_details")
public  class Movies {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movies_Id")
    private UUID movies_Id;
    private String moviesPoster;
    private String moviesName;
    private Date releaseDate;
    private String category;
    private String genre;
    private float rating;
    private String country;

}
