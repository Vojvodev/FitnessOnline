package etf.ip.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import etf.ip.authconfigure.AuthenticationRequest;
import etf.ip.authconfigure.AuthenticationResponse;
import etf.ip.authconfigure.JwtUtil;
import etf.ip.model.Programs;
import etf.ip.model.Users;
import etf.ip.repository.UsersRepository;
import etf.ip.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/")
public class UsersController {
	@Autowired
	private UsersRepository usersRep;
	
	@Autowired
    private UsersService userService;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
    private JwtUtil jwtUtil;
	
	
	
	@PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Users user) {
        userService.save(user);
        return ResponseEntity.ok("User registered successfully");
    }
	
	
	@PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        
        Users userDetails = userService.findByUsername(authenticationRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        final String jwt = jwtUtil.generateToken(userDetails);
          
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
	
	
	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpServletRequest request) {
	    String token = extractTokenFromRequest(request);
	    
	    // Add the token to the blacklist
	    jwtUtil.addToBlacklist(token);
	    
	    return ResponseEntity.ok("Logged out successfully");
	}
	
	
	// get all users
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		return usersRep.findAll();
	}
	
	
	// get user by username
	@GetMapping("/user")
	public Users getUserByUsername(@RequestParam String username) {
		return loadUserByUsername(username);
	}
	
	
	@PutMapping("/enroll")
    public ResponseEntity<?> addProgramToUser(@RequestParam String username, @RequestParam int programId) {
        userService.addProgramToUser(username, programId);
        return ResponseEntity.ok().build();
    }
	
	
	private String extractTokenFromRequest(HttpServletRequest request) {
	    String bearerToken = request.getHeader("Authorization");
	    if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
	        return bearerToken.substring(7);
	    }
	    return null;
	}
	
	
    public Users loadUserByUsername(String username){
        Users user = usersRep.findByUsername(username).orElseThrow();
        return user;
    }
    
    
    @GetMapping("/get-enrolled-programs")
	public List<Programs> getEnrolled(@RequestParam String username){
		 Users user = loadUserByUsername(username);
		 
		 return user.getEnrolledPrograms();
	}
    
    @GetMapping("/get-created-programs")
	public List<Programs> getCreated(@RequestParam String username){
		 Users user = loadUserByUsername(username);
		 
		 return user.getCreatedPrograms();
	}
    
    
    
}
