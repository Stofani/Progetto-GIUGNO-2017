package service;

import java.util.Date;

import javax.ejb.Stateless;

import model.Autore;

@Stateless(name="aService")
public class AutoreService {

	public Autore save(String nome,String cognome,Date dataNascita,Date dataMorte){
		return null;
	}
}
