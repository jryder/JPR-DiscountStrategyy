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
	Writer wr = new GUIWriter();
	DataConnectionStrategy data = new FakeDatabase();
	CashRegister cash = new CashRegister(rd, data);

	//let's get ready to rumble
	cash.startNewSale();


	//scared money don't make money
	while (cash.getCustomerNameFromReceipt() == null) {
	    cash.setCustomer();
	    if (cash.getCustomerNameFromReceipt() == null) {
		wr.write("That is not a valid customer number.");
	    }
	}


	int c = 0;
	int cx = 0;


	boolean done = false;


	//continue to add products until the users specifies to end
	while (done == false) {
	    do {
		//check number of line items before and after.  Better validation will be created later.      
		c = cash.getLineItemCount();  //count before  
		cash.addItem(); //try adding item
		cx = cash.getLineItemCount(); //count after
		if (c == cx) {
		    wr.write("That is not a valid Product ID.");
		}
	    } while (c == cx);

	    String doneCheck;
	    doneCheck = rd.readAndReturn("Do you want to add another product? (Y/N)");
	    if (doneCheck.equals("Y")) {
		done = false;
	    } else {
		done = true;
	    }
	}





	//after all transactions are complete, return the receipt 
	Receipt r = cash.getReceipt();

	String saleText = r.toString();

	//beam me up, Scotty
	System.out.println(saleText);


    }
}
