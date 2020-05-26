package com.ejb.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.AplikacijaService;
import com.jpa.entities.Aplikacija;
import com.jpa.entities.Korisnik;

@Stateless
public class AplikacijaServiceImpl implements AplikacijaService {
	@PersistenceContext(name="WebProject")
	private EntityManager em;

	@Override
	public int dodajAplikaciju(Aplikacija a) {
		try {
			if(!em.createQuery("SELECT app from Aplikacija app WHERE app.domen = '"+a.getDomen()+"'",Aplikacija.class).getResultList().isEmpty())
			{
				return 0;
			}
			int cenaAplikacije=a.getVelicina()*100+a.getBandwidth()*10+a.getDozvoljene_konekcije()+100;
			Korisnik korisnik=em.find(Korisnik.class, a.getKorisnikid());
			System.out.println(korisnik.getId());
			boolean verifikovan=korisnik.getVerifikovan().equalsIgnoreCase("DA");
			int korisnikStedstva=korisnik.getStanje();
			a.setCena(cenaAplikacije);
			if(korisnikStedstva>cenaAplikacije && verifikovan) {
				korisnik.setStanje(korisnikStedstva-cenaAplikacije);
				em.persist(a);
				return 1;
			}
			else {
				System.out.println("Nema dovoljno sredstava na korisnickom nalogu, ili nije verifikovan/nCena aplikacije="+cenaAplikacije+"/nKorisnicka sredstva="+korisnikStedstva+"/nKorisnik verifikovan-"+korisnik.getVerifikovan());
				return 2;
			}
		}
		catch(Exception e)
		{
			System.out.print("Greska prilikom rada sa bazom /n Error:Dodavanje aplikacije neuspesno /n"+e.getMessage());
			return 3;
		}
	}

	@Override
	public void obrisiAplikaciju(int id) {
		try {
		Aplikacija a=em.find(Aplikacija.class, id);
		em.remove(a);
		}
		catch(Exception e)
		{
			System.out.print("Greska prilikom rada sa bazom /n Error:Brisanje aplikacije neuspesno /n"+e.getMessage());
		}		
	}

	@Override
	public List<Aplikacija> listAplikacija() {
		try {
			List<Aplikacija> sveAplikacije=em.createQuery("SELECT a from Aplikacija a",Aplikacija.class).getResultList();
			return sveAplikacije;
		}
		catch(Exception e) {
			System.out.print("Greska prilikom rada sa bazom /n Error:Pribavljanje aplikacija neuspesno /n"+e.getMessage());
			return null;
		}
	}

	private static final String USER_AGENT = "Mozilla/5.0";


	@Override
	public void sendGET(int id) throws IOException {
		Aplikacija a;
		int posete;
		try {
			 a=em.find(Aplikacija.class, id);
			 posete=a.getBroj_poseta();
		}
		catch(Exception e)
		{
			throw e;
		}
		URL obj=new URL("http://192.168.99.100/?id="+id+"&posete="+posete);
		HttpURLConnection con=(HttpURLConnection)obj.openConnection();
		con.setRequestMethod("GET");
		con.addRequestProperty("User-Agent", USER_AGENT);
		int responseCode=con.getResponseCode();
		System.out.println("GET Response Code :: "+ responseCode);
		if(responseCode==HttpURLConnection.HTTP_OK)
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while((inputLine = in.readLine())!=null)
			{
				response.append(inputLine);
			}
			in.close();
			
			System.out.println(response.toString());
			int broj_poseta=Integer.parseInt(response.toString());
			a.setBroj_poseta(broj_poseta);
		}
		else
		{
			System.out.println("GET Request didn't work");
		}
	}
	
}
