package dashboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dashboard.model.Citizen;
import dashboard.persistence.CitizenRepositoy;

@Service
public class CitizenService {

	@Autowired
	private CitizenRepositoy repository;
	
	public void save(Citizen citizen){
		repository.save(citizen);
	}
	
	public List<Citizen> findAll(){
		return repository.findAll();
	}
}
