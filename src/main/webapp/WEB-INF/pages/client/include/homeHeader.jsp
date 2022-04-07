<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link href="http://localhost:8080/Frontend/css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<link
	href='//fonts.googleapis.com/css?family=Londrina+Solid|Coda+Caption:800|Open+Sans'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="http://localhost:8080/Frontend/css/responsiveslides.css">
<script src="http://localhost:8080/Frontend/js/jquery.min.js"></script>
<script src="http://localhost:8080/Frontend/js/responsiveslides.min.js"></script>
<script src="http://localhost:8080/js/client/accounting.js"></script>

<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>



<script>
		    // You can also use "$(window).load(function() {"
			    $(function () {

			      // Slideshow 1
			      $("#slider1").responsiveSlides({
			        maxwidth: 1600,
			        speed: 600
			      });
			});
		   
		  </script>

</head>
<body>


	<div class="wrap">
		<!----start-Header---->
		<div class="header">
			<div class="search-bar">
				<form action="/search">
					<input type="text" name="name">
					<input type="submit"
						value="Tìm kiếm" />
				</form>
			</div>
			<div class="clear"></div>
			<div class="header-top-nav ">
				<c:if test="${pageContext.request.userPrincipal.name != null}">

					<ul>
						<li>Xin chào: ${loggedInUser.hoTen}</li>


						<!-- 	<li><a href="<%=request.getContextPath()%>/checkout"">Thanh toán</a></li> -->
						<li><a href="<%=request.getContextPath()%>/user/account">Tài
								khoản</a></li>
						<li><a href="<%=request.getContextPath()%>/cart"><span>Giỏ
									hàng&nbsp;&nbsp;: </span></a><span
							class="glyphicon glyphicon-shopping-cart"></span></li>
						<li><a href="<%=request.getContextPath()%>/logout"> Đăng
								xuất</a></li>
					</ul>
				</c:if>

				<c:if test="${pageContext.request.userPrincipal.name == null}">
					<ul>
						<li><a href="<%=request.getContextPath()%>/register">Đăng
								kí</a></li>
						<li><a href="<%=request.getContextPath()%>/login">Đăng
								nhập</a></li>
						<li><a href="<%=request.getContextPath()%>/cart"> <span>Giỏ hàng&nbsp;&nbsp;&nbsp;</span></a><span
							class="glyphicon glyphicon-shopping-cart"></span></li>

					</ul>
				</c:if>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="clear"></div>
	<div class="top-header">
		<div class="wrap">
			<!----start-logo---->
			<div class="logo">
				<a href="<%=request.getContextPath()%>/"><img
					src="http://localhost:8080/Frontend/img/logo3.png" title="logo" /></a>
			</div>
			<!----end-logo---->
			<!----start-top-nav---->
			<div class="top-nav">
				<ul>
					<li><a href="<%=request.getContextPath()%>/">Trang chủ</a></li>

					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">
							Cửa hàng 
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu" style="background: #f4b048" id="danhmuc2">
						</ul>
					</li>
					<li><a href="<%=request.getContextPath()%>/shipping">Chính sách ưu đãi</a></li>
					<li><a href="<%=request.getContextPath()%>/guarantee">Bảo
							hành tận nơi</a></li>

					<li><a href="<%=request.getContextPath()%>/contact">Liên hệ</a></li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	
	<!----End-top-nav---->
	<!----End-Header---->
	
	<script src="<c:url value='/js/client/header.js'/>" ></script>