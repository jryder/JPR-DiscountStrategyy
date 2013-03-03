


package jpr.discountstrategy;
import inputoutput.*;

/**
 *
 * @author Jordan Ryder
 */
public class CashRegister {

    Receipt receipt;
    Reader read;
    DataConnectionStrategy data; 
    
    public CashRegister(Reader read, DataConnectionStrategy data) {
        this.read = read; 
        this.data = data;
    }
    

    public void startNewSale(){
        receipt = new Receipt();
    }
    
    /** Returns receipt with all applicable information
     * This is useful so the cash register doesn't have to duplicate all receipt methods
     */
    public String printReceipt(){
	    return  receipt.toString();
    }
    
    public void setCustomer(){
	
	
	
        receipt.setCustomer(data.findCustomer(read.readAndReturn("Enter Customer Number")));  
    }
    
    public void addItem(){
        String prod = read.readAndReturn("Enter Product ID");
        int q = Integer.valueOf(read.readAndReturn("Enter the quantity"));
        receipt.addItemToSale(prod, q);
    }

    public int getLineItemCount(){
	return receipt.getLineItemCount();
    }
    
    
    public String getCustomerNameFromReceipt(){
        return receipt.getCustomerName();
    
    }
    
    
 }
    
    
    

