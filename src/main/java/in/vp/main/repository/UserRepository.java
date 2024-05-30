package in.vp.main.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.vp.main.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

	 public User findByEmailAndPassword(String email, String password);

	public User findByEmail(String email);
	
	
}
