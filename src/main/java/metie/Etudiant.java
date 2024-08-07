package metie;

import java.sql.Date;

public class Etudiant {

		private int id ;
		private String nom ;
		private String date_ins;
		private String sexe;
		
		// constructors 
		public Etudiant() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Etudiant( String nom , String sexe , String date_ins) {
			
			this.nom=nom;
			this.sexe=sexe;
			this.date_ins = date_ins; 
		}
		public Etudiant(int id, String nom , String sexe , String date_ins) {
			this.id=id ;
			this.nom=nom;
			this.sexe=sexe;
			this.date_ins = date_ins; 
		}
		//getter and setters
		
		public int getId() {
			return id;
		}
		
		public String getSexe() {
			return sexe;
		}

		public void setSexe(String sexe) {
			this.sexe = sexe;
		}

		public void setId(int id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String  getDate_ins() {
			return date_ins;
		}
		public void setDate_ins(String date_ins) {
			this.date_ins = date_ins;
		} 
		
				
}
