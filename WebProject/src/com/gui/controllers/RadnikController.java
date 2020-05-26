package com.gui.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.ejb.services.RadnikService;
import com.jpa.entities.Radnik;

@ManagedBean(name="RadnikController")
public class RadnikController {
	
	@EJB
	private RadnikService service;
	
	private String posao="";
	private int posaoid=0;
	private Radnik radnik=new Radnik();
	private int deleteid=0;
	private String returnInfo="";
	public String getPosao() {
		return posao;
	}
	public void setPosao(String posao) {
		this.posao = posao;
	}
	public int getPosaoid() {
		return posaoid;
	}
	public void setPosaoid(int posaoid) {
		this.posaoid = posaoid;
	}
	public Radnik getRadnik() {
		return radnik;
	}
	public void setRadnik(Radnik radnik) {
		this.radnik = radnik;
	}
	public int getDeleteid() {
		return deleteid;
	}
	public void setDeleteid(int deleteid) {
		this.deleteid = deleteid;
	}
	
	public String getReturnInfo() {
		return returnInfo;
	}
	public void setReturnInfo(String returnInfo) {
		this.returnInfo = returnInfo;
	}
	public void promeniPosao(int id,String tip_posla)
	{
		service.promeniPosao(id, tip_posla);
	}
	
	public void dodajRadnika(Radnik r)
	{
		int res=service.dodajRadnika(r);
		if(res==0)
		{
			returnInfo="Radnik sa datim JMBG-om vec postoji";
		}
		else if(res==1)
		{
			returnInfo="Uspesno dodavanje";
		}
		else if(res==2)
		{
			returnInfo="JMBG mora biti 13 karaktera";
		}
		else if(res==3)
		{
			returnInfo="Greska pri radom sa bazi podataka";
		}
			
	}
	
	public void obrisiRadnika(int id)
	{
		service.obrisiRadnika(id);
	}
	
	public List<Radnik> listRadnik(){
		return service.listRadnik();
	}
}
