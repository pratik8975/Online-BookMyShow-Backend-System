package in.vp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vp.main.dto.LoginRequestDto;
import in.vp.main.dto.LoginResponseDto;
import in.vp.main.dto.ResLoginDto;
import in.vp.main.service.LoginService;

@RestController
public class LoginController {
@Autowired
LoginService loginService;
@PostMapping("/login23")
public LoginResponseDto loginuser(@RequestBody LoginRequestDto loginRequestDto) {
	
	return loginService.LoginUser(loginRequestDto);
}


@PostMapping("/login")
public ResponseEntity<ResLoginDto> authenticateAndGetToken(@RequestBody LoginRequestDto loginRequestDto) {
	
	ResLoginDto resLoginDto = loginService.authenticateAndGetToken(loginRequestDto);
	
	if(resLoginDto!=null) {
		return new ResponseEntity<>(resLoginDto, HttpStatus.CREATED);
	}else {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

}
