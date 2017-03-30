package dashboard.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import dashboard.model.Vote;

@Transactional
public interface VoteRepository extends JpaRepository<Vote, Long> {

}