package com.ejb.services;

import java.util.List;

import com.jpa.entities.Radnik;

public interface RadnikService {
	public int dodajRadnika(Radnik r);
	public void promeniPosao(int id,String tip_posla);
	public void obrisiRadnika(int id);
	public List<Radnik> listRadnik();
	
}
