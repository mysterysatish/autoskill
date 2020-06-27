<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Requests</title>

<script type="text/javascript">
var bookId;
	function validateForm() {
//	alert(bookId);
	var fromDateID = "fromDate".concat(bookId);
	//alert(fromDateID);
	//var toDateID = 'toDate' + bookID;
	var toDateID  = "toDate".concat(bookId);
	//alert('fromDateID'+fromDateID+ 'TODateId'+ toDateID);
	var fromDate = document.getElementById(fromDateID).value;
	var toDate = document.getElementById(toDateID).value;
	var vendorId = "Satish";
//	var vendorID = document.getElementById("vendorId1").value;
  /*  var vendorRegi= '${vendorServiceRegistration}';
    vendorRegi.toDate = new Date();
    vendorRegi.fromDate = new Date();
    vendorRegi.vendorId ="satish1235";
	alert('VendorRegis'+vendorRegi.vendorId);
	*/
    if(!fromDate || !toDate ){
    	document.getElementById("errors").innerHTML = "Invalid Date";
	return false;
    }
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

<h2>Your Requests</h2>

	<form:form  >

<table>
    <tr>
        
        <th>Request ID</th>
        <th>Vendor ID</th>
        <th>Service Type</th>
        <th>Vendor Name</th>
        <th>Status</th>
        <th>From Date</th>
        <th>To Date</th>
        
        
    </tr>
    <c:forEach items="${bookVendors}" var="bookVendor" varStatus="count">
        <tr>
        
            <td> <label id="requestId${count.count}" for ="requestId" >${bookVendor.getRequestId()}</label> 
            </td>
            <td> <label id="vendorId${count.count}" for ="vendorId" >${bookVendor.getVendorId()}</label> 
            </td>
             <td> <label id="servType${count.count}" for = "servType" >${bookVendor.getServiceType()}</label> 
           </td>
             
             <td> <label id ="venName${count.count}" for = "venName" >${bookVendor.getVendorName()}</label> 

             </td>
              <td> <label id ="status${count.count}" for = "status" >${bookVendor.getStatus()}</label> 
         
             </td>
              <td> <label id ="fromDate${count.count}" for = "fromDate" >${bookVendor.getFromDate()}</label> 

             </td>
             
              <td> <label id ="toDate${count.count}" for = "toDate" >${bookVendor.getToDate()}</label> 

             </td>
           
            
          
           
        </tr>
        
    </c:forEach>
</table>
</form:form>

</body>
</html>