/*	
 * 	Author: Lance Baker
 *	Student No: 3128034
 *      Course: SENG2050
 *	Date: 15-09-2011
 *	Description: 
 * 	The Game class is a Java Bean that is used to manage the game. It contains
 *      an ArrayList of Briefcase Objects, and managing methods.
 */
package game;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

    public static final double[] CASE_AMOUNTS = {0.5, 1, 10, 100, 200, 500,
        1000, 2000, 5000, 10000, 20000, 50000};
    private static final int[] CASES_TO_OPEN = {0, 4, 3, 2, 1, 1};
    private ArrayList<Briefcase> cases;
    private int round;
    private int casesToOpen;
    private boolean acceptDeal;
    private Briefcase chosen;

    /**
     * The default constructor is used to initialise the Game with starting values.
     * It invokes the loadBriefcases method which creates the ArrayList of Briefcases
     * in a randomised order.
     */
    public Game() {
        this.cases = new ArrayList<Briefcase>();
        this.round = 0;
        this.acceptDeal = false;
        this.casesToOpen = CASES_TO_OPEN[0];
        this.loadBriefcases();
    }

    /**
     * The loadBriefcases() method is used to create an ArrayList of Briefcase 
     * objects based on the CASE_AMOUNTS constant array. The amounts are shuffled
     * into a randomised order. The cases are then set with a number.
     */
    private void loadBriefcases() {
        // Iterates through the amount values and instantiates an Briefcase
        // with the said value. The object is then added to the ArrayList.
        for (int i = 0; i < CASE_AMOUNTS.length; i++) {
            this.cases.add(new Briefcase(CASE_AMOUNTS[i]));
        }
        // Using the shuffle method belonging to the Collections class
        // it randomises the elements.
        Collections.shuffle(this.cases);
        // Iterates & sets numbers as labels to the cases.
        for (int i = 0; i < this.cases.size(); i++) {
            this.cases.get(i).setNumber((i + 1));
        }
    }

    /**
     * The setOpen() method is used to open a Briefcase based on the given
     * index position. 
     * @param index 
     */
    public void setOpen(int index) {
        // Checks to ensure the index is not out of range.
        if ((index >= 0) && (index < this.cases.size())) {
            // If the round is zero then the game has just started
            // so the selected case is assigned as a reference to
            // the chosen attribute. The cases to open is used
            // to fetch the amount of cases that are going to be 
            // opened the next round.
            if (this.round == 0) {
                this.chosen = this.cases.get(index);
                this.casesToOpen = CASES_TO_OPEN[++this.round];
                //Otherwise the round is greater than 0.
            } else {
                // If the chosen case is not the selected one.
                if (!this.cases.get(index).equals(this.chosen)) {
                    // Then open the selected case.
                    this.cases.get(index).setOpen(true);
                    // Decrement the casesToOpen variable to
                    // one less.
                    this.casesToOpen--;
                    // Otherwise the selected case is the chosen one.
                } else {
                    // Only proceed if the round is the end, and there
                    // are no other cases left to open.
                    if ((this.round == (CASES_TO_OPEN.length - 1))
                            && (this.casesToOpen == 0)) {
                        // Open the chosen case.
                        this.chosen.setOpen(true);
                    }
                }
            }
        }
    }

    /**
     * The isOpen method is used to find out whether the corresponding case 
     * containing the received amount is open or not. 
     * @param amount - The amount
     * @return boolean - Indicating whether the case is open or not.
     */
    public boolean isOpen(double amount) {
        for (Briefcase briefcase : this.cases) {
            if (briefcase.getAmount() == amount) {
                return briefcase.isOpen();
            }
        }
        return false;
    }

    /**
     * Getter for the cases ArrayList.
     * @return ArrayList<Briefcase>
     */
    public ArrayList<Briefcase> getCases() {
        return this.cases;
    }

    /**
     * Getter for the current round.
     * @return int - round.
     */
    public int getRound() {
        return this.round;
    }

    /**
     * Getter for the amount of cases to be opened
     * @return int - cases to be opened.
     */
    public int getCasesToOpen() {
        return this.casesToOpen;
    }

    /**
     * Getter for the chosen Briefcase
     * @return Briefcase chosen.
     */
    public Briefcase getChosen() {
        return this.chosen;
    }

    /**
     * Getter for the game message.
     * @return String game message.
     */
    public String getMessage() {
        return ((this.round == 0) ? "Please select your briefcase"
                : (((this.round == (CASES_TO_OPEN.length - 1))
                && (this.casesToOpen == 0)) ? ((this.chosen.isOpen())
                ? "Congrats! You've won $" + this.chosen.getAmount() : "Open your case!")
                : "You have " + this.casesToOpen + " briefcases to open"));
    }

    /**
     * The isOffer() method checks as to whether it is time for a bank offer.
     * @return boolean - is bank offer.
     */
    public boolean isOffer() {
        return ((this.casesToOpen == 0) && ((this.round > 0)
                && (this.round < (CASES_TO_OPEN.length - 1))));
    }

    /**
     * The nextRound() method increments the round, and sets the 
     * casesToOpen attribute with the next amount.
     */
    public void nextRound() {
        if (this.round < (CASES_TO_OPEN.length - 1)) {
            this.casesToOpen = CASES_TO_OPEN[++this.round];
        }
    }

    /**
     * The restart() method is used to start the game again.
     * It resets the main attribute data, and loads the cases
     * again into a freshly cleared ArrayList.
     */
    public void restart() {
        this.cases.clear();
        this.round = 0;
        this.acceptDeal = false;
        this.casesToOpen = CASES_TO_OPEN[0];
        this.loadBriefcases();
    }

    /**
     * The getHighestAmount() method is used to find the highest amount in the
     * cases ArrayList that hasn't already been opened.
     * @return double - Highest amount left.
     */
    public double getHighestAmount() {
        // Sets the maxValue with the first object's amount.
        double maxValue = this.cases.get(0).getAmount();
        // Iterates through the cases ArrayList.
        for (int i = 1; i < this.cases.size(); i++) {
            // Only proceeds if the case isn't open.
            if (!this.cases.get(i).isOpen()) {
                // If the case's amount is greater than the maxValue stored.
                if (this.cases.get(i).getAmount() > maxValue) {
                    // It then becomes the new maxValue.
                    maxValue = this.cases.get(i).getAmount();
                }
            }
        }
        return maxValue;
    }

    /**
     * The getBankOffer() method calculates & returns a Bank Offer by adding 
     * the unopened case amounts together. The total amount is then divided 
     * by the count. 
     * @return double - Bank Offer.
     */
    public double getBankOffer() {
        int count = 0; // A counter
        double money = 0; // The total money
        // Iterates for each Briefcase
        for (Briefcase briefcase : this.cases) {
            if (!briefcase.isOpen()) { // If the briefcase is not opened.
                // Add the case amount
                money += briefcase.getAmount();
                count++; // Increment the count
            }
        }
        return Math.round(money / count);
    }

    /**
     * Getter for accept deal.
     * @return boolean acceptDeal.
     */
    public boolean isAcceptDeal() {
        return acceptDeal;
    }

    /**
     * Setter for accept deal.
     * @param boolean acceptDeal.
     */
    public void setAcceptDeal(boolean acceptDeal) {
        this.acceptDeal = acceptDeal;
    }
}
