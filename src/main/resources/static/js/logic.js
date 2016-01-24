/**
 * Created by hugo on 24/01/16.
 */
function executeTurn(player, column, row) {
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
                markComputerMoveInTheBoard(cell, player);

            }
            else {
                if (results.status == "Player X Wins") {
                    markComputerMoveInTheBoard(cell, player);
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

function start() {
    $.ajax({
        type: "get",
        url:"http://localhost:8080/rest",
        success: function (data) {
            $("#maxScore").append("<h2>Your maximum Score is: " + data + "</h2>");
        }
    });
}
function markComputerMoveInTheBoard(cell, player) {

    cell.indeterminate = false;
    cell.checked = !player;
    cell.disabled = true;
}
function deactivateAllCells() {
    var boxes   = document.getElementsByTagName('input');
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