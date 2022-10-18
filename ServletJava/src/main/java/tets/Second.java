package tets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet2")
public class Second extends HttpServlet{ 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession() ; 
		
		String name = (String) httpSession.getAttribute("username") ;  
		resp.setContentType("text/html"); 
		PrintWriter out = resp.getWriter() ; 
		out.print("<h1>name: " + name + "</h1>") ; 
	}

}
