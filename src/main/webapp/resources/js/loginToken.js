
loginAdminPageWithToken = (token) => {
    let tokenWithBearer = "Bearer " + token
    var settings = {
        "url": "http://localhost:8080/admin",
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Authorization": tokenWithBearer,
        },
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}

login = () => {
    var myvar = '${response.toString()}';
    alert(myvar)
    // var user = document.getElementById("email").value;
    // var password = document.getElementById("password").value;
    // var myHeaders = new Headers();
    // myHeaders.append("Content-Type", "application/x-www-form-urlencoded");

    // var urlencoded = new URLSearchParams();
    // urlencoded.append("email", user);
    // urlencoded.append("password", password);

    // var requestOptions = {
    //     method: 'POST',
    //     headers: myHeaders,
    //     body: urlencoded,
    //     redirect: 'follow'
    // };

    // fetch("http://localhost:8080/login", requestOptions)
    //     .then(response => {
    //         if (response.ok) {
    //             return response.text()
    //         }
    //         throw Error(response.status)
    //     })
    //     .then(result => {
            
    //         let token = JSON.parse(result).accessToken;
    //         let role = JSON.parse(result).role
    //         role = role.slice(1, role.length - 1)
    //         // console.log(JSON.parse(result))
    //         localStorage.setItem("accessToken", token)
    //         if (role === 'ROLE_ADMIN') {
    //             loginAdminPageWithToken(token)
    //         }
    //         else if (role === 'ROLE_MEMBER') {
    //             console.log("ROLE_MEMBER")
    //         }
    //     })
    //     .catch(error => console.log('error', error));

}