/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.discountstrategy;

import inputoutput.*;
import java.text.NumberFormat;

/**
 *
 * @author jorda_000
 */
public class Startup {

    public static void main(String[] args) {

        //initialize
        Reader rd = new GUIReader();
        DataConnectionStrategy data = new FakeDatabase();
        CashRegister cash = new CashRegister(rd, data);
        
        //let's get ready to rumble
        cash.startNewSale();
        
 
        //scared money don't make money
        while (cash.getCustomerNameFromReceipt() == null){
        cash.setCustomer();
            if(cash.getCustomerNameFromReceipt() == null){
                System.out.println("That is not a valid customer number.");
            }
        }
        
	
	int c = 0;
	int cx = 0;
        
        while (c == cx){
	    
	//check number of line items before and after.  Better validation will be created later.      
	c = cash.getLineItemCount();  //count before  
	cash.addItem(); //try adding item
	cx = cash.getLineItemCount(); //count after
	   if(c == cx){		
                System.out.println("That is not a valid customer number.");
            }
        }
        
        

        
        
        
        //after all transactions are complete, return the receipt 
        Receipt r = cash.getReceipt();
        
        String saleText = r.toString();
        
        //beam me up, Scotty
        System.out.println(saleText);

        
    }
}
