window.onload = function() {
    var boxes   = document.getElementsByTagName('input');
    var player  = false;

    for(var i=0; i<boxes.length; i++) {
        boxes[i].indeterminate = true;

        boxes[i].onclick = function(e) {
            this.checked = player;
            this.disabled = true;
            player = !player;
            var row = $(this).attr('id').substr(0, 1);
            var column = $(this).attr('id').substr(1, 2);
            $.ajax({
                type: "post",
                url: "http://localhost:8080/rest/executeTurn",
                cache: false,
                data: 'turn=' + player + "&column=" + column + "&row=" + row,
                success: function (result) {
                    if(result != "Playing") {
                        deactivateAllCells();
                        reStart();
                        if (confirm(result + "\n\nWould you like to play again")) {
                            window.location.reload(true);
                        }
                        else {
                            $("#gameover").show();
                        }

                    }
                },
                error: function () {
                    alert('Error while request..');
                }
            });
        }

    }
    function deactivateAllCells() {
        for (var i = 0; i < boxes.length; i++) {
            boxes[i].disabled = true;
        }
        player = false;
    }

    function reStart() {
        $.ajax({
            type: "get",
            url: "http://localhost:8080/rest/restart",
            cache: false,
            success: function () {
            },
            error: function () {
            }
        });

    }


}
