package in.vp.main.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.vp.main.dto.LoginRequestDto;
import in.vp.main.dto.LoginResponseDto;
import in.vp.main.dto.ResLoginDto;
import in.vp.main.dto.UserDto;
import in.vp.main.entity.User;
import in.vp.main.repository.UserRepository;


@Service
public class LoginServiceImpl implements LoginService{
@Autowired
UserRepository userRepository;

@Autowired
private ModelMapper modelMapper;

@Autowired
private AuthenticationManager authenticationManager;

@Autowired
private JwtService jwtService;

	@Override
	public LoginResponseDto LoginUser(LoginRequestDto loginRequestDto) {
		
		LoginResponseDto loginResponceDto=new LoginResponseDto();
		User user=userRepository.findByEmailAndPassword(loginRequestDto.getEmail(), loginRequestDto.getPassword());
		BeanUtils.copyProperties(user, loginResponceDto);
		return loginResponceDto;
	}
	
	@Override
	public ResLoginDto authenticateAndGetToken(LoginRequestDto loginRequestDto) {
		System.out.println("authentication start");
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword()));
		System.out.println("authentication end");
		
		if(authentication.isAuthenticated()) {
			final String token = jwtService.generateToken(loginRequestDto.getEmail());
			
			User user = userRepository.findByEmail(loginRequestDto.getEmail());
		
			ResLoginDto resLoginDto = new ResLoginDto();
			resLoginDto.setUser(this.modelMapper.map(user, UserDto.class));
			resLoginDto.setAuth(token);
			
			return resLoginDto;
		}else {
			throw new UsernameNotFoundException("invalid user request !");
		}
	}

	

}
