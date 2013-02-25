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
	
	
DiscountStrategy p = new FlatPercentDiscount();
	p.setVariable(.20);
	Product p1 = new Product(123, "nice product", 50.00, p);
	System.out.println(p1.getDiscount());
	
	System.out.println(p.getDiscount(1,2));
	
	
	
	DiscountStrategy f = new FlatAmountDiscount();
	f.setVariable(10);
	Product p2 = new Product(123, "nice product", 50.00, f);
	FlatAmountDiscount d2 = new FlatAmountDiscount();
	System.out.println(p2.getDiscount());	
	
	DiscountStrategy q = new QtyIncreaseDiscount();
	q.setVariable(.9);
	Product p3 = new Product(123, "nice product", 50.00, q);
	FlatAmountDiscount d3 = new FlatAmountDiscount();
	System.out.println(p3.getDiscount());		
    }
    
    
}
