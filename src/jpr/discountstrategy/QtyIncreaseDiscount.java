/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.discountstrategy;

/**
 *
 * @author jryder
 */
public class QtyIncreaseDiscount implements DiscountStrategy {
    private double startingDiscountRate = 0.10;
    private double increment = 0.01;

    @Override
    public double getDiscount(double unitSell, int qty){
        
        double highDiscount = startingDiscountRate + ((qty - 1) * increment);
        double avgDiscount = (startingDiscountRate + highDiscount) / 2;        
        double amt = qty * unitSell * (1 - avgDiscount);
        return amt;
    }
    
    
    
    public double getStartingDiscountRate() {
        return startingDiscountRate;
    }

    public void setStartingDiscountRate(double startingDiscountRate) {
        this.startingDiscountRate = startingDiscountRate;
    }

    public double getIncrement() {
        return increment;
    }

    public void setIncrement(double increment) {
        this.increment = increment;
    }
    
    public static void main(String[] args) {
        QtyIncreaseDiscount q = new QtyIncreaseDiscount();
        System.out.println(q.getDiscount(5, 10));
        
        
    }
    
    
}
