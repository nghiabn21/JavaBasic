package tets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet4")
public class Second2 extends HttpServlet{ 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("nm") ; 
		PrintWriter out = resp.getWriter() ;  
		 
		Cookie[] ck =   req.getCookies() ; 
		 
		
		resp.setContentType("text/html"); 
		out.print("<h1>name: " + ck[0].getValue()+ "</h1>") ; 
	}

}
