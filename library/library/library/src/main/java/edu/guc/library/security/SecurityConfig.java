package edu.guc.library.security;

import edu.guc.library.domain.LibraryManager;
import edu.guc.library.service.UserDetailsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletResponse;

import static java.lang.String.format;

@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final JwtTokenFilter jwtTokenFilter;

    public SecurityConfig(UserDetailsService userDetailsService, JwtTokenFilter jwtTokenFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenFilter = jwtTokenFilter;
    }
    @Override
    protected void configure( AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(email -> (UserDetails) userDetailsService
                .findByEmail(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException(
                                format("User: %s, not found", email)
                        )
                )
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http = http.cors().and().csrf().disable();

        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        http = http
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            response.sendError(
                                    HttpServletResponse.SC_UNAUTHORIZED,
                                    ex.getMessage()
                            );
                        }
                )
                .and();

        http.authorizeRequests()
                .antMatchers("/api/public/login").permitAll()
                .antMatchers(HttpMethod.GET, "/api/author/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/author").hasRole("LibraryManager")
                .antMatchers(HttpMethod.DELETE, "/api/author").hasRole("LibraryManager")
                .antMatchers(HttpMethod.PUT, "/api/author").hasRole("LibraryManager")
                .antMatchers(HttpMethod.GET, "/user/view/**").hasRole("LibraryManager")
                .antMatchers(HttpMethod.DELETE, "/user/remove").hasRole("LibraryManager")
                .antMatchers(HttpMethod.PUT, "/user/update").hasRole("LibraryManager")
                .antMatchers(HttpMethod.POST, "/user/add").hasRole("LibraryManager")
                .antMatchers(HttpMethod.GET, "/book/view/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/book/remove").hasRole("LibraryManager")
                .antMatchers(HttpMethod.POST, "/book/add").hasRole("LibraryManager")
                .antMatchers(HttpMethod.GET, "/borrowing/view").permitAll()
                .antMatchers(HttpMethod.POST, "/borrowing/add").hasRole("LibraryManager")
                .antMatchers(HttpMethod.DELETE, "/borrowing/remove").hasRole("LibraryManager")
                .antMatchers(HttpMethod.PUT, "/borrowing/update").hasRole("LibraryManager")
                .anyRequest().authenticated();

        http.addFilterBefore(
                jwtTokenFilter,
                UsernamePasswordAuthenticationFilter.class
        );
    }

    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
