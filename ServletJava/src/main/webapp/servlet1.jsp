<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>
  <% 
    String name = request.getParameter("nm") ;  
    out.print("<h1>name " + name + "</h1>") ;  
    
   %> 
   <a href="servlet2">Servlet 2</a>
</body>
</html>