<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Details</title>
</head>
<body>

<div class="topnav">
  <a class="active" href="${pageContext.request.contextPath}/customerHomePage">Home</a>
  <a href="${pageContext.request.contextPath}/myOrders">My orders</a>
  <a href="${pageContext.request.contextPath}/login">Logout</a>
</div>


    <%@ include file="common/globalError.jspf"%>

<h2>Successfully Booked a vendor</h2>

	<form:form method="post" modelAttribute="bookVendor">

<table>
    <tr>
        <th>Request ID</th>
        <th>Vendor ID</th>
        <th>Service Type</th>
        <th>City</th>
        <th>Vendor Name</th>
        <th>From Date</th>
        <th>To Date</th>
         
        
    </tr>
   
        <tr>
            <td> <label id="requestId" for ="requestId" >${bookVendor.getRequestId()}</label> </td>
            <td> <label id="vendorId" for ="vendorId" >${bookVendor.getVendorId()}</label> </td>
            <td> <label id="servType" for ="serviceType" >${bookVendor.getServiceType()}</label> </td>
             <td> <label id="city" for ="city" >${bookVendor.getCity()}</label> </td>
             <td> <label id="venName" for = "vendorName" >${bookVendor.getVendorName()}</label> </td>
             <td> <label id="fromDate" for = "fromDate" >${bookVendor.getFromDate()}</label> </td>
            <td> <label id="toDate" for = "toDate" >${bookVendor.getToDate()}</label> </td>
           
             
                   
        </tr>
        
   
</table>
</form:form>

</body>
</html>