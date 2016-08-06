<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.hand.entity.Film" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>film表单显示</title>
</head>
<body>
<table border="1">
<thead>
       <tr>
           <td>id</td>
           <td>name</td>
           <td>description</td>
           <td>language</td>
       </tr>
         </thead>
         <tbody>
         	<%List<Film> films = (List<Film>)request.getAttribute("films"); %>
         	<%for (Film film: films) {%>
         	<tr>
         		<td><%=film.getFilm_id() %></td>
         		<td><%=film.getTitle() %></td>
         		<td><%=film.getDescription() %></td>
         		<td><%=film.getLanguageName() %></td>
         	</tr>
         	<%} %>
         </tbody>
   </table>
</body>
</html>