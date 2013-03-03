
package jpr.discountstrategy;

/**
 *
 * This is a discount strategy where the discount increases by a factor for each additional 
 * quantity that is purchased.  So the discount percent ends up being 10%,11%,12% by each item
 * for example
 * 
 * @author Jordan Ryder
 */
public class QtyIncreaseDiscount implements DiscountStrategy {
    private double startingDiscountRate = 0.10;
    private double increment = 0.01;

    
    /**
     * 
     * This sets the discount configuration.  There is a starting discount amount
     * and an increment for what the discount increases by each time.  
     * 
     * @param startingDiscountRate
     * @param increment 
     */
    public QtyIncreaseDiscount(double startingDiscountRate, double increment ){
	this.startingDiscountRate = startingDiscountRate;
	this.increment = increment;
    
    }
    
    
    /**
     * Get the discount based on the unitSell and the qty
     * 
     * @param unitSell
     * @param qty
     * @return total discount for the lines (quantity passed in by the high level class)
     */
    @Override
    public double getDiscount(double unitSell, int qty){
        double highDiscount = startingDiscountRate + ((qty - 1) * increment);
        double avgDiscount = (startingDiscountRate + highDiscount) / 2;        
        double amt = qty * unitSell * (1 - avgDiscount);
        return amt;
    }
    
    
    /**
     * Get the discount rate for the class
     * @return 
     */
    public double getStartingDiscountRate() {
        return startingDiscountRate;
    }

    
    /**
     * Set the starting discount rate
     * @param startingDiscountRate 
     */
    public void setStartingDiscountRate(double startingDiscountRate) {
        this.startingDiscountRate = startingDiscountRate;
    }

    
    /**
     * Get the discount increment amount
     * @return 
     */
    public double getIncrement() {
        return increment;
    }

    
    /**
     * Set the increment mount
     * @param increment 
     */
    public void setIncrement(double increment) {
        this.increment = increment;
    }
    
    /**
     * Testing only
     * @param args 
     */
    public static void main(String[] args) {
        //QtyIncreaseDiscount q = new QtyIncreaseDiscount();
        //System.out.println(q.getDiscount(5, 10));
    }

    /**
     * Set discount rate.  This is needed for polymorphism
     * @param var 
     */
    @Override
    public void setVariable(double var) {
	startingDiscountRate = var;
    }
    
    
}
