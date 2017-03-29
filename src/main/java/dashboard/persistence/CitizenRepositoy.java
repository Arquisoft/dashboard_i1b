package dashboard.persistence;
import org.springframework.data.jpa.repository.JpaRepository;

import dashboard.model.Citizen;

public interface CitizenRepositoy extends JpaRepository<Citizen, Long> {
	
	Citizen findByEmailAndPassword(String email, String password);
	
} 