package dashboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dashboard.model.Proposal;
import dashboard.persistence.ProposalRepository;

@Service
public class ProposalService {

	@Autowired
	private ProposalRepository repository;
	
	public void save(Proposal proposal){
		repository.save(proposal);
	}
	
	public void delete(Proposal proposal){
		repository.delete(proposal);
	}
	
	public List<Proposal> findAll(){
		return repository.findAll();
	}
	
	public Proposal findById(long id){
		return repository.findOne(id);
	}
}
