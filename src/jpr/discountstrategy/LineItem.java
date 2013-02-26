/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.discountstrategy;

/**
 *
 * @author jorda_000
 */
public class LineItem {
    private int qty;
    private Product product; 

    public LineItem(Product product, int qty) {
	this.qty = qty;
	this.product = product;
    }
    
     public double getOrigPriceSubtotal(){
	 return product.getUnitSell() * qty;
     }
    
    public double getDiscount(){
        return product.getDiscount(qty);
    } 
     
     
}
