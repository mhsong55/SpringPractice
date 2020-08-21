/*
var muCnt = 5;
function fncShow(pos) {
    var i = 0;
    for(i; i < muCnt; i++) {
        var obj = document.getElementById("menu" + i);
        var obj2 = document.getElementById("m" + i);
        if (i == pos) {
            obj.style.display = '';
            obj2.style.color = "#ff0000";
        } else {
            obj.style.display = 'none';
            obj2.style.color = "#000000";
        }
    }
}

function fncHide(pos) {
    var obj = document.getElementById("menu" + pos);
    obj.style.display = 'none';
}
*/
function menuItemAddListner() {
    let element = document.getElementsByClassName("menuItem");
    //element.addEventListener("mouseover", element.style.color="#ff0000");
    //element.addEventListener("mouseout", element.style.color="#000000");
}
