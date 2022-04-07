
let validateEmail;
function ValidateEmail(inputText) {
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (inputText.value.match(mailformat)) {
        document.form1.email.focus();
        validateEmail = true;
    }
    else {
        // alert("Định dạng email không đúng!");
        document.form1.email.focus();
        validateEmail = false;
    }
}

$(document).ready(function () {
    resetPassword = () => {
        event.preventDefault()
        if (validateEmail === true) {
            ajax1()
        }
    }

    function ajax1() {
        let p = document.getElementById("loader");
        p.removeAttribute("hidden");
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/tai-khoan/forgot_password?email=" + document.form1.email.value,

            success: function (result) {
                const element = document.getElementById("message")
                if (result.status == "401") {
                    element.className = "bg-danger";
                    element.textContent = "Email chưa được đăng kí";
                } else if (result.status == "200") {
                    document.getElementById("loader").style.display = "none";
                    element.className = "bg-success";
                    element.textContent = "Kiểm tra hộp thư và làm theo hướng dẫn."
                    document.getElementById("message2").innerHTML = ""
                    $("#message2").append("<br> <a href='/'>Trang chủ</a>")
                }
            },
            error: function (e) {
                console.log("Error", e);
            }
        });
    }
});