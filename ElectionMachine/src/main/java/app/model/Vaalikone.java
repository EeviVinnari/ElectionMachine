/*package app.model;

import javax.servlet.http.HttpServlet;

public class Vaalikone extends HttpServlet {

}*/

package app.model;

import java.io.Serializable;

public class Vaalikone implements Serializable{
	private int ehdokas_id;
	private String sukunimi;
	private String etunimi;
	private String puolue;
	private String kotipaikkakunta;
	private int ika;
	private String miksi_eduskuntaan;
	private String mita_asioita_haluat_edustaa;
	private String ammatti;


	public int getEhdokas_id() {
		return ehdokas_id;
	}
	public void setEhdokas_Id(int ehdokas_id) {
		this.ehdokas_id = ehdokas_id;
	}
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public String getSukunimi() {
		return etunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	
	public String toString() {
		return ehdokas_id+" "+sukunimi+" "+etunimi;
	}
	
	
	
	/*
	
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public void setWeight(String s) {
		try {
			this.weight=Float.parseFloat(s);
		}
		catch(NumberFormatException e) {
			this.weight=0;
		}
	}
	public String toString() {
		return id+" "+breed+" ("+weight+")";
	}*/
}

