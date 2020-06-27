<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review Service Requests </title>



<script type="text/javascript">
//var submitId;
	function validateForm() {
		
	//alert(submitId);
	var submitButtonID = "status".concat(submitId);
	//alert(submitButtonID);
	//var toDateID = 'toDate' + bookID;
	//var toDateID  = "toDate".concat(bookId);
	//alert('fromDateID'+fromDateID+ 'TODateId'+ toDateID);
	var submitValue = document.getElementById(submitButtonID).value;
	//alert(submitValue);
	//var toDate = document.getElementById(toDateID).value;
	//var vendorId = "Satish";
//	var vendorID = document.getElementById("vendorId1").value;
  /*  var vendorRegi= '${vendorServiceRegistration}';
    vendorRegi.toDate = new Date();
    vendorRegi.fromDate = new Date();
    vendorRegi.vendorId ="satish1235";
	alert('VendorRegis'+vendorRegi.vendorId);
	*/
    if(!submitValue ){
    	document.getElementById("errors").innerHTML = "Input Required";
	return false;
    }
    return true;
	}

	
</script>
</head>
<body>


<div class="topnav">
  <a class="active" href="${pageContext.request.contextPath}/vendorHome">Home</a>
  <a href="${pageContext.request.contextPath}/archived">Achieved</a>
  <a href="${pageContext.request.contextPath}/login">Logout</a>
</div>

<%@ include file="common/globalError.jspf"%>

<h2>Review Service Requests</h2>
<div class="container" id="vendorName" >
<p style="display:none">
    ${vendorName}  
    </p>
</div>

	<form:form method="post" action="${pageContext.request.contextPath}/vendorHome" onsubmit="return validateForm()"   >
<table>
    <tr>
        
        <th>Request ID</th>
        <th>City</th>
        <th>From Date</th>
        <th>To Date</th>
        <th>Customer ID</th>
        <th>Status</th>
        <th>Submit Status</th>
        
        
        
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
             
               <td> 

      <select name="status${count.count}" id="status${count.count}">
    <option value=""></option>
    <option value="APPROVE">Approve</option>
    <option value="REJECT">Reject</option>
   
  </select>
             </td>
               <td>  
           <button type="submit" name="id" value="${count.count}"  type="button" onclick="submitId='${count.count}'" id="submit${count.count}" >Submit</button>
            
             </td>
           
            
          
           
        </tr>
        
    </c:forEach>
</table>
</form:form>
</body>
</html>