/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.discountstrategy;

/**
 *
 * @author jryder
 */
public class FlatPercentDiscount {

    private double rate;

    public double getDiscount(int qty, double unitSell) {
        double amt = qty * unitSell * rate;
        return amt;
    }

    public static void main(String[] args) {
    }
}
