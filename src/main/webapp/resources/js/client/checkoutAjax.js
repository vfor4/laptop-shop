calculateOrder()
function calculateOrder()
{
	var element = document.getElementsByClassName("total");
	var res = 0;
	for (i = 0; i < element.length; i++) {
		res = res + parseInt(element[i].textContent);
	}
	var element2 = document.getElementById("ordertotal");
	
	resConvert = accounting.formatMoney(res);
	element2.innerHTML = resConvert+ " VND";
	
	var element3 = document.getElementById("tongGiaTri");
	if(element3!= null){
		element3.setAttribute("value",res);
	}
	if(res == 0)
	{
		document.getElementById("submit").disabled = true;		
	}	
}

$(document).ready(function () {
	ajaxGet3();
	function ajaxGet3() {
		document.getElementById("provinces").options.length = 1
		document.getElementById("districts").options.length = 1
		document.getElementById("wards").options.length = 1
		$.ajax({
			type: "GET",
			url: "https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/province",
			headers: {
				"Content-Type": "application/json",
				"Token": "3bc6b4b9-9b9b-11ec-ac64-422c37c6de1b"
			},
			success: function (result) {
				$.each(result.data, function (i, data) {
					// if(data.ProvinceID === 202){
						
						// var option = new Option(data.ProvinceName, data.ProvinceID, true, true);
					// }else{
						var option = new Option(data.ProvinceName, data.ProvinceID, false, false);
					// }
					$('#provinces').append(option)
				})
			}
		});

	}
	function ajaxGet4(provinceId) {
		document.getElementById("districts").options.length = 1
		document.getElementById("wards").options.length = 1
		$.ajax({
			type: "GET",
			url: "https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/district",
			headers: {
				"Content-Type": "application/json",
				"Token": "3bc6b4b9-9b9b-11ec-ac64-422c37c6de1b"
			},
			data:{
				"province_id": provinceId
			},
			success: function (result) {
				$.each(result.data, function (i, data) {
					var option = new Option(data.DistrictName, data.DistrictID, false, false);
					$('#districts').append(option)
				})
			}
		});

	}

	function ajaxGet5(districtId) {
		document.getElementById("wards").options.length = 1
		$.ajax({
			type: "GET",
			url: "https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/ward",
			headers: {
				"Content-Type": "application/json",
				"Token": "3bc6b4b9-9b9b-11ec-ac64-422c37c6de1b"
			},
			data:{
				"district_id": districtId
			},
			success: function (result) {
				$.each(result.data, function (i, data) {
					var option = new Option(data.WardName, data.WardCode, false, false);
					$('#wards').append(option)
				})
			}
		});

	}

	
	$("select#provinces").change(function(){
        var selectedProvinceID = $(this).children("option:selected").val();
		if(isNaN(Number(selectedProvinceID)) || Number(selectedProvinceID) === 0){
			document.getElementById("provinces").options.length = 1
			document.getElementById("districts").options.length = 1
			document.getElementById("wards").options.length = 1
		}else{
			ajaxGet4(selectedProvinceID)
		}
		
    });

	
	$("select#districts").change(function(){
        var selectedDistrictID = $(this).children("option:selected").val();
		if(isNaN(Number(selectedDistrictID))|| Number(selectedDistrictID) === 0){
			document.getElementById("districts").options.length = 1
			document.getElementById("wards").options.length = 1
		}else{
			ajaxGet5(selectedDistrictID)
		}
    });
	
	
})
