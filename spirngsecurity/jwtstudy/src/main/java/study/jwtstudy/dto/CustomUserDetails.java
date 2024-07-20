package study.jwtstudy.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.RequiredArgsConstructor;
import study.jwtstudy.entity.UserEntity;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

	public final UserEntity userEntity;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection = new ArrayList<>();

		collection.add((GrantedAuthority)userEntity::getRole);

		return collection;
	}

	@Override
	public String getPassword() {
		return userEntity.getPassword();
	}

	@Override
	public String getUsername() {
		return userEntity.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
