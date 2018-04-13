package pl.dezet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.dezet.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
