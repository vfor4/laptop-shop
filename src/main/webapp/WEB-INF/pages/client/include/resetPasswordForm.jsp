<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
      <script src="Frontend/js/jquery.min.js"></script>
      <script src="Frontend/js/responsiveslides.min.js"></script>
      <link href="${contextPath}/resources/css/client/bootstrap.min.css" rel="stylesheet">
      <title>QUÊN MẬT KHẨU</title>

    </head>


    <body class="bg-info">


      <hr>
      <div class="container ">
        <div class="row">
          <div class="row">
            <div class="col-md-4 col-md-offset-4">
              <div class="panel panel-default">
                <div class="panel-body">
                  <div class="text-center">
                    <h3><i class="fa fa-lock fa-4x"></i></h3>
                    <p id="message1" style="font-size: 25px;">MỜI NHẬP MẬT KHẨU MỚI</p>
                    <span id="message" style="color:red"> </span>
                    <span id="messageSc" style="color:#5cb85c"> </span>
                    <br>
                    <span id="message3" class= "bg-success"> </span>
                    <div class="panel-body">
                      <form action="reset_password" method="post" style="max-width: 350px; margin: 0 auto;">
                        <div>
                          <input type="hidden" name="reset_token" value="${token}" >
                          <p>
                            <input type="password" name="userPwd" id="password" class="form-control"
                              placeholder="Enter your new password" required autofocus />
                          </p>
                          <p>
                            <input id="password2" type="password" class="form-control" placeholder="Confirm your new password" required
                              oninput="verifyPassword();" />
                          </p>
                          <p class="text-center">
                            <input type="submit" value="Change Password" class="btn btn-primary" />
                          </p>
                        </div>
                      </form>

                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </body>

    </html>
    <script>

      function verifyPassword() {
        var pw = document.getElementById("password").value;
        //check empty password field  
        var pw2 = document.getElementById("password2").value;
        if (pw.length < 8 ) {
          document.getElementById("message").innerHTML = "Mật khẩu phải dài 8-32 ký tự";
          return false;
        }else if (pw == "" || pw2 == "") {
          document.getElementById("message").innerHTML = "Phải nhập mật khẩu mới";
          return false;
        } else if (pw != pw2) {
          document.getElementById("message").innerHTML= "Nhập lại mật khẩu phải giống nhau";
          return false;
        } else if (pw.length > 32) {
          document.getElementById("message").innerHTML = "Mật khẩu phải dài 8-32 ký tự";
          return false;
        } else {
          document.getElementById("message").innerHTML = "";
          document.getElementById("messageSc").innerHTML = "✔️"
          // $("#message3").append("<br> <a href='login'>Đăng Nhập</a>")
          // alert("Password is correct");
        }

      }  
    </script>