package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import metie.Login;

import metie.Etudiant;

public class DataBaseManager {
	private static final String URL = "jdbc:mysql://localhost:3307/jee_etudiant";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver"; // Utilisez com.mysql.jdbc.Driver pour les versions de MySQL antérieures à 8
    
    public DataBaseManager() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    static {
        try {
            // Charger le driver JDBC
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Driver JDBC non trouvé");
        }
    }
    
 // Obtenir une connexion à la base de données
	private Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	// Méthode pour ajouter un enregistrement
    public void addRecord(String nom, String date_insc, String sexe) {
        String query = "INSERT INTO etudiant (nom ,  date_ins , sexe) VALUES (?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nom);
            statement.setString(2, date_insc);
            statement.setString(3, sexe);
            statement.executeUpdate();

            System.out.println("Enregistrement ajouté avec succès!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    
 // Méthode pour supprimer un enregistrement par ID
    public void deleteRecord(int id) {
        String query = "DELETE FROM etudiant WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Enregistrement supprimé avec succès!");
            } else {
                System.out.println("Aucun enregistrement trouvé avec l'ID: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    
 // Méthode pour récupérer tous les enregistrements
    public ArrayList<Etudiant> getAllRecords() {
        String query = "SELECT * FROM etudiant";
        ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
        
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nom");
                String date_ins = resultSet.getString("date_ins");
                String sexe = resultSet.getString("sexe");
                etudiants.add(new Etudiant(id, name, date_ins, sexe));
            }
            return etudiants ;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    // Login admin 
    // add Lodin in the date base 
    public void addLogindb(Login l)
    {
    	String query = "INSERT INTO USER(login , password) VALUES(?,?)"; 
    	try(Connection connection = getConnection();
    		PreparedStatement statement = connection.prepareStatement(query);
    				){
    		statement.setString(1,l.getLogin());
    		statement.setString(2,l.getPassword());
    		statement.executeUpdate();
    	}catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    
    // select all from my table 
    
    public ArrayList<Login> getAllUser()
    {
    	String query = "select * from user " ;
    	
    	// create a list of users 
    	ArrayList<Login> users = new ArrayList<Login>();
    	try(Connection connection = getConnection();
    		Statement statement = connection.createStatement();
    		ResultSet resultset  = statement.executeQuery(query);
    		){
    		while(resultset.next())
    		{
    			int id = resultset.getInt("id");
    			String user_name = resultset.getString("login");
    			String password = resultset.getString("password");
    			users.add(new Login(id,user_name,password));
    		}
    		return users;
    	}catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	
    	return null;
    }
}
