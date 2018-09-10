function enableChildElements(parentId, enabled) {
    var parent = document.getElementById(parentId);
    enableChildInputs(parent, enabled);
    enableChildButtons(parent, enabled);
}

function enableChildInputs(parent, enabled) {
    var inputs = parent.getElementsByTagName('input');
    for(var i = 0; i < inputs.length; i++) {
        inputs[i].disabled = !enabled;
    }
}

function enableChildButtons(parent, enabled) {
	var buttons = parent.getElementsByTagName('button');
    for(var i = 0; i < buttons.length; i++) {
        buttons[i].disabled = !enabled;
    }
}