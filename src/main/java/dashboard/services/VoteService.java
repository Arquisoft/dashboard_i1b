package dashboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dashboard.model.Vote;
import dashboard.model.VoteKey;
import dashboard.persistence.VoteRepository;

@Service
public class VoteService {

	@Autowired
	private VoteRepository repository;
	
	public void save(Vote vote){
		repository.save(vote);
	}
	
	public void delete(Vote vote){
		repository.delete(vote);
	}
	
	public List<Vote> findAll(){
		return repository.findAll();
	}
	
	public Vote findById(VoteKey id){
		return repository.findOne(id);
				}
}
