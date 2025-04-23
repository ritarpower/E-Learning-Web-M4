//package com.example.elearningwebm4.backend.configuration;
//
//import com.example.elearningwebm4.backend.common.CustomAuthenticationEntryPoint;
//import com.example.elearningwebm4.backend.common.CustomAuthenticationSuccessHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.annotation.web.configurers.RequestCacheConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Autowired
//    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
//    @Autowired
//    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
//
//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        // Chuỗi mã hóa mật khẩu
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/login", "/", "/", "/").permitAll() // Các đường dẫn không cần login
//                        .requestMatchers("/admin/**").hasRole("ADMIN") // Yêu cầu role ADMIN
//                        .requestMatchers("/user/**").hasRole("USER") // Yêu cầu Role USER
//                        .anyRequest().authenticated()
//                )
//                .csrf(AbstractHttpConfigurer::disable)
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .loginProcessingUrl("/perform_login")
//                        .successHandler(customAuthenticationSuccessHandler)
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                        .logoutSuccessUrl("/login")
//                        .deleteCookies("JSESSIONID")
//                        .invalidateHttpSession(true)
//                        .clearAuthentication(true)
//                        .permitAll()
//                )
//                .sessionManagement(session -> session
//                        .invalidSessionUrl("/login")
//                        .maximumSessions(1)
//                        .expiredUrl("/login")
//                )
//                .exceptionHandling(ex -> ex
//                        .authenticationEntryPoint(customAuthenticationEntryPoint)
//                )
//                // Tắt hoàn toàn RequestCache phuc vụ việc redirect về trang cố ý truy cập trước khi đăng nhập
//                .requestCache(RequestCacheConfigurer::disable
//                );
//
//        return http.build();
//    }
//
//}