package in.vp.main.config;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import in.vp.main.entity.User;


public class CustomUserDetails implements UserDetails {
	
	private User user;
	
	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("getAuthorities");
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getFirstName());
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		System.out.println("getPassword");
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		System.out.println("getUsername");
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		System.out.println("isAccountNonExpired");
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		System.out.println("isAccountNonLocked");
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		System.out.println("isCredentialsNonExpired");
		return true;
	}

	@Override
	public boolean isEnabled() {
		System.out.println("isEnabled");
		return true;
	}

}
