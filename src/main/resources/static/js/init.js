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

    $('input[type="checkbox"]').click(function() {

        alert($(this).getAttribute('id'))
        var row = $(this).attr('id').substr(0, 0);
        var column = $(this).attr('id').substr(1, 1);
        $.ajax({
            type: "post",
            url: "http://localhost:8080/rest/executeTurn",
            cache: false,
            data: 'turn=' + player + "&column=2" + "&row=1",
            success: function (response) {
                alert( $(this).attr('id') );
            },
            error: function () {
                alert('Error while request..');
            }
        });
        alert('ok');
    });

}
