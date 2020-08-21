
let clickedElement;
function dayClicked(id) {
    
    if (clickedElement != null) {}
    /*
    let AllElement = document.querySelectorAll(".thisMonth");
    array.forEach(element => {
        element.style.backgroundColor = "aliceblue";
    });
    */
    let element = document.getElementById(id);
    clickedElement = element;
    element.style.backgroundColor = "lavenderblush";
}