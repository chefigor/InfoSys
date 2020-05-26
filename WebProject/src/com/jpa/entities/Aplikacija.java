package com.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="aplikacija")
public class Aplikacija {
	@TableGenerator(name="aplikacija_gen",table="id_gen",pkColumnName="gen_name",
			valueColumnName="gen_val",allocationSize=1,pkColumnValue="aplikacija_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "aplikacija_gen")
	private int id;
	
	@Column(name="ime")
	private String ime;
	
	@Column(name="domen")
	private String domen;
	
	@Column(name="broj_poseta")
	private int broj_poseta;
	
	@Column(name="dozvoljene_konekcije")
	private int dozvoljene_konekcije;
	
	@Column(name="trajanje_aranzmana")
	private int trajanje_aranzmana;
	
	@Column(name="cena")
	private int cena;
	
	@Column(name="korisnikid")
	private int korisnikid;
	
	@Column(name="bandwidth")
	private int bandwidth;
	
	@Column(name="velicina")
	private int velicina;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getDomen() {
		return domen;
	}

	public void setDomen(String domen) {
		this.domen = domen;
	}

	public int getBroj_poseta() {
		return broj_poseta;
	}

	public void setBroj_poseta(int broj_poseta) {
		this.broj_poseta = broj_poseta;
	}

	public int getDozvoljene_konekcije() {
		return dozvoljene_konekcije;
	}

	public void setDozvoljene_konekcije(int dozvoljene_konekcije) {
		this.dozvoljene_konekcije = dozvoljene_konekcije;
	}

	public int getTrajanje_aranzmana() {
		return trajanje_aranzmana;
	}

	public void setTrajanje_aranzmana(int trajanje_aranzmana) {
		this.trajanje_aranzmana = trajanje_aranzmana;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public int getKorisnikid() {
		return korisnikid;
	}

	public void setKorisnikid(int korisnikid) {
		this.korisnikid = korisnikid;
	}

	public int getBandwidth() {
		return bandwidth;
	}

	public void setBandwidth(int bandwidth) {
		this.bandwidth = bandwidth;
	}

	public int getVelicina() {
		return velicina;
	}

	public void setVelicina(int velicina) {
		this.velicina = velicina;
	}

	/**
	 * @param id
	 * @param ime
	 * @param domen
	 * @param broj_poseta
	 * @param dozvoljene_konekcije
	 */
	public Aplikacija(int id, String ime, String domen, int broj_poseta, int dozvoljene_konekcije) {
		super();
		this.id = id;
		this.ime = ime;
		this.domen = domen;
		this.broj_poseta = broj_poseta;
		this.dozvoljene_konekcije = dozvoljene_konekcije;
	}

	/**
	 * 
	 */
	public Aplikacija() {
		super();
	}
	
}
