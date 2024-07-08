package study.ch03.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class InMemoryUserDetailService implements UserDetailsService {

    private final List<UserDetails> users;

    public InMemoryUserDetailService(List<UserDetails> users) {
        this.users = users;
    }

    /**
     * 사용자 이름을 받아서 사용자 정보를 찾아서 반환
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream()
                .filter((u) -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
