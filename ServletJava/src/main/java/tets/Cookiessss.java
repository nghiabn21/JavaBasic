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
 
@WebServlet("/servlet3")
public class Cookiessss extends HttpServlet{ 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("nm") ;  
		
		
		PrintWriter out = resp.getWriter() ;   
		 
		Cookie cookie  =new Cookie("nm", name) ; // lưu trữ cặp key value 
		 
		resp.addCookie(cookie);
		
		resp.setContentType("text/html"); 
		out.print("<h1>name " + name + "</h1>") ; 
		 
		HttpSession httpSession = req.getSession() ; 
		httpSession.setAttribute("username", name) ; 
		out.print("<a href='servlet4'>Servlet 2 </a>") ; 
	}

}
