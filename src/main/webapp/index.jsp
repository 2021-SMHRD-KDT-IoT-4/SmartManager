<%@page import="com.Model.K_Detail_Info_DTO"%>
<%@page import="com.Model.MembersDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
MembersDTO user = (MembersDTO)session.getAttribute("info");	
		K_Detail_Info_DTO dto = null;
		
		if(user == null){
	response.sendRedirect("Login.jsp");
		}else {
	dto = (K_Detail_Info_DTO)session.getAttribute("diinfo");
	
		}
%>
<!DOCTYPE html>
<html>
	<head>
		<title>����Ʈ ��������</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body class="is-preload">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header">
					<!-- Logo -->
						<h1><a href="index.jsp" id="logo">����Ʈ ���� ����</a> <span id = "weather"></span></h1>
					<!-- Nav -->
						<nav id="nav">
							<ul>
								<li><a href="index.jsp">Home</a></li>
								<li><a href="no-sidebar.html">CCTV</a></li>
								<li><a href="no-sidebar.html">��������</a></li>
								<li><a href="no-sidebar.html">��������</a></li>
								<li><a href="no-sidebar.html">��������</a></li>
							</ul>
						</nav>
				</div>

			<!-- Highlights -->
				<section class="wrapper style13">
					<div class="container" >
					<%if(user!=null){ %>
					<table style="color:white;  margin-left: 50px; margin-bottom: 0px; padding-left: 0px; margin-right: 50px; margin-top: 60px;">
								<tr>
									<td>
										<section style="height: 100px; width: 220px;">
											<a href="#"> 
												<img src="images/pic01.jpg" class="img">
											</a>
											<div style="margin-left: 15px; margin-top: 0px; padding-bottom: 10px; padding-top: 10px; padding-left: 0px; padding-right: 0px; margin-right: 15px;">
													���� : <%=dto.getSalinity() %> %
											</div>
										</section>
									</td>									
									<td>
										<section style="height: 100px; width: 220px;">
											<a href="#"> 
												<img src="images/pic01.jpg" class="img">
											</a>
											<div style="margin-left: 15px; margin-top: 0px; padding-bottom: 10px; padding-top: 10px; padding-left: 0px; padding-right: 0px; margin-right: 15px;">
													�ǳ� �½��� : <%=dto.getIndoor_temp() %>
											</div>
										</section>
									</td>
									<td>
										<section style="height: 100px; width: 220px;">
											<a href="#"> 
												<img src="images/pic01.jpg" class="img">
											</a>
											<div style="margin-left: 15px; margin-top: 0px; padding-bottom: 10px; padding-top: 10px; padding-left: 0px; padding-right: 0px; margin-right: 15px;">
												���� �µ� : <%=dto.getWater_temp()%>
											</div>
										</section>
									</td>
									<td>
										<section style="height: 100px; width: 220px;">
											<a href="#"> 
												<img src="images/pic01.jpg" class="img">
											</a>
											<div style="margin-left: 15px; margin-top: 0px; padding-bottom: 10px; padding-top: 10px; padding-left: 0px; padding-right: 0px; margin-right: 15px;">
												���� �µ� : <%=dto.getWire_temp() %>
											</div>
										</section>
									</td>
									
								</tr>
								<tr>
									<td style="padding-top: 130px;">
										<section style="height: 100px; width: 220px;">
											<a href="#"> 
												<img src="images/pic01.jpg" class="img">
											</a>
											<div style="margin-left: 15px; margin-top: 0px; padding-bottom: 10px; padding-top: 10px; padding-left: 0px; padding-right: 0px; margin-right: 15px;">
												���� ���� : <%=dto.getWater_high() %>
											</div>
										</section>
									</td>									
									<td style="padding-top: 130px;">
										<section style="height: 100px; width: 220px;">
											<a href="#"> 
												<img src="images/pic01.jpg" class="img">
											</a>
											<div style="margin-left: 15px; margin-top: 0px; padding-bottom: 10px; padding-top: 10px; padding-left: 0px; padding-right: 0px; margin-right: 15px;">
												���� ���귮 : <%=dto.getDaily_prod() %>
											</div>
										</section>
									</td>
									<td style="padding-top: 130px;">
										<section style="height: 100px; width: 220px;">
											<a href="#"> 
												<img src="images/pic01.jpg" class="img">
											</a>
											<div style="margin-left: 15px; margin-top: 0px; padding-bottom: 10px; padding-top: 10px; padding-left: 0px; padding-right: 0px; margin-right: 15px;">
												��Ȯ���� �ñ� : <%=dto.getHarvest() %>
											</div>
										</section>
									</td>
									<td style="padding-top: 130px;">
										<section style="height: 100px; width: 220px;">
											<a href="#"> 
												<img src="images/pic01.jpg" class="img">
											</a>
											<div style="margin-left: 15px; margin-top: 0px; padding-bottom: 10px; padding-top: 10px; padding-left: 0px; padding-right: 0px; margin-right: 15px;">
												���� ũ�� : <%=dto.getPlace_size() %>
											</div>
										</section>
									</td>
									
								</tr>
							</table>
					
					<%} %>
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
			
			
		<!-- ���� api -->	
			<script type="text/javascript">
			
			var weather = document.getElementById('weather');
			 	window.onload = function (){
				    fetch(
				      `https://api.openweathermap.org/data/2.5/weather?lat=35.1669494&lon=126.8472480&appid=e5d8c3a021c78fea24e0228511195fe4&units=metric`
				    )
				      .then(function(response){
				      return response.json();
				    })
				      .then(function(json){
				        console.log(json);
				        const temparature = json.main.temp;  

				        const temp_min = json.main.temp_min; 
				        const temp_max = json.main.temp_max;  
				        const pressure = json.main.pressure; 
				        const humidity = json.main.humidity; 
				        const sea_level = json.main.sea_level; 
				        const grnd_level = json.main.grnd_level;
				        const place = json.name;   // ����� ��ġ
				        weather.innerText = `${temparature} - ${place} - ${temp_min} - ${temp_max} - ${pressure} - ${humidity} - ${sea_level} - ${grnd_level} - ${place}`;

				      });
				  }

		
			
			</script>

	</body>
</html>