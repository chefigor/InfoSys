	
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.persistence.TableGenerator;

@Entity
@Table(name="korisnik")
public class Korisnik {
	@TableGenerator(name="korisnik_gen",table="id_gen",pkColumnName="gen_name",
			valueColumnName="gen_val",allocationSize=1,pkColumnValue="korisnik_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "korisnik_gen")
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="ime")
	private String ime;
	
	@Column(name="prezime")
	private String prezime;
	
	@Column(name="telefon")
	private String telefon;
	
	@Column(name="kartica")
	private String kartica;
	
	@Column(name="paypal")
	private String paypal;
	
	@Column(name="racun")
	private String racun;
	
	@Column(name="stanje")
	private int stanje;
	
	@Column(name="verifikovan")
	private String verifikovan;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStanje() {
		return stanje;
	}

	public void setStanje(int stanje) {
		this.stanje = stanje;
	}

	public Korisnik() {}
	
	public Korisnik(int id,String ime,String prezime,String telefon,String kartica,String paypal,String racun)
	{
		setId(id);
		setIme(ime);
		setPrezime(prezime);
		setTelefon(telefon);
		setKartica(kartica);
		setPaypal(paypal);
		setRacun(racun);
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getIme()
	{
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime=ime;
	}
	
	public String getPrezime()
	{
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime=prezime;
	}
	
	public String getTelefon()
	{
		return telefon;
	}
	
	public void setTelefon(String telefon) {
		this.telefon=telefon;
	}
	
	public String getKartica()
	{
		return kartica;
	}
	
	public void setKartica(String kartica) {
		this.kartica=kartica;
	}
	
	public String getPaypal()
	{
		return paypal;
	}
	
	public void setPaypal(String paypal) {
		this.paypal=paypal;
	}
	
	public String getRacun()
	{
		return racun;
	}
	
	public void setRacun(String racun) {
		this.racun=racun;
	}

	public String getVerifikovan() {
		return verifikovan;
	}

	public void setVerifikovan(String verifikovan) {
		this.verifikovan = verifikovan;
	}
	
	
}
