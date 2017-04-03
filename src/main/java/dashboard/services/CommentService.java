package dashboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dashboard.model.Comment;
import dashboard.persistence.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository repository;
	
	public void save(Comment comment){
		repository.save(comment);
	}
	
	public void delete(Comment comment){
		repository.delete(comment);
	}
	
	public List<Comment> findAll(){
		return repository.findAll();
	}
	
	public Comment findById(long id){
		return repository.findOne(id);
	}
}
