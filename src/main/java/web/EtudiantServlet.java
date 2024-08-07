package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metie.Etudiant;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import metie.Operation;
/**
 * Servlet implementation class EtudiantServlet
 */
public class EtudiantServlet extends HttpServlet {
	private Operation op ;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init() throws ServletException 
    {
    	op= new Operation();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// suppression 
		 String action = request.getParameter("action");
		 if(action!=null )
		 {
			 if(action.equals("supprimer"))
			 {
				 String id = request.getParameter("idsup");
				 op.supprimer(Integer.parseInt(id));
				 System.out.println("la suppression est bien effectue pour id "+id );
					
				 
				 
			 }
			 EtudiantBeans Eb = new EtudiantBeans();
			 Eb.setEtudiants(op.getAll());
			 request.setAttribute("Eb", Eb);
			 request.getRequestDispatcher("affichage.jsp").forward(request, response);
		 }
		
		 else 
		 {
			// get data from JSP View 
				//String  id2 = request.getParameter("idEtudiant");
				String name = request.getParameter("name");
				String sexe =  request.getParameter("sexe");
				String date_insc=request.getParameter("date_insc");
				Etudiant e = new Etudiant(name,sexe,date_insc);
				op.addEtudiant(e);
				EtudiantBeans Eb = new EtudiantBeans();
				Eb.setEtudiants(op.getAll());
				request.setAttribute("Eb", Eb);
				request.getRequestDispatcher("affichage.jsp").forward(request, response);
		 }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("ajouter");
		if(name!=null)
			request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
