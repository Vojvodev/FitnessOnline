package etf.ip.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MessageBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// private int programs_id;			// No need for this app
	// private int recipients_id;		// No need for this app
	private int id;
	private int trainersId;
	private int sendersId;				// Who sent the message and to whom the message is sent back
	private String content 		= "";
	private boolean seen		= false;
	private Timestamp createdAt;
	
	
	public MessageBean() {
		super();
	}
	
	public MessageBean(int id, int trainers_id, int senders_id, String content, String createdAt) {
		super();
		this.id = id;
		this.content = content;
		this.trainersId = trainers_id;
		this.sendersId = senders_id;
		
		if(createdAt != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
	            java.util.Date parsedDate = dateFormat.parse(createdAt);
	            this.createdAt = new Timestamp(parsedDate.getTime());
	        } catch (ParseException e) {
	            this.createdAt = null;
	        }
		}
		
	}

	
	
	public int getTrainersId() {
		return trainersId;
	}

	public void setTrainersId(int trainersId) {
		this.trainersId = trainersId;
	}

	public int getSendersId() {
		return sendersId;
	}

	public void setSendersId(int sendersId) {
		this.sendersId = sendersId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
