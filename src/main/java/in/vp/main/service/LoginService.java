package in.vp.main.service;

import in.vp.main.dto.LoginRequestDto;
import in.vp.main.dto.LoginResponseDto;
import in.vp.main.dto.ResLoginDto;

public interface LoginService {

	public LoginResponseDto LoginUser(LoginRequestDto loginRequestDto);

	public ResLoginDto authenticateAndGetToken(LoginRequestDto loginRequestDto);

}
