package web;

import metie.Login;

import java.util.ArrayList ;

public class LoginBeans {
	Login Lg = new Login();
	ArrayList<Login> Logins = new ArrayList<Login>();
	
	
	
	public LoginBeans() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login getLogin() {
		return Lg;
	}
	public void setE(Login Lg) {
		this.Lg = Lg;
	}
	public ArrayList<Login> getLogins() {
		return Logins;
	}
	public void setLogins(ArrayList<Login> Logins) {
		this.Logins = Logins;
	}
	
	
}
