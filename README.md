SENG2050 Assignment 2
Student: Lance Baker (c3128034)

The Java Bean used is called “Game”;  the bean contains an ArrayList of 
Briefcase objects, and managing methods in which allow the cases to be
opened, rounds to increment, the bank offer to be calculated, and other 
managing methods. 

The Briefcase object contains the dollar amount, the number of the case, and
 also a Boolean value indicating whether it has been opened or not. The 
methods within are just getters & setters that encapsulate the attributes. 

When the user loads index.jsp, the game utilises JavaScript to make Ajax 
calls (with the functionality being provided by JQuery) to load the game.jsp file
into a div id. This circumvents the issue with the back button on the browser 
rolling back the game, since once the game loads; the JavaScript does the
work with fetching and loading the cases & side panel.

Session tracking is implemented by using the scope="session" on the
useBean. This enables for JSP to do all the work with managing the sessions,
and therefore not requiring any additional implementation to handle the tracking.

The Java files are located within WEB-INF\classes\game