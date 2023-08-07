package project.cheap9.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // configure HTTP security here ...
        http
                .csrf().disable()
                .authorizeRequests().antMatchers("/**").permitAll()
                .and()
                .httpBasic();
//                .authorizeRequests()
//                .antMatchers("/api/admin/orders").hasAuthority("ADMIN")
//                .antMatchers("/api/orders/detail").hasAuthority("USER")
//                .anyRequest().permitAll();
        return http.build();
    }

//    public WebSecurityCostomizer webSecurityCostomizer() {
//
//        // configure web security here ...
//    }
}