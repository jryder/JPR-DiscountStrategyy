package jpr.discountstrategy;

import inputoutput.*;

/**
 *
 * The cash register class is the high level class for the POS system
 *
 * The responsibilites of the cashRegister include beginning a new sale, and
 * interacting with the user with input/output to generate the transaction.
 *
 *
 * @author Jordan Ryder
 */
public class CashRegister {

    private Receipt receipt;
    private Reader read;
    private DataConnectionStrategy data;
    private Writer write;

    /**
     *
     *
     *
     * @param read reader the determines input methods
     * @param data data connection class to determine what data source to
     * connect to
     */
    public CashRegister(Reader read, DataConnectionStrategy data, Writer write) {
	this.read = read;
	this.data = data;
	this.write = write;
    
    }

    /**
     *
     * Nothing much needs to be done here, it just creates a blank receipt that
     * can begin to be populated with items and attributes.
     *
     */
    public void startNewSale() {
	receipt = new Receipt();
    }

    /**
     *
     * Prints receipt by returning a string representing the transaction
     *
     * @return Text of the receipt currently in the cash register
     */
    public String printReceipt() {
	return receipt.toString();
    }

    /**
     * Set customer. Does not require any variables to be passed in. The method
     * will read from the user input.
     */
    public void setCustomer() {
	receipt.setCustomer(data.findCustomer(read.readAndReturn("Enter Customer Number")));
    }

    /**
     * Add a product to the line item class. Does not require any arguments, the
     * method will read the user input.
     */
    public void addItem() {
	String prod = read.readAndReturn("Enter Product ID");
	
	
	
	
	String q = read.readAndReturn("Enter the Quantity");
	if(isInteger(q)){
	    receipt.addItemToSale(prod, Integer.valueOf(q));
	}
	else {
	    write.write("This is not a valid quantity.  Please enter an integer");
	}
	
    }

    public boolean isInteger(String input) {
	try {
	    Integer.parseInt(input);
	    return true;
	} catch (Exception e) {
	    return false;
	}
    }

    /**
     * This method returns the number of items that are in the line items class.
     * This is pulled from the receipt class
     *
     * @return count of line items in the line item class
     */
    public int getLineItemCount() {
	return receipt.getLineItemCount();
    }

    /**
     *Get the name of the customer
     *
     * @return customerName
     */
    public String getCustomerNameFromReceipt() {
	return receipt.getCustomerName();

    }
}
