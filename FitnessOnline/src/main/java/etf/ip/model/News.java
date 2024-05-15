package etf.ip.model;

public class News {
	private String title;
	private String image;
	private String description;
	private String link;
	
	
	
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public News(String title, String image, String description, String link) {
		super();
		this.title = title;
		this.image = image;
		this.description = description;
		this.link = link;
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
}
