package etf.ip.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import etf.ip.model.Messages;
import etf.ip.model.Trainers;
import etf.ip.model.Users;
import etf.ip.repository.MessagesRepository;
import etf.ip.repository.TrainersRepository;
import etf.ip.repository.UsersRepository;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:4200")
public class MessagesController {
	@Autowired
	MessagesRepository messageRep;
	
	@Autowired
	TrainersRepository trainerRep;
	
	@Autowired
	UsersRepository userRep;
	
	
	@PostMapping("/add/message")
	public ResponseEntity<?> addMessage(@RequestBody Map<String, String> request){
		
		String content  = request.get("content");
		int senderId 	= Integer.parseInt(request.get("senderId"));
		Users sender    = userRep.findById(senderId).get();
		
		for(int recipientId : trainerRep.findAllTrainers()) {
			Trainers trainer = trainerRep.findById(recipientId).get();
			
			Messages message = new Messages(content, sender, null,  trainer);
			messageRep.save(message);
		}
		
		return ResponseEntity.ok("Message added successfully!");
	}
	
}
