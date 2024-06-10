package etf.ip.model;


import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name = "users")
public class Users implements UserDetails{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="fname")
	@Pattern(regexp = "^[a-zA-Z0-9 ]+$")
	private String fname;
	
	@Column(name="lname")
	@Pattern(regexp = "^[a-zA-Z0-9 ]+$")
	private String lname;
	
	@Column(name="uname", unique=true)
	@Pattern(regexp = "^[a-zA-Z0-9 ]+$")
	private String username;
	
	@Column(name="email")
	@Email
	private String email;
	
	@Column(name="password")
	private String password;

	@Column(name="is_trainer")
	private boolean trainer;
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="role")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(name="city")
	private String city;
	
	@Column(name="avatar") 
	private String avatar;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdAt;
	
	
	
	// ---------------- RELATIONSHIPS ----------------
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
    private List<Comments> commentsList;
	
	
	@OneToMany(mappedBy = "trainer")
	@JsonIgnore
	private List<Programs> createdPrograms;
	
	@ManyToMany()
    @JoinTable(
    		name = "programs_has_users", 
    		joinColumns = @JoinColumn(name = "users_id"), 
    		inverseJoinColumns = @JoinColumn(name = "programs_id"))
	@JsonIgnore
    private List<Programs> enrolledPrograms;
	
	// -----------------------------------------------
	
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String fname, String lname, String username, String email, String password, boolean trainer, String contact, 
			Role role, List<Comments> commentsList, List<Programs> createdPrograms, List<Programs> enrolledPrograms,
			String city, String avatar) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.trainer = trainer;
		this.contact = contact;
		this.role = role;
		this.email = email;
		this.commentsList = commentsList;
		this.createdPrograms = createdPrograms;
		this.enrolledPrograms = enrolledPrograms;
		this.city = city;
		this.avatar = avatar;
	}


	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public List<Programs> getEnrolledPrograms() {
		return enrolledPrograms;
	}
	
	public boolean addEnrolled(Programs program){
		return enrolledPrograms.add(program);
	}

	public void setEnrolledPrograms(List<Programs> enrolledPrograms) {
		this.enrolledPrograms = enrolledPrograms;
	}

	public List<Programs> getCreatedPrograms() {
		return createdPrograms;
	}

	public void setCreatedPrograms(List<Programs> createdPrograms) {
		this.createdPrograms = createdPrograms;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public List<Comments> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<Comments> commentsList) {
		this.commentsList = commentsList;
	}

	public List<Comments> getComments() {
		return commentsList;
	}

	public void setComments(List<Comments> comments) {
		this.commentsList = comments;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String uname) {
		this.username = uname;
	}

	public boolean isTrainer() {
		return trainer;
	}

	public void setTrainer(boolean trainer) {
		this.trainer = trainer;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
		// USER DETAILS
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
