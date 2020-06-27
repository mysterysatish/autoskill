<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Service Request - Vendor Registration</title>


  <script type="text/javascript">
        function validateForm(){
            console.log("java Script");
            //console.log(document.getElementById("userId").value);
            
           var regexAlphabet = /^[a-zA-Z]*$/;
            
          var regCharact = /.|\d|!|@|#|\$|%|&|\*|\(|\)|_|-|\+|=|{|\[|}|]|\||:|;|"|'|<|,|>|\.|\?|\/|~|`/gi;
                
       
            var validName = false;
         
            var validPassword = false;
            var validVendorId = false;
            var validConformpass = false;
            var validAddress = false;
            
            
            var vendorName = document.getElementById("userName").value;
            
            
            if (regexAlphabet.test(vendorName) && vendorName.length <=20) {

              
                validName = true;
                
         //       alert("Valid vendor name");
            } 
            
            
            
            //regCharact.test(vendorId) &&
            var vendorId = document.getElementById("userId").value;
            
              if(regCharact.test(vendorId) && vendorId.length>=8 && vendorId.length<=16 )
            	{
            	validVendorId = true;
          //  	alert("Valid vendor Id");
            	}
            
            
           var password = document.getElementById("password").value;
        //   alert("Password"+password);
        //   alert("password"+regCharact.test(password));
           
           if(regCharact.test(password) && password.length>=8 && password.length<=16 )
       	{
        	   validPassword = true;
        //	   alert("Valid password");
       	}
            
           var confirmPassword = document.getElementById("confirmPass").value;
           
          // alert("conform password"+regCharact.test(confirmPassword))
           if(regCharact.test(confirmPassword) && confirmPassword.length>=8 && confirmPassword.length<=16 && password == confirmPassword )
          	{
        	   validConformpass = true;
        	//   alert("Valid confirm password");
          	}
            var address = document.getElementById("address").value;
            
           
            if(regCharact.test(address) && address.length <= 100 )
          	{
            	validAddress = true;
            	alert("Valid address");
          	}
             
          //  alert("Valid address"+validAddress);
             
        //    alert(validName + validVendorId +validPassword ,validConformpass , validAddress)
             if(validName && validVendorId && validPassword && validConformpass && validAddress)
            	 
           {  //   alert("Everything true")
            	 return true;
           }
            
             document.getElementById("errors").innerHTML = "Invalid input";
            return false;
            
            
            
           
        }
    </script>
</head>



<body>
    <%@ include file="common/globalError.jspf"%>
    <form method="post" action="${pageContext.request.contextPath}/register" onsubmit="return validateForm()">
    
    <label>Vendor Name</label><input type="text" name="name" id = "userName"/>
    <label>Vendor ID</label><input type="text" name="id" id = "userId"/>
    <label>Password</label><input type="password" name="password" id="password" /> 
    <label>Confirm Password</label><input type="password"  id="confirmPass" /> 
    <label>Address</label><input type="text" name="address" id = "address"/>
     <label >City</label>
  <select name="city" id="city">
    <option value="Delhi">Delhi</option>
    <option value="Mumbai">Mumbai</option>
    <option value="Chennai">Chennai</option>
    <option value="Hyderabad">Hyderabad</option>
  </select>
  <label >Service Type</label>
   <select name="serviceType" id="servType" multiple>
    <option value="Painter">Painter</option>
    <option value="Plumber">Plumber</option>
    <option value="Carpenter">Carpenter</option>
    <option value="Electrician">Electrician</option>
     <option value="Janitor">Janitor</option>
  </select>
    
 
   
        
  
<button type="submit" type="button" id="register" >Register</button>
        
      
    </form>
</body>
</html>