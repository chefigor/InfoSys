

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="radnik")
public class Radnik {
	@Id
	private int id;
	
	@Column(name="ime")
	private String ime;
	
	@Column(name="prezime")
	private String prezime;
	
	@Column(name="jmbg")
	private String jmbg;
	
	@Column(name="adresa")
	private String adresa;
	
	@Column(name="datum_rodjenja")
	private String datum_rodjenja;
	
	@Column(name="broj_racuna")
	private String broj_racuna;
	
	@Column(name="tip_posla")
	private String tip_posla;

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getDatum_rodjenja() {
		return datum_rodjenja;
	}

	public void setDatum_rodjenja(String datum_rodjenja) {
		this.datum_rodjenja = datum_rodjenja;
	}

	public String getBroj_racuna() {
		return broj_racuna;
	}

	public void setBroj_racuna(String broj_racuna) {
		this.broj_racuna = broj_racuna;
	}

	public String getTip_posla() {
		return tip_posla;
	}

	public void setTip_posla(String tip_posla) {
		this.tip_posla = tip_posla;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Radnik(int id, String ime, String prezime, String jmbg, String adresa, String datum_rodjenja,
			String broj_racuna, String tip_posla) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.adresa = adresa;
		this.datum_rodjenja = datum_rodjenja;
		this.broj_racuna = broj_racuna;
		this.tip_posla = tip_posla;
	}
	/**
	 * 
	 */
	public Radnik() {
	}
	
	
}
