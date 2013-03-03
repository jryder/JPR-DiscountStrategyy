


package jpr.discountstrategy;

/**
 *
 * This is a discount strategy subclass that uses a flat discount amount.  The flat
 * amount is a percentage discount off of the line total for the total qty.  
 * For example, a 10% discount on 2 items sold at 10 each for a line total of 
 * $20.00 would result in a $2.00 discount.
 * 
 * @author jryder
 */
public class FlatPercentDiscount implements DiscountStrategy {

    private double rate;

    /**
     * Sets the flat discount rate
     * 
     * @param rate 
     */
    public FlatPercentDiscount(double rate){
	this.rate = rate;
    }
    
    /**
     * Return the rate of discount
     * 
     * @return rate - discount percentage
     */
    public double getRate() {
	return rate;
    }

    
    /**
     * Set the discount rate
     * 
     * @param rate 
     */
    public void setRate(double rate) {
	this.rate = rate;
    }

    
    /**
     * 
     * Returns the actual discount based on the product quantity and product sell
     * 
     * @param unitSell
     * @param qty
     * @return amt the net discount amount
     */
    @Override
    public double getDiscount(double unitSell, int qty) {
        double amt = qty * unitSell * rate;
        return amt;
    }

    
    /**
     * Generic set variable method, used to set the rate in this case.  
     * 
     * @param var 
     */
    @Override
    public void setVariable(double var) {
	rate = var;
    }
}
