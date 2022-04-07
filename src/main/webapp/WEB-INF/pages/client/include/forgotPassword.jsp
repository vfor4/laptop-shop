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
    <style>
      .myStyle {
        background-color: coral;
        padding: 16px;
      }

      .newStyle {
        background-color: lightblue;
        text-align: center;
        font-size: 25px;
        padding: 16px;
      }

      #loader {
        position: absolute;
        left: 50%;
        top: 50%;
        z-index: 1;
        width: 120px;
        height: 120px;
        margin: -76px 0 0 -76px;
        border: 16px solid #f3f3f3;
        border-radius: 50%;
        border-top: 16px solid #3498db;
        -webkit-animation: spin 2s linear infinite;
        animation: spin 2s linear infinite;
      }

      @-webkit-keyframes spin {
        0% {
          -webkit-transform: rotate(0deg);
        }

        100% {
          -webkit-transform: rotate(360deg);
        }
      }

      @keyframes spin {
        0% {
          transform: rotate(0deg);
        }

        100% {
          transform: rotate(360deg);
        }
      }

      /* Add animation to "page content" */
      .animate-bottom {
        position: relative;
        -webkit-animation-name: animatebottom;
        -webkit-animation-duration: 1s;
        animation-name: animatebottom;
        animation-duration: 1s
      }

      @-webkit-keyframes animatebottom {
        from {
          bottom: -100px;
          opacity: 0
        }

        to {
          bottom: 0px;
          opacity: 1
        }
      }

      @keyframes animatebottom {
        from {
          bottom: -100px;
          opacity: 0
        }

        to {
          bottom: 0;
          opacity: 1
        }
      }

      #myDiv {
        display: none;
        text-align: center;
      }
    </style>

    <body>

      

        <div id="loader" hidden></div>

        <div style="display:none;" id="myDiv" class="animate-bottom">
          <h2>Tada!</h2>
          <p>Some text in my newly loaded page..</p>
        </div>


        <hr>
        <div class="container bg-success" style="padding-top:8px;">
          <div class="row">
            <div class="row">
              <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-default">
                  <div class="panel-body">
                    <div class="text-center">
                      <h3><i class="fa fa-lock fa-4x"></i></h3>
                      <h2 class="text-center">QUÊN MẬT KHẨU</h2>
                      <p id="message" style="font-size: 25px;">Nhập địa chỉ email đã đăng kí</p>
                      <p id="message2"></p>

                      <div class="panel-body">

                        <form class="form" action="#" method="POST" name="form1" onsubmit="resetPassword()">
                          <fieldset>
                            <div class="form-group">
                              <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon-envelope color-blue"></i></span>

                                <input name="email" id="emailInput" placeholder="email address" class="form-control"
                                  type="email" required="">
                              </div>
                            </div>
                            <br>
                            <br>
                            <div class="form-group">
                              <button class="btn btn-lg btn-primary btn-block" type="submit"
                                onclick="ValidateEmail(document.form1.email)">
                                Send My Password</button>
                            </div>
                          </fieldset>
                        </form>

                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <script src="<c:url value='/js/client/forgotPasswordAjax.js'/>"></script>
      </body>

    </html>