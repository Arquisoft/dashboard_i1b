package dashboard.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(VoteKey.class)
public class Vote {

	@Id @ManyToOne
	private Citizen citizen;
	
	@Id @ManyToOne
	private Votable votable;

	private boolean value;

	Vote() {
	}

	public Vote(Citizen citizen, Votable votable, boolean value) {
		this.value = value;
		Association.Voting.link(citizen, this, votable);
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public void _setVotable(Votable votable) {
		this.votable = votable;
	}

	public void _setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	@Override
	public String toString() {
		return "Vote [value=" + value + ", citizen=" + citizen + ", proposal=" + votable + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citizen == null) ? 0 : citizen.hashCode());
		result = prime * result + ((votable == null) ? 0 : votable.hashCode());
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
		Vote other = (Vote) obj;
		if (citizen == null) {
			if (other.citizen != null)
				return false;
		} else if (!citizen.equals(other.citizen))
			return false;
		if (votable == null) {
			if (other.votable != null)
				return false;
		} else if (!votable.equals(other.votable))
			return false;
		return true;
	}

}
