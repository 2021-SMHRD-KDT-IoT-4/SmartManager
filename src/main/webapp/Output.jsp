<%@page import="com.Model.OutPut_DTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE HTML>

<html>
	<head>
		<title>����Ʈ ���� ����</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		
		<%ArrayList<OutPut_DTO> dtos = (ArrayList<OutPut_DTO>)session.getAttribute("OutPut_Info");%>
		
		
	</head>
	<body class="is-preload">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header">

					<!-- Logo -->
						<h1><a href="index.jsp" id="logo">����Ʈ ���� ����</a></h1>

					<!-- Nav -->
						<nav id="nav">
							<ul>
								<li><a href="index.jsp">Home</a></li>
								<li><a href="#">CCTV</a></li>
								<li><a href="#">��������</a></li>
								<li><a href="#">��������</a></li>
								<li><a href="#">��������</a></li>
							</ul>
						</nav>

				</div>

			<!-- Main -->
				<section class="wrapper style1" style="height: 435px">
					<div class="container">
					
						<%if(dtos!=null) {%>
						
						<table style="margin-left: 0px; width: 256px; height: 192px; margin-right: 0px;">
							
							<tr>
								<td>��¥</td>
								<td>���귮</td>
							</tr>
							<%for(int i = 0; i <= 5; i++) { %>
							<tr>
								<td><%=dtos.get(i).getDate_search() %></td>
								<td><%=dtos.get(i).getProd() %></td>
							</tr>
							<%}}%>
							
						</table>
							
					
					
						
					</div>
				</section>

		</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>