package etf.ip.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import etf.ip.model.Messages;


@Repository
public interface MessagesRepository extends JpaRepository<Messages, Integer>{
	
}
