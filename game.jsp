<%@page import="game.Briefcase"%>
<jsp:useBean id="game" class="game.Game" scope="session" />
<%
    // If the 'open' parameter is received, it is converted to
    // an integer and passed to the method setOpen. The value given
    // is the corresponding index for the ArrayList Object.
    if (request.getParameter("open") != null) {
        game.setOpen(Integer.parseInt(request.getParameter("open")));
    }
    // If the 'restart' parameter is given, then the restart method
    // is invoked on the game bean.
    if (request.getParameter("restart") != null) {
        game.restart();
    }
    // If the deal parameter is given, then it converts it to a Boolean
    // value and performs a conditional test. If the parameter is true,
    // then the deal has been made so the page is forwarded to the deal.jsp.
    // Otherwise, the gameRound() is incremented cause it is NO DEAL!.
    if (request.getParameter("deal") != null) {
        if (Boolean.parseBoolean(request.getParameter("deal"))) {
            game.setAcceptDeal(true);
        } else {
            game.nextRound();
        }
    }
    // If there is a Bank Offer, it will display the amount offered with
    // two buttons to either accept or refuse.
    if (!game.isAcceptDeal()) {
        if (game.isOffer()) {%>
                <div id="bank_offer">
                    <div id="bank_offer_title"></div>
                    <div id="deal_button" onclick="deal(true)"></div>
                    <div id="bank_offer_text">
                        <div id="bank_offer_amount">$<jsp:getProperty name="game" property="bankOffer" /></div>
                        <div id="bank_offer_message">Highest amount left: $<jsp:getProperty name="game" property="highestAmount" /></div>
                    </div>
                    <div id="nodeal_button" onclick="deal(false)"></div>
                </div>
        <%
        // Otherwise, the Briefcases will be displayed along with a game message 
        // above the cases.
        } else {
        %>
                <div id="game_message">
                    <div id="game_round">
                        <% if (game.getRound() > 0) { %>
                        Round: <jsp:getProperty name="game" property="round" />
                        <% } %>&nbsp;
                    </div>
                    <div id="game_text">
                        <jsp:getProperty name="game" property="message" />
                    </div>
                </div>
                <div id="cases">
        <%
                int index = 0;
                // Iterates For Each Briefcase 
                for (Briefcase briefcase : game.getCases()) {
                    // If the Briefcase is not opened, then it is displayed as closed with the
                    // number assigned. Otherwise, if the Briefcase is opened then it is displayed
                    // as open with the amount value inside.
                    if (!briefcase.isOpen()) {
                        // If the Briefcase is the chosen case, then it will be displayed with
                        // 'Your Briefcase' on the image. The Briefcase's once pressed invokes
                        // a JavaScript function called openBriefcase() which passes the 
                        // index. The function then invokes an Ajax call to the same .jsp which the
                        // html is then placed into the game container on the main index.jsp.
                    %>
                        <div onclick="openBriefcase(<%=index%>)" class="<%=(((game.getChosen() != null) 
                                && game.getChosen().equals(briefcase)) ? "briefcase_chosen" : "briefcase_closed")%>">
                        <div class="briefcase_number"><%=briefcase.getNumber()%></div></div>
                    <%} else {
                      // Once the case is opened it gets displayed with an open background
                      // with the case amount centered.
                      %>
                        <div class="briefcase_open">
                            <div class="briefcase_amount">$<%=briefcase.getAmount()%></div>
                        </div>
                    <%}
                    index++;
                }%>
                </div>
        <%
        }
    } else { %>
    <div id="deal_message">
        Deal $<jsp:getProperty name="game" property="bankOffer" />
    </div>
 <%
    }
    %>