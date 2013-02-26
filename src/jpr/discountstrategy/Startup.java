/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.discountstrategy;

import inputoutput.*;

/**
 *
 * @author jorda_000
 */
public class Startup {
    public static void main(String[] args) {
	
        
        Reader rd = new GUIReader();
        DataConnectionStrategy data = new FakeDatabase();
        CashRegister cash = new CashRegister(rd,data);
      
        //scan product     
        cash.addItem(rd.readAndReturn("Enter Product ID"), 1);
        cash.setCustomer(data.findCustomer(rd.readAndReturn("Enter a Customer Number")));
        
        
	System.out.println(c.getCustomerName());       
	System.out.println("The total bill before discounts is " + r.getTotalBeforeDiscount());
        
        double dis = r.getTotalDiscount();
        
        System.out.println("The amount saved is " + dis);  
        
        
        
        
    }
    
    
}
