
import java.util.List;


public interface RadnikService {
	public int dodajRadnika(Radnik r);
	public void promeniPosao(int id,String tip_posla);
	public void obrisiRadnika(int id);
	public List<Radnik> listRadnik();
	
}
