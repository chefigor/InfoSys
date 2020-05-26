package com.gui.controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.ejb.services.AplikacijaService;
import com.jpa.entities.Aplikacija;

@ManagedBean(name="AplikacijaController")
public class AplikacijaController {
	@EJB
	private AplikacijaService service;
	
	private Aplikacija aplikacija=new Aplikacija();
	private int deleteid=0;
	private int posecenostid=0;
	private String returnInfo="";
	
	public Aplikacija getAplikacija() {
		return aplikacija;
	}
	public void setAplikacija(Aplikacija aplikacija) {
		this.aplikacija = aplikacija;
	}
	public int getDeleteid() {
		return deleteid;
	}
	public void setDeleteid(int deleteid) {
		this.deleteid = deleteid;
	}
	public int getPosecenostid() {
		return posecenostid;
	}
	public void setPosecenostid(int posecenostid) {
		this.posecenostid = posecenostid;
	}
	
	public String getReturnInfo() {
		return returnInfo;
	}
	public void setReturnInfo(String returnInfo) {
		this.returnInfo = returnInfo;
	}
	public void saveAplikacija(Aplikacija a)
	{
		int res=service.dodajAplikaciju(a);
		if(res==0)
		{
			returnInfo="Aplikacija sa tim domenom vec postoji";
		}
		else if(res==1)
		{
			returnInfo="Aplikacija dodata";
			
		}
		else if(res==2)
		{
			returnInfo="Nema dovoljno sredstava na korisnickom nalogu, ili nije verifikovan. Cena je"+a.getCena();
			
		}
		else if(res==3)
		{
			returnInfo="Greska sa radom u bazi";
			
		}
	}
	
	public void izbrisiAplikaciju(int id)
	{
		service.obrisiAplikaciju(id);
	}
	
	
	public List<Aplikacija> listaAplikacija()
	{
		return service.listAplikacija();
	}
	
	public void brojPoseta(int id)
	{
		try {
			service.sendGET(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
