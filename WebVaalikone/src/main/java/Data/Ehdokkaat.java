package Data;

public class Ehdokkaat {

private int ehdokas_id;
private String sukunimi;
private String etunimi;
private String puolue;
private String eduskunta;
private String edistaa;

private float score;

private String paikkakunta;
private int vaalinro;



public Ehdokkaat(String ehdokas_id, String sukunimi, String etunimi, String puolue, String eduskunta, String edistaa, String paikkakunta, String vaalinro) {
	setEhdokas_id(ehdokas_id);
	setVaalinro(vaalinro);
	
	this.sukunimi=sukunimi;
	this.etunimi=etunimi;
	this.puolue=puolue;
	this.eduskunta = eduskunta;
	this.edistaa = edistaa;
	this.paikkakunta = paikkakunta;
	

}
public Ehdokkaat() {

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
public String getEduskunta() {
	return eduskunta;
}

public void setEduskunta(String eduskunta) {
	this.eduskunta = eduskunta;
}

public String getEdistaa() {
	return edistaa;
}

public void setEdistaa(String edistaa) {
	this.edistaa = edistaa;
}


public String getPaikkakunta() {
	return paikkakunta;
}


public void setPaikkakunta(String paikkakunta) {
	this.paikkakunta = paikkakunta;
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
