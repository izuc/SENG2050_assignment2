// The openBriefcase function uses Ajax to send a 
// post data request to the game.jsp file; passing also
// the case index variable.
function openBriefcase(index) {
    $.post("game.jsp", {
        open: index
    }, function(data) {
        // The recieved data response from game.jsp
        // is then whacked into the game div (on index.jsp).
        $('#game').html(data);
    });
    // Reloads the 'Bank' side panel.
    loadBank();
}

// The restart() function sends a Ajax post data request
// to the game.jsp file. It passes a parameter called 
// 'restart' which is handled in the .jsp to restart the 
// game. The resulting html is then passed into the game div.
function restart() {
    $.post("game.jsp", {
        restart: true
    }, function(data) {
        $('#game').html(data);
    });
    loadBank();
}

// The deal function sends an Ajax post request to the game.jsp
// file (like the others). It passes the deal boolean value as the
// data. The result html is then loaded into the game div.
function deal(value) {
    $.post("game.jsp", {
        deal: value
    }, function(data) {
        $('#game').html(data);
    });
}

// The loadBank() function is used to load the side bar containing
// the money which has (or has not) been opened. It uses the Ajax
// call to the bank.jsp file which queries the Game object and outputs
// html code in which is then added to the corresponding div.
function loadBank() {
    $.ajax({
        url: "bank.jsp",
        cache: false,
        success: function(html){
            $('#bank_repeat').html(html);
        }
    });
}

// The default load is done once JQuery has
// successfully been loaded (using document.ready).
$(document).ready(function() {
    // The Briefcases are initially loaded via an
    // Ajax call to the game.jsp file without any parameters.
    // The cache: false enables for the content to be reloaded
    // without caching occurring.
    $.ajax({
        url: "game.jsp",
        cache: false,
        success: function(html){
            // The html returned is just whacked into the game div.
            $('#game').html(html);
        }
    });
    // The left bank panel is loaded 
    // via the loadBank() function.
    loadBank();
});