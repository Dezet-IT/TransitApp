package pl.dezet.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class User {

	@Column(name = "id")
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	@NotEmpty
	private String email;
	@NotEmpty
	private String password;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<UserRole> roles = new HashSet<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<UserRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [id=" + id 
		        + ", firstName=" + firstName 
		        + ", lastName=" + lastName 
		        + ", email=" + email
				+ ", password=" + password 
				+ ", roles=" + roles + "]";
	}
}