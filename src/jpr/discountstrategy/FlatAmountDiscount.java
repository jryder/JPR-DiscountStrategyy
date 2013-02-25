/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.discountstrategy;



/**
 * Pretty straightforward, just returns a flat discount amount
 * @author jryder
 */
public class FlatAmountDiscount implements DiscountStrategy {
    
    private double discountAmount = 100;


    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }
    
    @Override
    public double getDiscount(double unitSell, int qty){
        return discountAmount;
    }
  
    public static void main(String[] args) {
        
    }
}
