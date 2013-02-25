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
	
	Receipt r = new Receipt();
	
	FakeDatabase f = new FakeDatabase();
	
	Customer c = f.findCustomer("100");
	
	//testing
	System.out.println(c.getCustomerName());
	
	r.addItemToSale("A101", 2);
	
	System.out.println(r.getTotalBeforeDiscount());
	
    }
    
    
}
