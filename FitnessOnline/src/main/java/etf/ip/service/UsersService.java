package etf.ip.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import etf.ip.model.Programs;
import etf.ip.model.Users;
import etf.ip.repository.ProgramsRepository;
import etf.ip.repository.UsersRepository;

@Service
public class UsersService implements UserDetailsService{
    
    @Autowired
    private UsersRepository userRepository;
    
    @Autowired
    private ProgramsRepository programsRep;
    
    public Users save(Users user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }
    
    
    public Optional<Users> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    
    public void addProgramToUser(String username, int programId) {
        Users user = findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found with username: " + username));
        
        Programs program = programsRep.findById(programId)
                .orElseThrow(() -> new IllegalArgumentException("Program not found with id: " + programId));
        
        user.addEnrolled(program);
        save(user);
    }
    
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new Users(
        				user.getFname(), 
        				user.getLname(), 
        				user.getUsername(),
        				user.getEmail(),
        				user.getPassword(), 
        				user.isTrainer(),
        				user.getContact(),
        				user.getRole(),
        				user.getCommentsList(),
        				user.getCreatedPrograms(),
        				user.getEnrolledPrograms(),
        				user.getCity(),
        				user.getAvatar()
        				);
	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}




