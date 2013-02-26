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
    Reader read;
    DataConnectionStrategy data; //I still like the cash register to be connected to the data source
    
    public CashRegister(Reader read, DataConnectionStrategy data) {
        this.read = read; 
        this.data = data;
    }
    
    
    
    public void startNewSales(){
        Receipt r = new Receipt();
    }
    
    public void printReceipt(){
    
    
    }
    
    public void setCustomer(String customer){
        read.setPrompt("Enter Customer Number");        
        read.read();
        receipt.setCustomer(data.findCustomer(read.getMessage()));  
    }
    
    public void addItem(String prodId, int qty){
        receipt.addItemToSale(prodId, qty);
    }
    
    





         

        
    }
    
    
    
}
