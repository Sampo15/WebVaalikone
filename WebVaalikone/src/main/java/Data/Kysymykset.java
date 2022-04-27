package Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kysymykset {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kysymys_id;
	private String kysymys;
	
	public Kysymykset(){
		
	}
public Kysymykset(String kysymys){
		this.kysymys = kysymys;
	}
	
	public Kysymykset(int kysymys_id, String kysymys) {
		this.kysymys_id = kysymys_id;
		this.kysymys = kysymys;
	}
	public Kysymykset(String kysymys_id, String kysymys) {
		this.kysymys = kysymys;
		this.setKysymys_id(kysymys_id);
	}

	public int getKysymys_id() {
		return kysymys_id;
	}

	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}
	public void setKysymys_id(String kysymys_id) {
		try {
			this.kysymys_id = Integer.parseInt(kysymys_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value is not changed
		}
	}

	public String getKysymys() {
		return kysymys;
	}

	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	public String toString() {
		return this.kysymys_id+": "+this.kysymys;
	}
}
