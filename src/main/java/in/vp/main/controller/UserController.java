package in.vp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vp.main.dto.UserDto;
import in.vp.main.entity.User;
import in.vp.main.service.UserService;
import jakarta.validation.Valid;

@RestController
public class UserController {
@Autowired
 UserService  userservice;
@Autowired
BCryptPasswordEncoder bEncoder;

@PostMapping("/register")
public User adduser(@RequestBody @Valid UserDto userdto) {
	userdto.setPassword(bEncoder.encode(userdto.getPassword()));
	User user=userservice.AddUser(userdto);
	return user;
}


	
	
}
