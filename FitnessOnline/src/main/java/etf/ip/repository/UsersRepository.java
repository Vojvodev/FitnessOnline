package etf.ip.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import etf.ip.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
	Optional<Users> findByUsername(String uname);
}
