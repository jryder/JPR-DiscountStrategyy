/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.discountstrategy;

/**
 *
 * @author jorda_000
 */
public class Startup {
    public static void main(String[] args) {
	Product p = new Product(123, "nice product", 50.00, new FlatAmountDiscount());
	FlatAmountDiscount d = new FlatAmountDiscount();
	p.getDiscount();
    }
    
    
}
