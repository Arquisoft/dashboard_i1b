package dashboard.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import dashboard.model.Comment;

@Transactional
public interface CommentRepository extends JpaRepository<Comment, Long> {

}