package com.ejb.services;

import java.io.IOException;
import java.util.List;

import com.jpa.entities.Aplikacija;

public interface AplikacijaService {
	
	public int dodajAplikaciju(Aplikacija a);
	public void obrisiAplikaciju(int id);
	public List<Aplikacija> listAplikacija();
	public void sendGET(int id) throws IOException;
}
