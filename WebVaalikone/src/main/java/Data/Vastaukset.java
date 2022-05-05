package Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

import key.CompositeKey;

@Entity
@IdClass(CompositeKey.class)
public class Vastaukset {
	@Id
	private int kysymys_id;
	@Id
	private int ehdokas_id;
	private int vastaus;
	private String kommentti;
	public Vastaukset() {

	}

	public Vastaukset(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}
	
	public Vastaukset(int ehdokas_id, int kysymys_id, int vastaus, String kommentti) {
		this.kysymys_id = kysymys_id;
		this.ehdokas_id = ehdokas_id;
		this.vastaus = vastaus;
		this.kommentti = kommentti;
	}

	public int getKysymys_id() {
		return kysymys_id;
	}

	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}

	public int getEhdokas_id() {
		return ehdokas_id;
	}

	public void setEhdokas_id(int ehdokas_id) {
		this.ehdokas_id = ehdokas_id;
	}

	public int getVastaus() {
		return vastaus;
	}

	public void setVastaus(int vastaus) {
		this.vastaus = vastaus;
	}

}
