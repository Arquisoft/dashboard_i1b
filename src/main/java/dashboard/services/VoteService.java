package dashboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dashboard.model.Vote;
import dashboard.persistence.VoteRepository;

@Service
public class VoteService {

	@Autowired
	private VoteRepository repository;

	public Vote save(Vote v) {
		return repository.save(v);
	}
}
