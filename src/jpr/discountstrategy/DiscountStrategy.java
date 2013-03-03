
package jpr.discountstrategy;

/**
 *
 * Interface that determines what methods a discount strategy should have
 * 
 * @author Jordan Ryder
 */
public interface DiscountStrategy {

    public abstract double getDiscount(double unitSell, int qty);
    public abstract void setVariable(double var);
}
