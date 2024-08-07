package web;

import metie.Etudiant;
import java.util.ArrayList ;

public class EtudiantBeans {
	Etudiant e = new Etudiant();
	ArrayList<Etudiant> Etudiants = new ArrayList<Etudiant>();
	
	
	
	public EtudiantBeans() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Etudiant getE() {
		return e;
	}
	public void setE(Etudiant e) {
		this.e = e;
	}
	public ArrayList<Etudiant> getEtudiants() {
		return Etudiants;
	}
	public void setEtudiants(ArrayList<Etudiant> etudiants) {
		Etudiants = etudiants;
	}
	
	
}
