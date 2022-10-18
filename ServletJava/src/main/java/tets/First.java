package tets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebServlet("/servlet1")
public class First extends HttpServlet{ 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("nm") ; 
//		resp.setContentType("text/html"); 
//		PrintWriter out = resp.getWriter() ; 
//		out.print("<h1>name " + name + "</h1>") ; 
		 
		HttpSession httpSession = req.getSession() ; 
		httpSession.setAttribute("username", name) ; 
	//	out.print("<a href='servlet2'>Servlet 2 </a>") ; 
	} 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/servlet1") ; 
		dispatcher.forward(req, resp) ;
	}

}
