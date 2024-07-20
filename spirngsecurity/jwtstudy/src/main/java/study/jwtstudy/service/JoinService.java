package study.jwtstudy.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import study.jwtstudy.dto.JoinDto;
import study.jwtstudy.entity.UserEntity;
import study.jwtstudy.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class JoinService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public void joinProcess(JoinDto joinDto) {

		String username = joinDto.getUsername();
		String password = joinDto.getPassword();

		boolean isExist = userRepository.existsByUsername(username);

		if (isExist) {
			return ;
		}

		UserEntity data = new UserEntity();
		data.setUsername(username);
		data.setPassword(bCryptPasswordEncoder.encode(password));
		data.setRole("ROLE_ADMIN");

		userRepository.save(data);
	}
}
