package etf.ip.authconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.XorCsrfTokenRequestAttributeHandler;

import etf.ip.model.Role;
import etf.ip.model.Users;
import etf.ip.service.UsersService;


@Configuration
@EnableWebSecurity
public class SecurityConfig{		//implements WebSecurityConfigurer
	@Autowired
    private UsersService userService;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
    private JwtRequestFilter jwtFilter;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			//.csrf(csrf -> csrf.csrfTokenRequestHandler(new XorCsrfTokenRequestAttributeHandler()))
			//.csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests( (authorize) -> 
				authorize
				/* .requestMatchers("/api/v1/add/program/**",
								 "/api/v1/add/comment/**"
								).hasRole(Role.LOGGED_USER.toString()) */
				
				.requestMatchers(
								"/api/v1/**"
								
								/*
								"/api/v1/login/**",
                				"/api/v1/logout/**",
                				"/api/v1/register/**",
                				"/api/v1/programs/**",
                				"/api/v1/comments/**",
                				"/api/v1/search/**",
                				"/api/v1/categories/**",
                				"/api/v1/commenter/**",
                				"/api/v1/rss-feed/**",
                				"/api/v1/enroll/**",
                				"/api/v1/add/subscription/**",
                				
                				"/api/v1/add/comment/**",
                				"/api/v1/add/program/**",
                				
                				"/api/v1/get-enrolled-programs/**",
                				"/api/v1/get-created-programs/**",
                				"/api/v1/user/**"
                				*/
                				)
				.permitAll()
                .anyRequest().authenticated()
			)
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))		// Because of JWT
			.authenticationManager(authenticationManager())
			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
			//.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	
	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
        return new AuthenticationManager() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String username = authentication.getName();
                String password = authentication.getCredentials().toString();

                Users userDetails = (Users) userService.loadUserByUsername(username);
                        

                if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                    throw new BadCredentialsException("Incorrect username or password");
                }

                return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
            }
        };
    }
	
}
