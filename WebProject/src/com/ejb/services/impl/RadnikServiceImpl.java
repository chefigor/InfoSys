package com.ejb.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.RadnikService;
import com.jpa.entities.Radnik;

@Stateless
public class RadnikServiceImpl implements RadnikService {

	@PersistenceContext(name="WebProject")
	private EntityManager em;

	@Override
	public int dodajRadnika(Radnik r) 
	{
		try {
			if(r.getJmbg().length()!=13)
			{
				return 2;
			}
			if(!em.createQuery("SELECT r from Radnik r WHERE r.jmbg = "+r.getJmbg(),Radnik.class).getResultList().isEmpty())
			{
				return 0;
			}
			
			em.persist(r);
			return 1;

		}
		catch(Exception e)
		{
			System.out.print("Greska prilikom rada sa bazom /n Error:Dodavanje aplikacije neuspesno /n"+e.getMessage());
			return 3;
		}	
	}

	@Override
	public void promeniPosao(int id, String tip_posla) 
	{
		try 
		{
			Radnik r=em.find(Radnik.class, id);
			r.setTip_posla(tip_posla);
		}
		catch(Exception e)
		{
			System.out.print("Greska prilikom rada sa bazom /n Error:Promena posla radnika neuspesno /n"+e.getMessage());
		}
	}

	@Override
	public List<Radnik> listRadnik() 
	{
		try 
		{
			List<Radnik> sviRadnici=em.createQuery("SELECT r FROM Radnik r",Radnik.class).getResultList();
			return sviRadnici;
		}
		catch(Exception e)
		{
			System.out.print("Greska prilikom rada sa bazom /n Error:Pribavljanje radnika neuspesno /n"+e.getMessage());
			return null;
		}
		
	}

	@Override
	public void obrisiRadnika(int id) 
	{
		try 
		{
			Radnik r=em.find(Radnik.class, id);
			em.remove(r);
		}
		catch(Exception e)
		{
			System.out.print("Greska prilikom rada sa bazom /n Error:Brisanje radnika neuspesno /n"+e.getMessage());
				
		}
	}
}