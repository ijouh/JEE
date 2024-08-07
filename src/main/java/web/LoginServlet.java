package web;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse ;
import jakarta.servlet.ServletException;
import java.io.IOException ;
import java.util.ArrayList;

import metie.Login;
import metie.Operation;
public class LoginServlet extends HttpServlet {
	private Operation op ;
	public void init() throws ServletException 
	{
		op = new Operation();
	}
	public void doPost(HttpServletRequest request , HttpServletResponse response ) throws ServletException , IOException 
	{
		
		// recuperer les information de login 
		String id = request.getParameter("id");
		String login = request.getParameter("username");
		String password = request.getParameter("password");
		
		Login L1 = new Login(Integer.parseInt(id),login, password);
		EtudiantBeans Eb=new EtudiantBeans();
		//op.addLogin(L1);
		LoginBeans lb = new LoginBeans();
		ArrayList<Login> list_user = op.getAllLogins(); 
		lb.setLogins(list_user);
		
		request.setAttribute("lb" , lb);
		// test on the users
		int test=0;
		String message ="";
		for(Login user:list_user)
		{
			if(user.getLogin().equals(login) & user.getPassword().equals(password))
			{
				message = "bienvenu dans votre espace "+login ;
				Eb.setEtudiants(op.getAll());
				request.setAttribute("Eb", Eb);
				request.setAttribute("message",message);
				request.getRequestDispatcher("affichage.jsp").forward(request, response);
				test=1;
				break;
				
			}
			
		}
		if(test==0)
		{
			message = "your username or password is incorrect ";
			request.setAttribute("message",message);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
		
		
		
		
		
		
	}
}
