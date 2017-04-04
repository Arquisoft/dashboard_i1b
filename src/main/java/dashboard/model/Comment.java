package dashboard.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Comment extends Votable {

	@Column(nullable = false)
	private String comment;
	@Column(nullable = false)
	private Date date;

	@ManyToOne
	private Citizen citizen;
	
	@ManyToOne
	private Proposal proposal;

	Comment() {
	}

	public Comment(Citizen citizen, Proposal commentable,String comment) {
		setComment(comment);
		this.date = new Date();
		Association.Commenting.link(citizen, this, commentable);
	}

	public void _setProposal(Proposal proposal) {
		this.proposal = proposal;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void _setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citizen == null) ? 0 : citizen.hashCode());
		result = prime * result + ((proposal == null) ? 0 : proposal.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		Comment other = (Comment) obj;
		if (citizen == null) {
			if (other.citizen != null)
				return false;
		} else if (!citizen.equals(other.citizen))
			return false;
		if (proposal == null) {
			if (other.proposal != null)
				return false;
		} else if (!proposal.equals(other.proposal))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}

}
