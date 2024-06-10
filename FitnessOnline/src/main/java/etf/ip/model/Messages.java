package etf.ip.model;


import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name="messages")
public class Messages {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="content")
	@Pattern(regexp = "^[a-zA-Z0-9\\p{Punct} ]+$")
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdAt;

	// ----------- RELATIONS -----------------------
	
	@ManyToOne
    @JoinColumn(name = "senders_id")
	private Users sendersId;
	
	@ManyToOne
    @JoinColumn(name = "recipients_id")
	private Users recipientsId;
	
	@ManyToOne
    @JoinColumn(name = "trainers_id")
	private Trainers trainersId;
	
	
	// ---------------------------------------------
	

	public Messages(String content, Users sendersId, Users recipientsId, Trainers trainersId) {
		super();
		this.content = content;
		this.sendersId = sendersId;
		this.recipientsId = recipientsId;
		this.trainersId = trainersId;
		this.createdAt = new Timestamp(System.currentTimeMillis());
	}

	public Messages() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Users getSendersId() {
		return sendersId;
	}

	public void setSendersId(Users sendersId) {
		this.sendersId = sendersId;
	}

	public Users getRecipientsId() {
		return recipientsId;
	}

	public void setRecipientsId(Users recipientsId) {
		this.recipientsId = recipientsId;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
}
