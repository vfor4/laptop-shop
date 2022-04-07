$(document).ready(function() {
	
	// load first when coming page
	ajaxGet(1);	
	var role;
	function ajaxGet(page){		
		var data = { tenVaiTro:$("#vaiTro").val()};
		$.ajax({
			type: "GET",	
			data: data,
			contentType : "application/json",
			url: "http://localhost:8080/api/tai-khoan/all" + '?page=' + page,
			success: function(result){
				$.each(result.content, function(i, taiKhoan){
					var taiKhoanRow = '<tr>' +
					                  '<td>' + taiKhoan.id+ '</td>' +
					                  '<td>' + taiKhoan.hoTen + '</td>' +
					                  '<td>' + taiKhoan.email + '</td>' +
					                  '<td>' + taiKhoan.soDienThoai + '</td>' +
					                  '<td>' + taiKhoan.diaChi + '</td>'+ '<td>';
					
					  $.each(taiKhoan.vaiTro, function(i, vaiTro){
						  role = vaiTro.tenVaiTro;
						  taiKhoanRow += vaiTro.tenVaiTro;
						  taiKhoanRow += "<br>";
					  });
					//   role =='ROLE_ADMIN' ? '' : 
					  taiKhoanRow +='</td>' +
					                  '<td width="0%">'+'<input type="hidden" id="idTaiKhoan" value=' + taiKhoan.id + '>'+ '</td>'+
//					                  '<td><button class="btn btn-primary btnCapNhat" >Cập nhật</button></td>' + 
					                  '<td>'+`${role == "ROLE_ADMIN" ? '' :  taiKhoan.locked === true ? 
									  '<button class="btn btn-success btnStatus" id="btnA" value=0>Bỏ Khóa Tài khoản</button>' :
									  '<button class="btn btn-danger btnStatus" id="btnB" value=1>Khóa Tài Khoản</button>'}`+'</td>';  
					$('.taiKhoanTable tbody').append(taiKhoanRow);

				});
								
				if(result.totalPages > 1 ){
					for(var numberPage = 1; numberPage <= result.totalPages; numberPage++) {
						var li = '<li class="page-item "><a class="pageNumber">'+numberPage+'</a></li>';
					    $('.pagination').append(li);
					};				
					
					// active page pagination
			    	$(".pageNumber").each(function(index){	
			    		if($(this).text() == page){
			    			$(this).parent().removeClass().addClass("page-item active");
			    		}
			    	});
				};
			},
			error : function(e){
				alert("Error: ",e);
				console.log("Error" , e );
			}
		});
	};
	
	// event khi click vào dropdown chọn danh mục thêm sản phẩm
	$('#vaiTro').mouseup(function() {
		var open = $(this).data("isopen");
		if (open) {
			resetData();
		}
		$(this).data("isopen", !open);
	});
	
	// click thêm tài khoản
    $(document).on('click', '.btnThemTaiKhoan', function (event) {
    	event.preventDefault();
        $("#taiKhoanModal").modal();
    });
    
    // xác nhận thêm tài khoản
    $(document).on('click', '#btnSubmit', function (event) {
    	event.preventDefault();
        ajaxPostTaiKhoan();
        resetData();
    });
    
    function ajaxPostTaiKhoan() {    	
    	var data = JSON.stringify($('.taiKhoanForm').serializeJSON());
    	console.log(data);
    	
    	 // do post
    	 $.ajax({
     		async:false,
 			type : "POST",
 			contentType : "application/json",
 			url : "http://localhost:8080/api/tai-khoan/save",
 			enctype: 'multipart/form-data',
 			data : data,
 			success : function(response) {
 				if(response.status == "success"){
 					$('#taiKhoanModal').modal('hide');
 					alert("Thêm thành công");
 				} else {
 			    	$('input').next().remove();
 		            $.each(response.errorMessages, function(key,value){
 		            	if(key != "id"){
 		   	                $('input[name='+ key +']').after('<span class="error">'+value+'</span>');
 		            	};
 		              }); 
 				}
 		    	
 			},
 			error : function(e) {
 				alert("Error!")
 				console.log("ERROR: ", e);
 			}
 		}); 
    }    
    
	// delete request
    $(document).on("click",".btnStatus", function() {
		
		var taiKhoanId = $(this).parent().prev().children().val();
		var confirmation;
		
		if(this.value == 1){
			confirmation = confirm("Tài khoản sẽ bị khóa?");
		}else{
			confirmation = confirm("Xác nhận mở khóa tài khoản?");
			
		}
		if(confirmation){
		  $.ajax({
			  type : "PATCH",
			  url : "http://localhost:8080/api/tai-khoan/change-status/" + taiKhoanId,
			  success: function(resultMsg){
				  resetData();
			  },
			  error : function(e) {
				 console.log("ERROR: ", e);
			  }
		  });
		}
     });
    
	// event khi ẩn modal form
	$('#taiKhoanModal').on('hidden.bs.modal', function(e) {
		e.preventDefault();
		$('.taiKhoanForm input').next().remove();
	});
    
    // reset table after post, put, filter
    function resetData(){   	
    	var page = $('li.active').children().text();
    	$('.taiKhoanTable tbody tr').remove();
    	$('.pagination li').remove();
        ajaxGet(page);
    };
    
    (function ($) {
        $.fn.serializeFormJSON = function () {

            var o = {};
            var a = this.serializeArray();
            $.each(a, function () {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };
    })(jQuery);
    
    // remove element by class name
    function removeElementsByClass(className){
        var elements = document.getElementsByClassName(className);
        while(elements.length > 0){
            elements[0].parentNode.removeChild(elements[0]);
        }
    }
});