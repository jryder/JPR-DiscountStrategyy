

package jpr.discountstrategy;



/**
 * Pretty straightforward, just returns a flat discount amount
 * @author jryder
 */
public class FlatAmountDiscount implements DiscountStrategy {
    
    
    private double discountAmount = 100;

    /**
     * Sets the flat discount amount
     * 
     * @param discountAmount 
     */
    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }
    
    /**
     * getter to retrieve the discount amount total.  The qty has no impact here
     * 
     * @param unitSell
     * @param qty
     * @return discountAmount
     */
    
    @Override
    public double getDiscount(double unitSell, int qty){
        return discountAmount;
    }
  

    
    /**
     * 
     * sets a variable.  This method sets the discountAmount
     * 
     * @param var 
     */
    @Override
    public void setVariable(double var) {
	discountAmount = var;
    }
}
