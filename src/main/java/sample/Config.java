package sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * Created by Nikita Los on 9/9/2021.
 */
@Configuration
public class Config {

    @Bean
    public PasswordEncoder encoder() {
        return new ReactivePasswordEncoder();
    }

    @Bean
    @Primary
    public ReactiveUserDetailsService userDetailsService() {
        return new ReactiveUserDetailsServiceImpl();
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE + 1)
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http.csrf().disable()
                .authorizeExchange()
                .anyExchange().authenticated()
                .and()
                .httpBasic()
                .and()
                .build();
    }
}
