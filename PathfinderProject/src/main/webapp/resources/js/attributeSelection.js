/**
 * 
 */

var attributes = ["STR", "DEX", "CON", "INT", "WIS", "CHA"];
var oldValues = [10, 10, 10 , 10 , 10, 10];
var newValues = [10, 10, 10 , 10 , 10 , 10];

for (var i = 0; i < attributes.length; i++) {
	
	oldValues[i] = document.getElementById(attributes[i]).value;
}

var ep = document.getElementById("enhancementPoints").value;

function alterEnhancementPoints() {

	for (var i = 0; i < newValues.length; i++) {
		
		newValues[i] = document.getElementById(attributes[i]).value;
		
		if (oldValues[i] !== newValues[i]) {
			
			document.getElementById("enhancementPoints").value = parseInt(ep) + (parseInt(oldValues[i]) - parseInt(newValues[i]));
			ep = document.getElementById("enhancementPoints").value;
			oldValues[i] = newValues[i];
		}
	}
	
	if (parseInt(ep) === 0) {
		
		document.getElementById("submitButton").disabled = false;
	} else {
		
		document.getElementById("submitButton").disabled = true;
	}
}