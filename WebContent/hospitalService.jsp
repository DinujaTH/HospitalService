<%@page import="com.Hospital"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospital Service</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/Hospital.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Hospital Serviceb</h1>
				
				<form id="formHospital" name="formHospital">
					Hospital Code: 
					<input id="hpCode" name="hpCode" type="text"
						class="form-control form-control-sm"> 
					<br> Hospital Name:
					<input id="hpName" name="hpName" type="text"
						class="form-control form-control-sm"> 
					<br> Hospital Telephone: 
					<input id="hpTp" name="hpTp" type="text"
						class="form-control form-control-sm"> 
					<br> Hospital Address: 
					<input id="hpAddress" name="hpAddress" type="text"
						class="form-control form-control-sm"> 
					<br> Doctor: 
					<input id="hpDOC" name="hpDOC" type="text"
						class="form-control form-control-sm"> 	
					<br> Description: 
					<input id="hpDesc" name="hpDesc" type="text"
						class="form-control form-control-sm"> 
						
					<br> <input id="btnSave" name="btnSave" type="button" value="Save"
						class="btn btn-primary"> 
					<input type="hidden" id="hidhpIDSave" name="hidhpIDSave" value="">
					
				</form>
				
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				
				<br>
				<div id="divHospitalGrid">
					<%
					Hospital hospitalObj = new Hospital();
					out.print(hospitalObj.readHospital());
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>