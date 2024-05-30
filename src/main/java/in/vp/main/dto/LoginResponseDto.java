package in.vp.main.dto;

import java.sql.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class LoginResponseDto {
	private String firstName;
	private String lastName;
	private Date dob;
	private String email;
	private UUID user_Id;
}
