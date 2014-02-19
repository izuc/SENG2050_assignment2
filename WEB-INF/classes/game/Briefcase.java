/*	
 * 	Author: Lance Baker
 *	Student No: 3128034
 *      Course: SENG2050
 *	Date: 15-09-2011
 *	Description: 
 * 	The Briefcase is a simple class in which allows an Case Object to be 
 *      created containing the amount within, the number assigned, and also
 *      whether the case is open or closed.
 */

package game;

public class Briefcase {
    private double amount;
    private boolean open;
    private int number;
    
    /**
     * The constructor for the Briefcase accepts
     * the amount value, and by default sets the
     * open attribute to false.
     * @param amount 
     */
    public Briefcase(double amount) {
        this.amount = amount;
        this.open = false;
    }
    
    /**
     * Setter for the amount.
     * @param double amount 
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    /**
     * Getter for the amount.
     * @return double amount.
     */
    public double getAmount() {
       return this.amount;
    }
    
    /**
     * Setter for the boolean indicating
     * whether the case is open or closed.
     * @param open boolean.
     */
    public void setOpen(boolean open) {
        this.open = open;
    }
    
    /**
     * Getter for whether the case is open.
     * @return boolean value.
     */
    public boolean isOpen() {
        return this.open;
    }
    
    /**
     * Setter for the number assigned.
     * @param int number 
     */
    public void setNumber(int number) {
        this.number = number;
    }
    
    /**
     * Getter for the number assigned.
     * @return int number.
     */
    public int getNumber() {
        return this.number;
    }
}
