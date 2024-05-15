package etf.ip.service;

import etf.ip.database.MessageDatabase;
import etf.ip.database.TrainerDatabase;
import etf.ip.model.MessageBean;

import java.awt.Desktop;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;

public class MessageService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	
	public ArrayList<MessageBean> getMessagesByEmail(String email){
		if(email == null) {
			return null;
		}
		
		return MessageDatabase.selectByEmail(email);
	}
	
	
	public void setSeenStatus(boolean seen, int messageId) {
		MessageDatabase.updateSeen(seen, messageId);
	}
	

	public ArrayList<MessageBean> getMessagesByContent(String content){
		return MessageDatabase.selectByContent(content);
	}	
	
	
	public void sendEmail(String fromEmail, String content, int sendersId) {
		String subject = "Trainer's response";
		String toEmail = TrainerDatabase.selectUserEmailById(sendersId);
		
		try {
            String encodedFrom = java.net.URLEncoder.encode(fromEmail, "UTF-8");
			String encodedRecipient = java.net.URLEncoder.encode(toEmail, "UTF-8");
            String encodedSubject = java.net.URLEncoder.encode(subject, "UTF-8");
            String encodedBody = java.net.URLEncoder.encode(content, "UTF-8");

            URI mailtoURI = new URI("mailto:" + encodedRecipient + "?subject=" + encodedSubject + "&body=" + encodedBody);

            Desktop.getDesktop().mail(mailtoURI);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}
