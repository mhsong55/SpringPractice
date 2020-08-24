
let clickedElement;
function dayClicked(id) {
    
    if (clickedElement != null) {
        clickedElement.style.backgroundColor = "aliceblue";
    }
    let selectedElement = document.getElementById(id);
	if (clickedElement == selectedElement) {
		clickedElement.style.backgroundColor = "aliceblue";
		document.getElementById("reservationBoard").style.display = "none";
		clickedElement = null;
	} else {
	    clickedElement = selectedElement;
	    selectedElement.style.backgroundColor = "lavenderblush";
		reservationElement = document.getElementById("reservationBoard");
		reservationElement.style.display = "block";
	}
}