<%@page import="metie.Etudiant"%>
<%@page import="web.EtudiantBeans"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        /* CSS pour le bouton stylisé */
        .ajouter {
            background-color: #4CAF50; /* Couleur de fond */
            border: none; /* Pas de bordure */
            color: white; /* Couleur du texte */
            padding: 15px 32px; /* Rembourrage */
            text-align: center; /* Alignement du texte */
            text-decoration: none; /* Pas de soulignement */
            display: inline-block; /* Affichage en ligne */
            font-size: 16px; /* Taille de la police */
            margin: 4px 2px; /* Marge */
            cursor: pointer; /* Curseur en forme de main */
            border-radius: 12px; /* Bords arrondis */
            transition-duration: 0.4s; /* Durée de la transition */
        }

        /* Effet au survol */
        .ajouter:hover {
            background-color: white; /* Couleur de fond au survol */
            color: black; /* Couleur du texte au survol */
            border: 2px solid #4CAF50; /* Bordure au survol */
        }
        // style table 
        
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
            font-family: Arial, sans-serif;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
            text-align: center;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        td form {
            margin: 0;
        }
        td form input[type="submit"] {
            background-color: #f44336;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
            border-radius: 5px;
        }
        td form input[type="submit"]:hover {
            background-color: #d32f2f;
        }
        form {
            text-align: center;
            margin: 20px auto;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 40px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
</style>
</head>
<body>
	<% String message  =(String)request.getAttribute("message");%>
	<% EtudiantBeans  etudiants = (EtudiantBeans)request.getAttribute("Eb");%>
	<div class="container">
		<h3><%=message %> </h3><br><br>
	<h3>Les information des Etidiants </h3>
	<a href="3">logout</a><br><br>
	<table style="text-align:center ;" border="1px" width="80%">
		<tr>
			<th>id</th>
			<th>Nom </th>
			<th>Sexe</th>
			<th>Date d'inscription </th>
			<th>Action </th>
		</tr>
		<%
			for(Etudiant e : etudiants.getEtudiants())
			{
		%>
		<tr>
		
			<td><%=e.getId() %></td>
			<td><%=e.getNom() %></td>
			<td ><%=e.getDate_ins() %></td>
			<td><%=e.getSexe() %></td>
			
			<td>
				<form action="EtudiantServlet" method="post">
					<input type="hidden" name="idsup" value="<%=e.getId()%>">
					<input type="hidden" name="action" value="supprimer">
					<input type="submit" value="delete">
				</form>
			</td>
		</tr>
		<%
		}
		%>
	</table>
	<form action="EtudiantServlet" method="get">
			<input type="submit" name="ajouter" value="add Student">
	</form>
	</div>
</body>
</html>