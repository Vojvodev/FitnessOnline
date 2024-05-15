package etf.ip.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import etf.ip.model.Programs;	


@Repository
public interface ProgramsRepository extends JpaRepository<Programs, Integer>{
	
	// Custom query for filtering Programs
	@Query("SELECT p FROM Programs p " + 
		   "LEFT JOIN p.category c " +
		   "WHERE " +
		   "(:categoryName   IS NULL OR :categoryName = 'xxx' OR c.name   = :categoryName) AND " +
		   "(:difficulty 	 IS NULL OR :difficulty   = 'xxx' OR p.difficulty = :difficulty)	 AND " +
		   "(:location   	 IS NULL OR :location     = 'xxx' OR p.location   = :location)   	 AND " +
		   "( (:price1 	  	 IS NULL OR :price2 IS NULL) OR (:price1 = 999999.0 OR :price2 = 999999.0) OR (p.price >= :price1 AND p.price <= :price2))")
	public Page<Programs> getFiltered(
			@Param("categoryName") 	String categoryName, 
			@Param("difficulty") 	String difficulty, 
			@Param("location") 	 	String location, 
			@Param("price1") 	 	Double price1, 
			@Param("price2") 	 	Double price2,
			Pageable pageable
			);
	
	
	// Custom query for searching programs
	@Query("SELECT p FROM Programs p WHERE p.name LIKE %:searchFor%")
	public Page<Programs> searchPrograms(String searchFor, Pageable pageable);
	
}
