

import java.util.List;

public interface KorisnikService {
	public void dodajKorisnika(Korisnik k);
	public void obrisiKorisnika(int id);
	public void azurirajPlacanja(int id,String kartica,String paypal,String racun,int stanje);
	public void izmeniPassword(int id,String password);
	public void verifikovan(int id,String verifikovan);
	public List<Korisnik> listKorisnik();
}
