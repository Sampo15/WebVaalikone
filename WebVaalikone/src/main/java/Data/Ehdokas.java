package Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name="ehdokkaat")
public class Ehdokas {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int ehdokas_id;
private String sukunimi;
private String etunimi;
private String puolue;
private String miksi_eduskuntaan;
private String mita_asioita_haluat_edistaa;

private float score;

private String kotipaikkakunta;
private int vaalinro;
private String ehduser;
private String ehdpass;


public String getEhduser() {
	return ehduser;
}
public void setEhduser(String ehduser) {
	this.ehduser = ehduser;
}
public String getEhdpass() {
	return ehdpass;
}
public void setEhdpass(String ehdpass) {
	this.ehdpass = ehdpass;
}
public Ehdokas(String ehdokas_id, String sukunimi, String etunimi, String puolue, String eduskunta, String edistaa, String paikkakunta, String vaalinro, String ehduser, String ehdpass) {
	setEhdokas_id(ehdokas_id);
	setVaalinro(vaalinro);
	
	this.sukunimi=sukunimi;
	this.etunimi=etunimi;
	this.puolue=puolue;
	this.miksi_eduskuntaan = eduskunta;
	this.mita_asioita_haluat_edistaa = edistaa;
	this.kotipaikkakunta = paikkakunta;
	this.ehduser = ehduser;
	this.ehdpass = ehdpass;

}
public Ehdokas() {

}


public float getScore() {
	return score;
}

public void setScore(float score) {
	this.score = score;
}

public int getEhdokas_id() {
	return ehdokas_id;
}

public void setEhdokas_id(int ehdokas_id) {
	this.ehdokas_id = ehdokas_id;
}

public void setEhdokas_id(String ehdokas_id) {
	try {
		this.ehdokas_id= Integer.parseInt(ehdokas_id);
	}
	catch(NumberFormatException | NullPointerException e) {
		System.out.println(e.getMessage());
	}
}



public String getSukunimi() {
	return sukunimi;
}
public void setSukunimi(String sukunimi) {
	this.sukunimi = sukunimi;
}
public String getEtunimi() {
	return etunimi;
}
public void setEtunimi(String etunimi) {
	this.etunimi = etunimi;
}
public String getPuolue() {
	return puolue;
}
public void setPuolue(String puolue) {
	this.puolue = puolue;
}
public String getMiksi_eduskuntaan() {
	return miksi_eduskuntaan;
}

public void setMiksi_eduskuntaan(String eduskunta) {
	this.miksi_eduskuntaan = eduskunta;
}

public String getMita_asioita_haluat_edistaa() {
	return mita_asioita_haluat_edistaa;
}

public void setMita_asioita_haluat_edistaa(String edistaa) {
	this.mita_asioita_haluat_edistaa = edistaa;
}


public String getKotipaikkakunta() {
	return kotipaikkakunta;
}


public void setKotipaikkakunta(String paikkakunta) {
	this.kotipaikkakunta = paikkakunta;
}


public int getVaalinro() {
	return vaalinro;
}

public void setVaalinro(int vaalinro) {
	this.vaalinro = vaalinro;
}
public void setVaalinro(String vaalinro) {
	try {
		this.vaalinro= Integer.parseInt(vaalinro);
	}
	catch(NumberFormatException | NullPointerException e) {
		System.out.println(e.getMessage());
	}
}


}
