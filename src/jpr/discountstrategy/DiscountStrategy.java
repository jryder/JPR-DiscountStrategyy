/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.discountstrategy;

/**
 *
 * @author jryder
 */
public interface DiscountStrategy {

    double getDiscount(double unitSell, int qty);
     
}
