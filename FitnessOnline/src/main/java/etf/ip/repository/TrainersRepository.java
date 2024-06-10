package etf.ip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import etf.ip.model.Trainers;

@Repository
public interface TrainersRepository extends JpaRepository<Trainers, Integer>{
	
	@Query( "SELECT t.id FROM Trainers t")
	List<Integer> findAllTrainers();
}
