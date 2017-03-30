package dashboard.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Proposal extends Votable{
	
	private String description;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Citizen citizen;
	
	@OneToMany(mappedBy="proposal")
	private Set<Comment> comments = new HashSet<>();
	
	Proposal(){}
	
	public Proposal(String desription, Citizen citizen){
		this.description = desription;
		Association.Propose.link(citizen, this);
		}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Comment> _getComments() {
		return comments;
	}

	public void _setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proposal other = (Proposal) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
	
	
	
	

}
