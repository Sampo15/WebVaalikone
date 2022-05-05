package key;

import java.io.Serializable;

public class CompositeKey implements Serializable{
	private int kysymys_id;
	private int ehdokas_id;
	public CompositeKey(int kysymys_id, int ehdokas_id) {
		this.kysymys_id = kysymys_id;
		this.ehdokas_id = ehdokas_id;
	}
	
	
}
