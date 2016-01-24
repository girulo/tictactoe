window.onload = function() {
    var boxes   = document.getElementsByTagName('input');
    var player  = false;
    $("#gameover").hide();

    $.ajax({
        type: "get",
        url:"http://localhost:8080/rest",
        success: function (data) {
           $("#maxScore").append("<h2>Your maximum Score is: " + data + "</h2>");
        }
    });

    for(var i=0; i<boxes.length; i++) {
        boxes[i].indeterminate = true;

        boxes[i].onclick = function(e) {
            this.checked = player;
            this.disabled = true;
            //player = !player;
            var row = $(this).attr('id').substr(0, 1);
            var column = $(this).attr('id').substr(1, 2);
            $.ajax({
                type: "post",
                url: "http://localhost:8080/rest/executeTurn",
                cache: false,
                async: false,
                data: 'turn=' + player + "&column=" + column + "&row=" + row,
                success: function (data) {
                    var results = JSON.parse(data);
                    var cell = document.getElementById(results.computerMovePosition);
                    if (results.status == "Playing") {
                        markComputerMoveInTheBoard(cell);

                    }
                    else {
                        if (results.status == "Player X Wins"){
                            markComputerMoveInTheBoard(cell);
                        }
                        deactivateAllCells();
                        reStart();
                        if (confirm(results.status + "\n\nWould you like to play again")) {
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

    function markComputerMoveInTheBoard(cell) {

        cell.indeterminate = false;
        cell.checked = !player;
        cell.disabled = true;
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

    function showMaxScore(data) {
        $("#maxScore").append("Your maximum Score is: " + data);
    }

}
