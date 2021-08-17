<%@page import="com.Model.MembersDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
       <title>스마트 염전 관리</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		
		
        
    </head>
	<body class="is-preload">
	
	<%
	MembersDTO info = (MembersDTO) session.getAttribute("info");
	%>
			<div id="page-wrapper">
	
				<!-- Header -->
					<div id="header">
	
						<!-- Logo -->
							<h1><a href="index.jsp" id="logo">스마트 염전 관리</a></h1>
	
						<!-- Nav -->
							<nav id="nav">
								<ul>
									<li><a href="index.jsp"></a></li>
									
								</ul>
							</nav>
	
					</div>

			<!-- Main -->
				<section class="wrapper style13"style="height: 435px">
					<div class="container">
						
					        <form action="Join.do" >
					        
							
								
								 <table style="margin-left: 0px; width: 256px; height: 192px; margin-right: 0px;">
				                    <tr>
				                        <td>
				                        
				                        <input class = "id" type="text" name="id" placeholder="ID" id="id" style="margin-top: 15px; margin-bottom: 15px">
										</td>
				                    </tr>
				                   
				                    <tr>
				                        <td>
				                        <input class = "pw" id="firstpw" type="password" name="pw" placeholder="password" style="margin-top: 15px; margin-bottom: 15px"/><br>
										<input class = "pw2" id="secondpw" type="password" name="pw2" placeholder="passwordCheck"><br>
										<span id="pwcheck" ></span></td>
				                    </tr>
				                    <tr>
				                    	<td>
				                    	
										<input type="submit" value="회원가입" class="button fit"/>
										
				                    </tr>
				                    
				                </table>
							
							
								
							</form>		
							
						
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
			
			<script type="text/javascript" >
			
			 
		    let pw = "";
		    let pw2 = "";

					
					
			
				function pwcheck() {
				
					console.log("확인");
	
					pw = document.getElementById("firstpw").value;
					pw2 = document.getElementById("secondpw").value;
					
					console.log(pw);
					console.log(pw2);
	
					 if (pw === pw2) {
	
						document.getElementById("pwcheck").innerHTML = "<span style = 'color:grkeen' id = pwcheck>비밀번호가 일치합니다</span>";
					} else {
						document.getElementById("pwcheck").innerHTML = "<span style = 'color:red' id = pwcheck>비밀번호가 일치하지 않습니다</span>";
	
					} 
				};
			
			</script>

	</body>
</html>