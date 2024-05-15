package etf.ip.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import etf.ip.model.Comments;
import etf.ip.repository.CommentsRepository;
import etf.ip.repository.ProgramsRepository;
import etf.ip.repository.UsersRepository;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:4200")
public class CommentsController {
	@Autowired
	CommentsRepository commentRep;
	
	@Autowired
	ProgramsRepository programRep;
	
	@Autowired
	UsersRepository userRep;
	
	
	@GetMapping("/commenter")
	public String getCommenterByCommentId(@RequestParam int id) {
		return commentRep.getCommenterByCommentId(id);
	}
	
	
	@GetMapping("/comments")												
	public List<Comments> getAllComments(@RequestParam String programId){
		return commentRep.findByProgram(programRep.findById(Integer.parseInt(programId)).get());
	}
	
	
	@PostMapping("/add/comment")
	public ResponseEntity<?> addComment(@RequestBody Map<String, String> request){
		String content = request.get("content");
	    String userId = request.get("userId");
	    String programId = request.get("programId");
	    
		Comments comment = new Comments(
			content, 
			programRep.findById(Integer.parseInt(programId)).get(), 
			userRep.findById(Integer.parseInt(userId)).get()
		);
		
		commentRep.save(comment);
		return ResponseEntity.ok("Comment added successfully!");
	}
	
}
