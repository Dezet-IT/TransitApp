package pl.dezet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dezet.model.User;
import pl.dezet.model.UserRole;
import pl.dezet.repository.TransitRepository;
import pl.dezet.repository.UserRepository;
import pl.dezet.repository.UserRoleRepository;

@Service
public class UserService {

	private static final String DEFAULT_ROLE = "ROLE_USER";
	private UserRepository userRepository;
	private UserRoleRepository roleRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Autowired
	public void setRoleRepository(UserRoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}




	public void addWithDefaultRole(User user) {
		UserRole defaultRole = roleRepository.findByRole(DEFAULT_ROLE);
		user.getRoles().add(defaultRole);
		userRepository.save(user);
	}



}