window.onload = function() {
    var boxes   = document.getElementsByTagName('input');
    var player  = false;


    for(var i=0; i<boxes.length; i++) {
        boxes[i].indeterminate = true;

        boxes[i].onclick = function (e) {
            this.checked = player;
            this.disabled = true;

            //USER MOVES: Get the row & col and do the Move in our game
            var row = $(this).attr('id').substr(0, 1);
            var column = $(this).attr('id').substr(1, 2);
            //var status = doMove(player, row, column);
            $.ajax({
                type: "post",
                url: "http://localhost:8080/rest/executeTurn",
                async: false,
                cache: false,
                data: 'turn=' + player + "&column=" + column + "&row=" + row,
                success: function (result) {
                    if (result != "Playing") {
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

            player = !player;

            //if (status != "Playing") {
                //Turn for the Computer
                //status = computerMove(player);
                //if (status == "Player X Wins" || status == "Player O Wins") {
                //    finishGame();
                //}
            }
            //else {
            //    finishGame();
            //}
        }

    function doMove(player, row, column) {
        $.ajax({
            type: "post",
            url: "http://localhost:8080/rest/executeTurn",
            async: false,
            cache: false,
            data: 'turn=' + player + "&column=" + column + "&row=" + row,
            success: function (result) {
                if (result != "Playing") {
                    finishGame(result);
                }
                else {
                    computerMove(!player);
                }
            },
            error: function () {
                alert('Error while request..');
            }
        });
    }


    function computerMove(player) {

        //COMPUTER MOVES:
        //Get a random empty row and column
        do {
            var row = Math.floor(Math.random() * 3) + 1;
            var column = Math.floor(Math.random() * 3) + 1;
            var computerMove = $("#" + row + column);
        } while (computerMove.prop('disabled', true));

        //Check the cell and disable it
        computerMove.prop('indeterminate', false);
        computerMove.prop('checked', player);
        computerMove.prop('disabled', true);

        //Do the computer Move in our Game
        return doMove(player, row, column);
    }

    function finishGame(status) {

        deactivateAllCells();
        reStart();
        if (confirm(status + "\n\nWould you like to play again")) {
            window.location.reload(true);
        }
        else {
            $("#gameover").show();
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
