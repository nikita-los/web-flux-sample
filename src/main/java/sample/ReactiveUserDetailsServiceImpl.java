package sample;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Mono;


public class ReactiveUserDetailsServiceImpl implements ReactiveUserDetailsService {

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        if (username.equals("user")) {
            return Mono.just(User.withUserDetails(
                    User.builder()
                            .username(username)
                            .password("password")
                            .roles("user").build()).build());
        }
        return Mono.empty();
    }
}
