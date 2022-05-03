package Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vastaukset {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kysymys_id;

	public Vastaukset() {

	}

	public Vastaukset(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}

	public int getKysymys_id() {
		return kysymys_id;
	}

	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}

}
