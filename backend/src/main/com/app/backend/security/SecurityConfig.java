package com.main.app.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SecurityConfig{
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private JwtAuthenticationFiler JwtAuthenticationFiler;

    @Bean
    public DaoAuthenticationManager authenticationManager(
        AuthenticationConfiguration authConfig) throws Exeption {
            return authConfig.getAuthenticationManager();
        }

    @Bean
    public DaoAuthenticationProvider authenProvieder(){
        DaoAuthenticationProvider authenticationProvider = new 
        DaoAuthenticationProvider();
        authProvieder.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterchain (HttpSecurity http) throws Exception{
        http 
        .cors(cors -> cors.configurationSource(corsConfigurationSource()))
        .cors(csrf -> csrf.disable())
        .sessionManagement(session -> session
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(...patterns: "/api/auth/**").
            permitAll()
            .anyRequest().authenticated());
        
        http.authenticationProvider(authenProvieder());
        http.addFilterBefore(JwtAuthenticationFiler,
        betforeFilter: UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(...a:"*"));
        configuration.setAllowedMethods(Arrays.asList(...a:"GET",
        "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList(...a: "*"));
        UrlBasedCorsConfigurationSource source = new
        UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}