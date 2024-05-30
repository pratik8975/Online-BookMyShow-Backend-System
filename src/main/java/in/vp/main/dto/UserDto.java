package in.vp.main.dto;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {
	@NotNull(message = "firstName should  not be null")
	private String firstName;
	@NotNull(message = "lastName should  not be null")
	private String lastName;
	@NotNull(message = "dob should  not be null")
	private Date dob;
	@Column(unique = true)
	@Email(message = " plz enter valid email")
	private String email;
	@NotNull(message = "password should  not be null")
	private String password;
}
