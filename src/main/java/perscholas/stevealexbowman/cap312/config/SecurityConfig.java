package perscholas.stevealexbowman.cap312.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import perscholas.stevealexbowman.cap312.service.CustomUserDetailsService;


@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }
    @Bean
    public FilterRegistrationBean<HiddenHttpMethodFilter> hiddenHttpMethodFilter() {
        FilterRegistrationBean<HiddenHttpMethodFilter> filterRegistrationBean = new FilterRegistrationBean<>(new HiddenHttpMethodFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/about", "/subscribe", "/css/**", "/img/**", "/assets/**", "/login", "/register", "/recycle/**", "recycle/update/").permitAll() // Allow access to static resources
                        .requestMatchers("/recycle", "/history", "/users/**").authenticated() // Restrict access to specific pages
                        .anyRequest().authenticated() // Ensure all other requests are authenticated
                )
                .formLogin(form -> form
                        .loginPage("/login") // Set the custom login page
                        .defaultSuccessUrl("/", true) // Redirect to the home page after login
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/") // Redirect to home after logout
                        .permitAll()
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/about", "/api/**", "/recycle/**", "recycle/update/**", "recycle/delete/**") // Exclude specific endpoints from CSRF protection
                )
                .exceptionHandling(ex -> ex
                        .accessDeniedPage("/access-denied") // Handle access denied exceptions
                );
        return http.build();

    }
}
