<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import = "java.io.*,java.util.*" %>
<%@page session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Laptop Shop </title>
    </head>
    <body> 
           <jsp:include page="include/homeHeader.jsp"></jsp:include>

           <jsp:include page="include/homeContent.jsp"></jsp:include>
           
           <jsp:include page="include/homeFooter.jsp"></jsp:include>
            
            
            <!-- <script>
                var token = '<%out.print(response.getHeader("accessToken"));%>';
                if(token !== 'null'){
                    localStorage.setItem("accessToken", token)
                }
           </script> -->
    </body>
</html>


		