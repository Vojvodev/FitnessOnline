package etf.ip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import etf.ip.model.Comments;
import etf.ip.model.Programs;

public interface CommentsRepository extends JpaRepository<Comments, Integer>{
	List<Comments> findByProgram(Programs program);
	
	
	@Query(	"SELECT u.username FROM Users u " +
			"JOIN Comments c ON u.id = c.user.id " +
			"WHERE c.id = :id")
	String getCommenterByCommentId(int id);
}
