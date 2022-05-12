package app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kysymykset implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int kysymys_id;
	private String kysymys;
	
	public Kysymykset() {
		super();
	}
	
	public Kysymykset(String kysymys, int kysymys_id) {
		super();
		this.kysymys = kysymys;
		this.kysymys_id = kysymys_id;
	}
	public Kysymykset(String kysymys) {
		super();
		this.kysymys = kysymys;
	}


	public int getKysymys_id() {
		return kysymys_id;
	}
	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	
	
	public String toString() {
		return kysymys_id+" "+kysymys;
	}

}