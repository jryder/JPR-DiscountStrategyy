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
public class CashRegister {

    Receipt receipt;

    public CashRegister() {
	Receipt r = new Receipt();
	FakeDatabase f = new FakeDatabase();
        Reader read = new GUIReader();

        //get customer from cashier

        //read.setPrompt("Enter Customer Number");        
        //read.read();
        //Customer c = f.findCustomer(read.getMessage());
	Customer c = f.findCustomer("100");
         
        //scan product
        //read.setPrompt("Enter Product ID");        
        //read.read();
	//r.addItemToSale(read.getMessage(), 1);
        r.addItemToSale("A1", 1);
        
	System.out.println(c.getCustomerName());       
	System.out.println("The total bill before discounts is " + r.getTotalBeforeDiscount());
        
        double dis = r.getTotalDiscount();
        
        System.out.println("The amount saved is " + dis);
        
    }
    
    
    
}
