const url = 'http://localhost:8080/ERS';

//variables to get entered values to get data from database
let username = document.getElementById("username");
let password = document.getElementById("password");

//allows a user to log in
let loginbtn = document.getElementById("loginbtn");

//waits for click action to call the loginFunc
loginbtn.addEventListener('click', loginFunc);

async function loginFunc() {
    let uName = document.getElementById('username').value;
    let uPass = document.getElementById('password').value;

    //converts variable credentials to json format
    let user = {
        username: uName,
        password: uPass
    }

    //sends post request to login servlet
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
            window.location.replace('file:///file:///Z:/Users/mitch/eclipse-workspace/Eclipse/ERS/project-2-we-re-not-objects/Frontend/ReimbursementApp.html');
        } else {
            window.location.replace('file:///Z:/Users/mitch/eclipse-workspace/Eclipse/ERS/project-2-we-re-not-objects/Frontend/ApplicationManager.html');
        }
    }

}