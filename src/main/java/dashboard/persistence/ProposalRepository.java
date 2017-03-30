package dashboard.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import dashboard.model.Proposal;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
	
}