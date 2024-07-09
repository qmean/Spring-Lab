package study.ch06.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.ch06.entity.User;
import study.ch06.enumerated.EncryptAlgorithm;
import study.ch06.repository.UserRepository;
import study.ch06.userdetails.CustomUserDetails;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthenticationManagerService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public UserDetails join(String username, String password) {
        User user = User.builder()
                .username(username)
                .password(bCryptPasswordEncoder.encode(password))
                .algorithm(EncryptAlgorithm.BCRYPT)
                .build();
        userRepository.save(user);
        return new CustomUserDetails(user);
    }
}
