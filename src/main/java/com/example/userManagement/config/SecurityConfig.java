package com.example.userManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;


@Configuration
 @EnableWebSecurity
public class SecurityConfig {

     @Autowired
     AuthSuccess authSuccess;
     @Autowired
     FailedHandler failedHandler;

     @Autowired
    CorsConfigurationSource corsConfigurationSource;
@Bean
public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//    httpSecurity.csrf(AbstractHttpConfigurer::disable).cors(cors->cors.configurationSource(corsConfigurationSource));
    httpSecurity.formLogin(formLogin ->
            formLogin
                    .loginPage("/login").successHandler(authSuccess).failureHandler(failedHandler)
                    .permitAll()
    );
 return httpSecurity.csrf(AbstractHttpConfigurer::disable)
         .authorizeHttpRequests(auth -> auth.requestMatchers("/login/**","/logout/**").permitAll()
                 .anyRequest().authenticated()
         ).build();

 }

  @Bean
  public PasswordEncoder passwordEncoder(){
   return new BCryptPasswordEncoder();
 }

//     @Bean
//     CorsConfigurationSource corsConfigurationSource() {
//         CorsConfiguration configuration = new CorsConfiguration();
//         configuration.setAllowedOrigins(List.of("*"));
//         configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT"));
//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         source.registerCorsConfiguration("/**", configuration);
//         return source;
//     }
}
