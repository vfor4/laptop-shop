<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Thanh toán</title>
</head>

<script type="text/javascript">	  
	$(document).ready(function() { 
		 $(".mytable .donGia .check").each(function() {
			  var value = accounting.formatMoney($(this).text())+ ' VND';
			  $(this).html(value);
			});
	  
		 $(".mytable .total").each(function() {
			  var value = accounting.formatMoney($(this).text()) + ' VND ';
			  $(this).html(value);
			});
	  });
	</script>

<body>

<div class="container">
	<form method="POST" action="<%=request.getContextPath()%>/thankyou">
	<div class = "row">
	<br><br>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
		<div class="col-md-3" >
			<br>
			<p class="border-p" style="line-height:1.5;"><b>Thông tin khách hàng</b></p>
			
			<p style="line-height:2;">Họ tên Quý khách </p>
			<input size="27" value="${user.hoTen}" disabled>
			
			<p style="line-height:2;">Địa chỉ Email </p>
			<input size="27" value="${user.email}" disabled>
			
			<p style="line-height:2;"> Số điện thoại </p>
			<input size="27" value="${user.soDienThoai}" disabled>
			
			<p style="line-height:2;">Địa chỉ(số nhà, đường, tỉnh thành) </p>
			<textarea rows="5" cols="29" disabled>${user.diaChi}</textarea>
						
			<br><br>
		</div>
		</c:if>
		<div class="col-md-3">
			<br>
			<p class="border-p" style="line-height:1.5;"><b>Thông tin nhận hàng</b></p>
		
			<p style="line-height:2;" >Họ tên người nhận hàng *</p>
			<input size="27" name="hoTenNguoiNhan" required>
			
			<p style="line-height:2;">Số điện thoại *</p>
			<input size="27" name="sdtNhanHang" type="tel" pattern="(0[3|5|7|8|9])+([0-9]{8})\b" required>
			<br>
			
			<label style="line-height:2;" for="provinces">Địa chỉ giao hàng *</label>
  			<select id="provinces" style="width: 257.5px;" required>
				<option selected value="" >Tỉnh/Thành Phố</option>
			</select>
			<br>

			<!-- <label style="line-height:2;" for="district">Quận/Huyện*</label> -->
			<br>
  			<select  id="districts" style="width: 257.5px;" required>
		  		<option selected value="">Quận/Huyện</option>
			</select>
			<br>

			<!-- <label style="line-height:2;"  for="ward">Xã/Phường*</label> -->
			<br>
  			<select id="wards" style="width: 257.5px;" required>
				<option selected value="" >Xã/Phường:</option>
			</select>

		<p style="line-height:2;">Số nhà, đường *</p>
		<textarea id="address" rows="5" cols="29" maxlength=""  required></textarea>
		<input type="hidden" id="fullAddress" name="diaChiNhan" value="">
		<br><br>
		<input type="hidden" id="tongGiaTri" name="tongGiaTri">
		</div>
		
		<div class="col-md-6">
			<br>
			<p class="border-p" style="line-height:1.5;"><b>Giỏ hàng</b></p>
			<br>
			
				<table class="table-cart-checkout mytable">
					 <tr>
						    <th>Ảnh</th>
						    <th>Tên sản phẩm</th>
						    <th>Đơn giá</th>
						    <th>Tổng</th>
					</tr>
					<c:forEach items="${cart}" var="sanpham" >
				
					 <tr style="text-align: center;">
						    <td>
						    	<img src="/img/${sanpham.id}.png" alt="not found img" class="img-reponsive fix-size-img">
						    </td>
						    <td style="color:green">
						    ${sanpham.tenSanPham}
						    </td>
						    
						    <td class="donGia" >
						    	<div class="check " style ="display: inline-block; ">${sanpham.donGia}</div> 
						    	<div style="display: inline-block; "> x ${quanity[sanpham.id]}</div>
						    </td>
						    
						    <td>
						    	<div class="total">${sanpham.donGia*quanity[sanpham.id]}</div> 
						    </td>
					</tr>
					</c:forEach>
					
				</table>
			
			
			<br>
			<p>Tổng giá trị đơn hàng:     <b id="ordertotal"> </b></p>
			<br>
			 &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp;
			<a href="<%=request.getContextPath()%>/cart" class="btn btn-primary">Quay lại giỏ hàng</a>
			 &nbsp;  &nbsp;  &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			 
			<button class="btn btn-danger pull-center" type="submit" id="submit" onclick=updateAddress()>Gửi đơn hàng</button>
		
			<br><br>
		
		</div>
	
	</div>
	</form>
</div>
<script src="<c:url value='/js/client/checkoutAjax.js'/>" ></script>
<script>updateAddress = () =>{
	let provinceId = document.getElementById("provinces").value;
	let districtId = document.getElementById("districts").value;
	let wardId = document.getElementById("wards").value;
	
	// let address = document.getElementById("address").value;
	
  	var eP= document.getElementById("provinces");
  	var provinceName = eP.options[eP.selectedIndex].text

	var eD = document.getElementById("districts");
  	var districtName = eD.options[eD.selectedIndex].text

	var eW = document.getElementById("wards");
  	var wardName = eW.options[eW.selectedIndex].text

	var fullAddress = 
	'{' + '"address":'+'"'+ document.getElementById("address").value +'"'+ ','
	+ '"wardName":' +'"'+ wardName +'"'+ ','
	+ '"wardId":' +'"'+ wardId +'"'+ ','
	+ '"districtName":' +'"'+ districtName +'"'+ ','
	+ '"districtId":' +'"'+ districtId +'"'+ ','
	+ '"provinceName":' +'"'+ provinceName +'"'+ ','
	+ '"provinceId":' +'"'+ provinceId +'"'+ '}'
	
	$("#fullAddress").val(fullAddress)
	// alert($("#address").val())

}</script>	
</body>
</html>

