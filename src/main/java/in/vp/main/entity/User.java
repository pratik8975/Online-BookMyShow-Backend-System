package in.vp.main.entity;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Access(AccessType.FIELD)
@Data
@NoArgsConstructor
@Table(name = "User_details")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "User_Id")
	private UUID user_Id;
	@NotNull(message = "firstName should  not be null")
	private String firstName;
	private String lastName;
	private Date dob;
	@Column(unique = true)
	@Email(message = " plz enter valid email")
	private String email;
	@JsonIgnore
	private String password;
	
	
//	@CreationTimestamp
////	@Column(name="create_at",nullable = false,updatable = false)
//	@Column(name="create_at")
//	private Timestamp create_at;
//	
//	@UpdateTimestamp
//	@Column(name="update_at")
//	private Timestamp update_at;
	@JsonIgnore
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Book_Page> bookingpage=new ArrayList<>();
	
}
