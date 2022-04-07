function changeInformation()
{
	var name = document.getElementById("name").value;
	var phone = document.getElementById("phone").value;
	var address = document.getElementById("address").value;
	let oldName = document.getElementById("oldName").innerText;
	let oldPhone = document.getElementById("oldPhone").innerText;
	let oldAddress = document.getElementById("oldAddress").innerText;

	var flag = 0;
	if( name == oldName && phone == oldPhone && address == oldAddress){
		flag = 1;
		document.getElementById("notChangeWarning").innerHTML = "Không có gì thay đổi";	
	}else if(name.length == 0)
	{
		flag = 1;
		document.getElementById("nameWarning").innerHTML = "Tên không được để trống";	
	}else if(phone.length == 0)
	{
		flag = 1;
		document.getElementById("phoneWarning").innerHTML = "Số điện thoại không được để trống";
	}else if(address.length == 0)
	{
		flag = 1;
		document.getElementById("addressWarning").innerHTML = "Địa chỉ không được để trống";	
	}else if(!/(0[3|5|7|8|9])+([0-9]{8})\b/.test(phone))
	{
		flag = 1;
		document.getElementById("phoneWarning").innerHTML = "Sai định dạng số điện thoại";
	}
	if(flag == 1)
	{
		return;
	}
	var send = new Object();
	send.hoTen = name;
	send.soDienThoai = phone;
	send.diaChi = address;
	var data = JSON.stringify(send)
	$.ajax({
			type: "POST",	
			data: data,	
			contentType : "application/json",
			url: "http://localhost:8080/user/updateInfo",
			success: function(result){
				if(result.status == "200"){
					alert("Thông tin đã cập nhật");
				}else{
					alert("Thông tin không thay đổi");
				}
				
				window.location.href = "account";
			},
			error : function(e){
				alert("Error: ",e);
				console.log("Error" , e );
			}
		});
	
}