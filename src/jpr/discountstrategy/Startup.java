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
        
        
        while (cash.getCustomerNameFromReceipt() == null){
        cash.setCustomer();
            if(cash.getCustomerNameFromReceipt() == null){
                System.out.println("That is not a valid customer number.");
            }
        }      
        
        
        cash.addItem();
        
        
        
        //after all transactions are complete, return the receipt 
        Receipt r = cash.getReceipt();
        
        String saleText = r.toString();
        
        //beam me up, Scotty
        System.out.println(saleText);

        
    }
}
