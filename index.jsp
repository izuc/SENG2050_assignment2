<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Deal or No Deal</title>
        <link rel="stylesheet" type="text/css" href="styles.css" media="screen" />
		<script type="text/javascript" src="jquery.min.js"></script>
        <!-- The game.js file contains the required functions for handling
            the requests to and from the Game. It is done like this to prevent
            the rollback by 'clicking the back button' so instead the page
            is just loaded once.
        -->
        <script type="text/javascript" src="game.js"></script>
    </head>
    <body>
        <div id="main_container">
            <div id="banner"></div>
            <div id="body_container">
                <div id="side_menu">
                    <div id="bank">
                        <div id="bank_header"></div>
                        <div id="bank_repeat">
                            <!-- The bank side panel is loaded via Ajax
                                into this div. Please see the game.js file.
                            -->
                        </div>
                        <div id="bank_footer"></div>
                    </div>
                    <div id="navigation">
                        <div id="restart_button" onclick="restart()"></div>
                    </div>
                </div>
                <div id="content">
                    <div id="content_header"></div>
                        <div id="content_repeat">
                            <div id="game">
                                <!-- The Game content is loaded via Ajax
                                    into this div. Please see the game.js file.
                                -->
                            </div>
                        </div>
                        <div id="content_footer">
                            <div id="validator_links">
                                <a href="http://jigsaw.w3.org/css-validator/check/referer">
                                <img style="border:0;width:88px;height:31px"
                                         src="http://jigsaw.w3.org/css-validator/images/vcss-blue" alt="Valid CSS!" />
                                </a>
                                <a href="http://validator.w3.org/check?uri=referer">
                                 <img style="border:0;width:88px;height:31px" src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Strict" /></a>
                            </div>  
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>