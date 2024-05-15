package etf.ip.model;


import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name="programs")
public class Programs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	@Pattern(regexp = "^[a-zA-Z0-9]*$")
	private String name;
	
	@Column(name="description")
	@Pattern(regexp = "^[a-zA-Z0-9\\p{Punct}]*$")
	private String description;
	
	@Column(name="price")
	private double price;
	
	@Column(name="difficulty")
	private String difficulty;
	
	@Column(name="duration")
	private String duration;
	
	@Column(name="location")
	private String location;
	
	@Column(name="activity_type")
	private String activityType;
	
	@Column(name="equipment")
	private String equipment;
	
	@Column(name="bodyweight")
	private boolean bodyweight = false;

	@Column(name="image")
	private String image;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdAt;
	
	// ---------------------- RELATIONS ---------------------------------
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categories_id")
    private Categories category;
	
	
	@OneToMany(mappedBy = "program")
    private List<Comments> commentsList;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainers_id")
    private Users trainer;
	
	
	@ManyToMany()
    @JoinTable(
    		name = "programs_has_users", 
    		joinColumns = @JoinColumn(name = "programs_id"), 
    		inverseJoinColumns = @JoinColumn(name = "users_id"))
    private List<Users> enrolledUsers;
	
	// ------------------------------------------------------------------
	
	
	
	public Programs() {
		super();
	}

	public Programs(String name, String description, double price, String difficulty, String duration,
			String location, String activityType, String equipment, boolean bodyweight, String image, Categories category,
			List<Comments> commentsList, Users trainer, List<Users> enrolledUsers) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.difficulty = difficulty;
		this.duration = duration;
		this.location = location;
		this.activityType = activityType;
		this.equipment = equipment;
		this.bodyweight = bodyweight;
		this.image = image;
		this.category = category;
		this.commentsList = commentsList;
		this.trainer = trainer;
		this.enrolledUsers = enrolledUsers;
	}

	
	
	public List<Users> getEnrolledUsers() {
		return enrolledUsers;
	}

	public void setEnrolledUsers(List<Users> enrolledUsers) {
		this.enrolledUsers = enrolledUsers;
	}

	public List<Comments> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<Comments> commentsList) {
		this.commentsList = commentsList;
	}

	public Users getTrainer() {
		return trainer;
	}

	public void setTrainer(Users trainer) {
		this.trainer = trainer;
	}

	public Categories getCategory() {
		return category;
	}
	
	public String getCategoryName() {
		return getCategory().getName();
	}
	
	public void setCategory(Categories category) {
		this.category = category;
	}

	public List<Comments> getComments() {
		return commentsList;
	}

	public void setComments(List<Comments> comments) {
		this.commentsList = comments;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public boolean isBodyweight() {
		return bodyweight;
	}

	public void setBodyweight(boolean bodyweight) {
		this.bodyweight = bodyweight;
	}
	
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
