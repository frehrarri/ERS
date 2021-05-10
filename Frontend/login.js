
const url = 'http://localhost:8080/ERS';

//variables to get entered values to get data from database
let username = document.getElementById("username");
let password = document.getElementById("password");
let role;
let userId;

//submits login http request
let loginbtn = document.getElementById("loginbtn");
loginbtn.addEventListener('click', loginFunc);

async function loginFunc() {
    let uName = document.getElementById('username').value;
    let uPass = document.getElementById('password').value;

    let user = {
        username: uName,
        password: uPass
    }

    let resp = await fetch(url + "/login", {
        method: "POST",
        body: JSON.stringify(user)
    })

    if (resp.status === 200) {

        let data = await resp.json();

        localStorage.setItem("username", uName);
        localStorage.setItem("role_id", data.role);
        localStorage.setItem("user_id", data.user_id);

        if (data.role == 1) {
            document.getElementById("username").style.visibility = "hidden";
            document.getElementById("password").style.visibility = "hidden";
            document.getElementById("login").style.visibility = "hidden";
            document.getElementById("loginbtn").style.visibility = "hidden";
            window.location.replace('file:///Z:/Users/mitch/eclipse-workspace/Eclipse/ERS/project-2-we-re-not-objects/Frontend/ManagerInterface.html');
        } else if (data.role == 2) {
            document.getElementById("username").style.visibility = "hidden";
            document.getElementById("password").style.visibility = "hidden";
            document.getElementById("login").style.visibility = "hidden";
            document.getElementById("loginbtn").style.visibility = "hidden";
            window.location.replace('file:///Z:/Users/mitch/eclipse-workspace/Eclipse/ERS/project-2-we-re-not-objects/Frontend/EmployeeInterface.html');
        }
        document.getElementsByTagName('body').innerHTML = 'Something went wrong. Please try again.';
    }
    document.getElementsByTagName('body').innerHTML = 'Something went wrong. Please try again.';

}

