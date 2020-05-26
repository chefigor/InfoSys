

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

;
public class RadnikTest {
	//test koji provera da li uspesno dodaje radnika
	public void test1() {
		EntityManager em;
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("WebProject");
		em=emf.createEntityManager();
		Radnik r=new Radnik(1,"Mitar","Mitrovic","1234567890126","7 juli","24.3.1978","12346321","IT Podrska");
		em.persist(r);
	}
	//test koji proverava da li se uspesno brise radnik
	public void test2()
	{
		RadnikServiceImpl service= new RadnikServiceImpl();
		service.obrisiRadnika(3);
	}
	
	public void test3() {
		RadnikServiceImpl service= new RadnikServiceImpl();
		List<Radnik> listaRadnika=service.listRadnik();
		assertNotNull(listaRadnika);
	}
	
	public void test4()
	{
		EntityManager em;
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("WebProject");
		em=emf.createEntityManager();
		Radnik r=em.find(Radnik.class, 4);
		System.out.println(r.getIme());
		assertNotNull(r);
	}
	@Test
	public void testAssertions()
	{
		//test1();
		//test2();
		//test3();
		test4();
	}
}
