package dashboard.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import dashboard.model.Vote;
import dashboard.model.VoteKey;


public interface VoteRepository extends JpaRepository<Vote, VoteKey> {

}