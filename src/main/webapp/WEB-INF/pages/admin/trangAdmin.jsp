<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import = "java.io.*,java.util.*" %>
<%@page session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang Quản Trị </title>
    </head>
    <body> 
        
           <jsp:include page="template/header.jsp"></jsp:include>

           <jsp:include page="template/sidebar.jsp"></jsp:include>
           
           <jsp:include page="template/content.jsp"></jsp:include>
           <jsp:include page="template/footer.jsp"></jsp:include>
           
           
           <!-- <script>
               localStorage.setItem("accessToken", '<%out.print(response.getHeader("accessToken"));%>')
           </script>	 -->
    </body>
</html>
