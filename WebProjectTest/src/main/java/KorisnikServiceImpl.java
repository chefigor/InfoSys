

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



@Stateless
public class KorisnikServiceImpl implements KorisnikService {
	//@PersistenceContext(name="WebProject")
	private EntityManager em;

	public KorisnikServiceImpl() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("WebProject");
		em=emf.createEntityManager();
	}
	
	
	public void dodajKorisnika(Korisnik k) {
		try {
			System.out.print("Successs");
		em.persist(k);
		}
		catch(Exception e)
		{
			System.out.print("Greska prilikom rada sa bazom /n Error:Dodavanje korisnika neuspesno /n"+e.getMessage());
		}
	}

	@Override
	public void obrisiKorisnika(int id) {
		try {
			System.out.println("Success delete 2");
			Korisnik k=em.find(Korisnik.class, id);
			System.out.println(k.getId());
			em.remove(k);
		}
		catch(Exception e)
		{
			System.out.print("Greska prilikom rada sa bazom /n Error:Brisanje korisnika neuspesno /n"+e.getMessage());
		}
		
	}

	@Override
	public List<Korisnik> listKorisnik() {
		try
		{
			List<Korisnik> sviKorisnici= em.createQuery("SELECT k FROM Korisnik k ",Korisnik.class).getResultList();
			return sviKorisnici;
		}
		catch(Exception e)
		{
			System.out.print("Greska prilikom rada sa bazom /n Error:Pribavljanje korisnika neuspesno /n"+e.getMessage());
			return null;
		}
	}

	public void azurirajPlacanja(int id, String kartica, String paypal, String racun,int stanje) {
		try
		{
			Korisnik k=em.find(Korisnik.class, id);
			System.out.println("Ovo je racun: "+racun);
			if(!racun.isEmpty())
				k.setRacun(racun);
			if(!kartica.isEmpty())
				k.setKartica(kartica);
			if(!paypal.isEmpty())
				k.setPaypal(paypal);
			if(stanje!=0)
				k.setStanje(stanje);
		}
		catch(Exception e)
		{
			System.out.print("Greska prilikom rada sa bazom /n Error:Azuriranje placanja neuspesno /n"+e.getMessage());

		}		
	}

	@Override
	public void izmeniPassword(int id,String password) {
		try {
			Korisnik k=em.find(Korisnik.class, 1);
			System.out.println(k.getId());
			k.setPassword(password);
		}
		catch(Exception e)
		{
			System.out.print("Greska prilikom rada sa bazom /n Error:Azuriranje passworda neuspesno /n"+e.getMessage());

		}	
		
	}

	@Override
	public void verifikovan(int id, String verifikovan) {
		try
		{
			Korisnik k=em.find(Korisnik.class, id);
			k.setVerifikovan(verifikovan);
		}
		catch(Exception e)
		{
			System.out.print("Greska prilikom rada sa bazom /n Error:Promena verifikacije neuspesna /n"+e.getMessage());
		}
		
	}

}
