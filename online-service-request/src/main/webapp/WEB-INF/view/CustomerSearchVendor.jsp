<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Vendor</title>
<script type="text/javascript">
function validateForm() {
	
	// var vendorID = document.getElementById("userID").value;
	
var city = 	document.getElementById("city").value;
var serviceType = document.getElementById("city").value;
return true;
}
</script>


<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
</head>
<body>

<div class="topnav">
  <a class="active" href="${pageContext.request.contextPath}/customerHomePage">Home</a>
  <a href="${pageContext.request.contextPath}/myOrders">My orders</a>
  <a href="${pageContext.request.contextPath}/login">Logout</a>
</div>

    <%@ include file="common/globalError.jspf"%>
    <form method="post" action="${pageContext.request.contextPath}/customerHomePage" onsubmit="return validateForm()">
    
   
     <label >City</label>
  <select name="city" id="city">
    <option value="Delhi">Delhi</option>
    <option value="Mumbai">Mumbai</option>
    <option value="Chennai">Chennai</option>
    <option value="Hyderabad">Hyderabad</option>
  </select>
  <label >Service Type</label>
   <select name="serviceType" id="servType" >
    <option value="Painter">Painter</option>
    <option value="Plumber">Plumber</option>
    <option value="Carpenter">Carpenter</option>
    <option value="Electrician">Electrician</option>
     <option value="Janitor">Janitor</option>
  </select>
    
 
   
        
  
<button type="submit" type="button" id="find" >Find</button>
        
      
    </form>

</body>
</html>