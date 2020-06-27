<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<script type="text/javascript">
	function validateForm() {
		
		//alert("In validation");
		
		  var regexAlphabet = /^[a-zA-Z]*$/;
          
          var regCharact = /.|\d|!|@|#|\$|%|&|\*|\(|\)|_|-|\+|=|{|\[|}|]|\||:|;|"|'|<|,|>|\.|\?|\/|~|`/gi;
                
          
            var validID = false;
         
            var validPassword = false;
             
 var vendorID = document.getElementById("userID").value;
 

 var password = document.getElementById("password").value;
 
        
           
            if (regCharact.test(vendorID) && vendorID.length <=16 && vendorID.length >=8) {

              
                validID = true;
                
   //         alert("Valid ID");
            } 
            
            if (regCharact.test(password) && password.length <=16 && password.length >=8) {

                
            	validPassword = true;
                
       //        alert("Valid password");
            } 
            
            if(validID && validPassword) {
      //      	alert("Client side Valid")
            	return true ;
            }
            document.getElementById("errors").innerHTML = "Invalid input";
      
            return false;
      
      
	}
</script>
</head>
<body>
<body>
	<%@ include file="common/globalError.jspf"%>
	<form method="post" action="${pageContext.request.contextPath}/login" onsubmit="return validateForm()">

		<label>User ID</label><input type="text" name="name" id="userID" /> <label>Password</label><input
			type="password" name="password" id="password" />


	
		<button type="submit" type="button" id="login" >Login</button>

		<div class="container" style="background-color: #f1f1f1">
			<label>New Vendor?</label> <span class="psw"><a href="${pageContext.request.contextPath}/register">Register
					Here</a></span>
		</div>
	</form>
</body>

</body>
</html>