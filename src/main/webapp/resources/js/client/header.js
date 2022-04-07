$(document).ready(function () {
	ajaxGet2();
	function ajaxGet2() {
		$.ajax({
			type: "GET",
			url: "http://localhost:8080/api/danh-muc/allForReal",

			success: function (result) {
				$.each(result, function (i, danhmuc) {
					var content = '<li><a href="/store?brand=' + danhmuc.tenDanhMuc + '"><span style=" font-size: 16px; font-weight: 900; ">' + danhmuc.tenDanhMuc + '</span></a></li>';
					var content2 = '<li><a style="padding-right: 100px" href="store?brand=' + danhmuc.tenDanhMuc + '">' + danhmuc.tenDanhMuc + '</a></li>'
					$('#danhmuc').append(content);
					$('#danhmuc2').append(content2);
				})
			}
		});

	}

	

	
})
// var settings = {
// 	"url": "https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/district",
// 	"method": "GET",
// 	"timeout": 0,
// 	"headers": {
// 	  "token": "3bc6b4b9-9b9b-11ec-ac64-422c37c6de1b",
// 	  "Content-Type": "application/json"
// 	},
// 	"data": {
// 	  "province_id": 258
// 	},
//   };
  
//   $.ajax(settings).done(function (response) {
// 	console.log(response);
//   });