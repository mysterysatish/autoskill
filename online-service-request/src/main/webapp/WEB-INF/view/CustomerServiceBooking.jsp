<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Your Vendor</title>

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

<h2>Book Your Vendor</h2>

	<form:form method="post" action="${pageContext.request.contextPath}/serviceBooking" onsubmit="return validateForm()" modelAttribute="vendorServiceRegistration">

<table>
    <tr>
        <th>Vendor ID</th>
        <th>Service Type</th>
        <th>Vendor Name</th>
        <th>From Date</th>
        <th>To Date</th>
         <th>Book Vendor</th>
        
    </tr>
    <c:forEach items="${bookVendors}" var="bookVendor" varStatus="count">
        <tr>
        
            <td> <label id="vendorId${count.count}" for ="vendorId" >${bookVendor.getVendorId()}</label> 
            <input type="hidden" id="vendorId${count.count}" name="vendorId${count.count}" value="${bookVendor.getVendorId()}"/>
            <input type="hidden" id="city${count.count}" name="city${count.count}" value="${bookVendor.getCity()}"/>
           
            </td>
             <td> <label id="servType${count.count}" for = "serviceType" >${bookVendor.getServiceType()}</label> 
             <input type="hidden" id="servType${count.count}" name="servType${count.count}" value="${bookVendor.getServiceType()}"/>
             </td>
             
             <td> <label id ="venName${count.count}" for = "vendorName" >${bookVendor.getVendorName()}</label> 
              <input type="hidden" id="venName${count.count}" name="venName${count.count}" value="${bookVendor.getVendorName()}"/>
             
             </td>
            <td > <input type="date" id="fromDate${count.count}" name="fromDate${count.count}">
            
            </td>
            <td> <input type="date" id="toDate${count.count}" name="toDate${count.count}">
              
            </td>
            
            
            
            
            <td>
            <button type="submit" name="id" value="${count.count}"  type="button" onclick="bookId='${count.count}'" id="book${count.count}" >Book</button>
            </td>
           
        </tr>
        
    </c:forEach>
</table>
</form:form>

</body>
</html>