window.onload = function() {
    var boxes   = document.getElementsByTagName('input');
    var player  = true;

    for(var i=0; i<boxes.length; i++) {
        boxes[i].indeterminate = true;

        boxes[i].onclick = function(e) {
            this.checked = player;
            this.disabled = true;
            player = !player;
        }
    }
}
