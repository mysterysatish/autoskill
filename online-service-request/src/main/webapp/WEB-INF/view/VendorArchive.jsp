<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Achieved Requests</title>
</head>
<body>


<div class="topnav">
  <a class="active" href="${pageContext.request.contextPath}/vendorHome">Home</a>
  <a href="${pageContext.request.contextPath}/archived">Achieved</a>
  <a href="${pageContext.request.contextPath}/login">Logout</a>
</div>

<%@ include file="common/globalError.jspf"%>
<h2>Achieved Requests</h2>


<form:form method="post" action="${pageContext.request.contextPath}/vendorHome" onsubmit="return validateForm()"   >
<table>
    <tr>
        
        <th>Request ID</th>
        <th>City</th>
        <th>From Date</th>
        <th>To Date</th>
        <th>Customer ID</th>
        <th>Status</th>
        
        
        
        
    </tr>
    <c:forEach items="${bookVendors}" var="bookVendor" varStatus="count">
        <tr>
        
            <td> <label id="requestId${count.count}" for ="requestId" >${bookVendor.getRequestId()}</label> 
             <input type="hidden" id="requestId${count.count}" name="requestId${count.count}" value="${bookVendor.getRequestId()}"/>
            </td>
            <td> <label id="city${count.count}" for ="vendorId" >${bookVendor.getCity()}</label> 
            </td>
           
            
              <td> <label id ="fromDate${count.count}" for = "fromDate" >${bookVendor.getFromDate()}</label> 

             </td>
             
              <td> <label id ="toDate${count.count}" for = "toDate" >${bookVendor.getToDate()}</label> 

             </td>
               <td> <label id ="customerID${count.count}" for = "status" >Customer</label> 

             </td>
             
              <td> <label id ="status${count.count}" for = "status" >${bookVendor.getStatus()}</label> 

             </td>
             
            
           
            
          
           
        </tr>
        
    </c:forEach>
</table>
</form:form>

</body>
</html>