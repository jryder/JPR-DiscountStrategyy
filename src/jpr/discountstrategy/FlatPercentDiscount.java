/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.discountstrategy;

/**
 *
 * @author jryder
 */
public class FlatPercentDiscount implements DiscountStrategy {

    private double rate;

    public double getRate() {
	return rate;
    }

    public void setRate(double rate) {
	this.rate = rate;
    }

    @Override
    public double getDiscount(double unitSell, int qty) {
        double amt = qty * unitSell * rate;
        return amt;
    }

    public static void main(String[] args) {
    }
}
