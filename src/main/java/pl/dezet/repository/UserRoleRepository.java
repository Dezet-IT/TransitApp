package pl.dezet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.dezet.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	UserRole findByRole(String role);
}
