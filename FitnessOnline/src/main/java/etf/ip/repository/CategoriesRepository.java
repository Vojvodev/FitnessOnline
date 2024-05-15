package etf.ip.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import etf.ip.model.Categories;


@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer>{

	Optional<Categories> findByName(String categoryName);
	
}
