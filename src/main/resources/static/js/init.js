window.onload = function() {
    var boxes   = document.getElementsByTagName('input');
    var player  = false;
    $("#gameover").hide();

    //$.ajax({
    //    type: "get",
    //    url:"http://localhost:8080/rest",
    //    success: function (data) {
    //       $("#maxScore").append("<h2>Your maximum Score is: " + data + "</h2>");
    //    }
    //});
    start();

    for(var i=0; i<boxes.length; i++) {
        boxes[i].indeterminate = true;

        boxes[i].onclick = function(e) {
            this.checked = player;
            this.disabled = true;
            //player = !player;
            var row = $(this).attr('id').substr(0, 1);
            var column = $(this).attr('id').substr(1, 2);



            executeTurn(player, column, row);
        }

    }



}
