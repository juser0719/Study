function login() {
    var userid = prompt("아이디입력", "ssafy");
    if (userid.length == 0) {
        alert("아이디 입력!!!");
        return;
    }
    var userpass = prompt("비밀번호입력", "1234");
    if (userpass.length == 0) {
        alert("비밀번호 입력!!!");
        return;
    }
    if (userid == "ssafy" && userpass == "1234") {
        alert("로그인 성공");
        // id가 profile_img인 element의 src 속성의 값을 img/profile.png로 바꿈
        document.getElementById("profile_img").src = "img/profile.png";
        document.getElementById("header_nav_confirm_off").style.display = "none";
        document.getElementById("header_nav_confirm_on").style.display = "block";
    } else {
        alert("아이디 또는 비밀번호 확인하시오")
    }
}

function logout() {
    document.querySelector("#profile_img").setAttribute("src", "img/noimg.png");
    document.querySelector("#header_nav_confirm_off").setAttribute("style", "display : none");
    document.querySelector("#header_nav_confirm_on").setAttribute("style", "display : block");
}
var cnt = 0;
function allSlide(onoff) {
    if (onoff == "on") {  //펼치기
        var subs = document.getElementsByClassName("store_item_sub");
        for (var i = 0; i < subs.length; i++) subs[i].style.display = "block";

        document.getElementsByClassName("store_display_off")[0].style.display = "block";
        document.getElementsByClassName("store_display_on")[0].style.display = "none";
        cnt = 4;
    } else {  //접기
        var subs = document.getElementsByClassName("store_item_sub");
        for (var i = 0; i < subs.length; i++) subs[i].style.display = "none";

        document.getElementsByClassName("store_display_off")[0].style.display = "none";
        document.getElementsByClassName("store_display_on")[0].style.display = "block";
        cnt = 0;
    }
}

function slideDown(areaid) {
    if (areaid.style.display === "none") {
        areaid.style.display === "display";
        cnt++;
    }
}

function poll() {
    const votes = document.getElementsByName("vote_answer");
    let sel_menu = "";
    for (var i = 0; i < votes.length; i++)
        if (votes[i].checked == true) {
            sel_menu = votes[i].value;
            break;
        }
    alert(sel_menu);
}

function pollMake() {
    window.open("pollmake.html", "poll", "width=420,height =300, top = 300,left = 400");
}

function addAnswer() {
    let listDiv = document.getElementsById("poll_answer_list");
    let divEl = document.createElement("div");
    divEl.setAttribute("class", "poll_answer_item");
    let inputEl = document.createElement("input");
    inputEl.setAttribute("type", "text");
    let bottonEl = document.createElement("button");
    bottonEl.setAttribute("type", "button");
    bottonEl.setAttribute("class", "button");

    bottonEl.addEventListener("click", (e) => {
        let parent = this.parentNode;
        listDiv.removeChild(parent);
    });
    bottonEl.appendChild(document.createTextNode("삭제"));

    divEl.appendChild(inputEl);
    divEl.appendChild(bottonEl);
    divEl.appendChild(inputEl);
}

function makePoll() {
    if (!document.querySelector("#question").value) {
        alert("질문 내용을 입력하시오");
        return;
    }
    let answers = document.getElementsByName("answer");
    for (var i = 0; i < answers.length; i++)
        if (!answers[i].value) {
            alert("check again")
            return;
        }
    alert("create vote");
    self.close()
}