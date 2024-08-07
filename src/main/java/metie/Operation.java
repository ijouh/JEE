package metie;
import web.EtudiantBeans;
import web.DataBaseManager;
import web.LoginBeans ;
import java.util.ArrayList;

import metie.Etudiant; 
public class Operation {
	
	Etudiant e= new Etudiant();
	LoginBeans lg = new LoginBeans();
	EtudiantBeans Eb = new EtudiantBeans();
	DataBaseManager manager = new DataBaseManager();
	
	
	// Etudiant
	public void addEtudiant(Etudiant e)
	{
		
		manager.addRecord(e.getNom(),e.getDate_ins(),e.getSexe());
		System.out.println("l'ajout par succees");
		
	}
	
	public ArrayList<Etudiant> getAll()
	{
		return manager.getAllRecords();
	}
	
	public void supprimer(int id )
	{
		
		manager.deleteRecord(id);
		System.out.println("la supprission par succes");
	}
	
	
	// login
	public void addLogin(Login l)
	{
		//lg.getLogins().add(l);
		manager.addLogindb(l);
	}
	public ArrayList<Login> getAllLogins()
	{
		return manager.getAllUser();
	}
	
}
