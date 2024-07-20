package study.oauth2basic.service;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import study.oauth2basic.dto.CustomOAuth2User;
import study.oauth2basic.dto.GoogleResponse;
import study.oauth2basic.dto.NaverResponse;
import study.oauth2basic.dto.OAuth2Response;
import study.oauth2basic.entity.UserEntity;
import study.oauth2basic.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

	private final UserRepository userRepository;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oAuth2User = super.loadUser(userRequest);
		log.info("OAuth2User: {}", oAuth2User);

		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		OAuth2Response oAuth2Response;
		if (registrationId.equals("naver")) {
			oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
		} else if (registrationId.equals("google")) {
			oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
		} else {
			return null;
		}

		String username = oAuth2Response.getProvider() + " " + oAuth2Response.getProviderId();

		UserEntity existData = userRepository.findByUsername(username);
		String role = "ROLE_USER";

		if (existData == null) {
			UserEntity user = new UserEntity();

			user.setUsername(username);
			user.setEmail(oAuth2Response.getEmail());
			user.setRole(role);

			userRepository.save(user);
		} else {
			role = existData.getRole();
			existData.setEmail(oAuth2Response.getEmail());

			userRepository.save(existData);
		}

		return new CustomOAuth2User(oAuth2User, oAuth2Response, role);
	}
}
