<%@page import="game.Game"%>
<jsp:useBean id="game" class="game.Game" scope="session" />
<div id="bank_money">
<%
    // Iterates through the CASE_AMOUNTS public constant double array in order to be
    // able to get the case amount values iterated in sequential order without affecting
    // the game. In each iteration the amount is then checked with the Game using the
    // isOpen() method (passing the amount as an argument); which checks as to whether
    // the case with the corresponding amount has been opened. If the case has been opened
    // then the style is then applied using the line-through effect on the text.
    for (double amount : Game.CASE_AMOUNTS) {%>
            <div class="money_left">
                <div class="money_amount" <%=(game.isOpen(amount)?" style=\"text-decoration: line-through;\"":"")%>><%=amount%></div>
            </div>
        <%
    }
%>
</div>