const daBody = document.getElementById("the-body");
const daBlood = document.getElementById("the-blood");
let bodyContent = `<p style="height: 25px" id="body-p">yoooooooooooo</p>`;
let bloodContent = `<p id="blood-p">plasma and what not</p>`;
const bloodP = document.getElementById("blood-p");
function loadDaBody(){
    daBody.innerHTML = bodyContent;
    let item = document.getElementById('body-p');
    item.addEventListener("click", changeDaBody)
}
function loadDaBlood(){
    daBlood.innerHTML = bloodContent;
}

function changeDaBody() {
    let item = document.getElementById('body-p');
item.innerHTML = "AHHAHHAHAHHA";
    console.log("body")

} function changeDaBlood(){
    bloodP.innerHTML = "Brought to you by a setTimeout!";
}

