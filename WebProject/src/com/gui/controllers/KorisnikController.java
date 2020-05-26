package com.gui.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.ejb.services.KorisnikService;
import com.jpa.entities.Korisnik;

@ManagedBean(name="KorisnikController")
public class KorisnikController {
	
	private int passwordid=0;
	private String password="";
	private int sid=0;
	private int id=0;
	private String kartica="";
	private String paypal="";
	private String racun="";
	private String stanje="";
	private int vid=0;
	private String verifikovan="";
	private Korisnik korisnik=new Korisnik();
	
	
	@EJB
	private KorisnikService service;
	
	public Korisnik getKorisnik()
	{
		return korisnik;
	}
	
	public void setKorisnik(Korisnik k)
	{
		this.korisnik=k;
	}
	
	
	public int getPasswordid()
	{
		return passwordid;
	}
	
	public void setPasswordid(int passwordid)
	{
		this.passwordid=passwordid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getKartica() {
		return kartica;
	}

	public void setKartica(String kartica) {
		this.kartica = kartica;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getPaypal() {
		return paypal;
	}

	public void setPaypal(String paypal) {
		this.paypal = paypal;
	}

	public String getRacun() {
		return racun;
	}

	public void setRacun(String racun) {
		this.racun = racun;
	}

	public String getStanje() {
		return stanje;
	}

	public void setStanje(String stanje) {
		this.stanje = stanje;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getVerifikovan() {
		return verifikovan;
	}

	public void setVerifikovan(String verifikovan) {
		this.verifikovan = verifikovan;
	}

	public void deleteKorisnik(String id)
	{
		int deleteid= Integer.parseInt(id);
		System.out.println("Success delete");
		service.obrisiKorisnika(deleteid);
	}
	public void saveKorisnik(Korisnik k)
	{
		System.out.println("Success1");
		service.dodajKorisnika(k);
	}
	public void izmeniSifru(int id,String newpass)
	{
		System.out.println("Pass 1 success"+id+newpass);
		service.izmeniPassword(id, newpass);
	}
	
	public List<Korisnik> listKorisnik()
	{
		return service.listKorisnik();
	}
	
	public void promeniVerifikovan(int id,String verifikovan)
	{
		service.verifikovan(id, verifikovan);
	}
	public void promeniPlacanja(int id,String kartica,String paypal,String racun,int stanje)
	{
		service.azurirajPlacanja(id, kartica, paypal, racun,stanje);
	}
	

}
