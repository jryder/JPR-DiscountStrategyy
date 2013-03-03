package jpr.discountstrategy;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jorda_000
 */
public class Receipt {

    private LineItem lineItems[];
    private Customer customer;
    private DataConnectionStrategy data;

    /**
     *
     * @return printed receipt
     */
    public String addString(String s1, String s2) {
	return s1 + "\n" + s2;

    }

    /**
     * This method overrides the toString method and returns a printout of what the
     * receipt will look like when printed from the cash register.  This combines all
     * of the attributes of the transaction
     * 
     * @return Receipt text of the receipt for printing
     */
    @Override
    public String toString() {
	String s = "";

	NumberFormat fmt = NumberFormat.getCurrencyInstance();

	s = addString(s, "\n\n\n*********** Kohls ***********");
	s = addString(s, "******* Proof of Sale *******");

	//add time stamp
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	s = addString(s, dateFormat.format(date)) + "\n";

	s = addString(s, getCustomerName() + ", Thank You for Shopping at Kohls.\n");
	s = addString(s, "----Item Summary----");


	//pring all line items
	for (LineItem l : lineItems) {
	    String s3 = l.getProductDescription() + "..... " + String.valueOf(l.getQty()) + " " + "each @ " + fmt.format(l.getUnitSell()) + "....." + fmt.format(l.getOrigPriceSubtotal());
	    s = addString(s, s3);
	}


	s += "\n";



	String prt = String.format("The total bill before discounts is " + fmt.format(getTotalBeforeDiscount()));
	s = addString(s, prt);

	prt = String.format("You saved " + fmt.format(getTotalDiscount()));
	s = addString(s, prt);

	prt = String.format("The total sale is " + fmt.format(getFinalTotalSale()) + "\n");
	s = addString(s, prt);
	s = addString(s, "Thank you for Shopping at Kohls! \nVisit us at everythingisonsaleallthetime.com");

	return s;
    }

    /**
     * Gets the number of line items on the receipt
     * @return line item count
     */
    public int getLineItemCount() {

	if (lineItems == null) {
	    return 0;
	}
	return lineItems.length;
    }

    

    /**
     * Set the customer on the receipt
     * @param customer 
     */

    public void setCustomer(Customer customer) {
	this.customer = customer;
    }

    
    /**
     * Return the name of the customer from the customer object
     * @return Customer name
     */
    public String getCustomerName() {
	if (customer == null) {
	    return null;
	}
	return customer.getCustomerName();
    }

    
    /**
     * Add item to the line item array
     * 
     * @param prodId
     * @param qty 
     */
    public void addItemToSale(String prodId, int qty) {
	FakeDatabase db = new FakeDatabase();
	Product product = db.findProduct(prodId);
	if (product != null) {
	    addLineItem(product, qty);
	}
    }

    //only used internally
    private void addLineItem(Product product, int qty) {
	LineItem item = new LineItem(product, qty);
	addToArray(item);
    }

    //only used internally
    private void addToArray(LineItem item) {

	//if it is currently null, assign the first value
	if (lineItems == null) {
	    lineItems = new LineItem[1];
	    lineItems[0] = item;
	} else {

	    LineItem[] tempItems = new LineItem[lineItems.length + 1];
	    System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
	    tempItems[lineItems.length] = item;
	    lineItems = tempItems;
	}
    }

    
    /**
     * Get the total sale without discounts
     * @return Gross sales
     */
    public double getTotalBeforeDiscount() {
	double grandTotal = 0.0;
	for (LineItem item : lineItems) {
	    grandTotal += item.getOrigPriceSubtotal();
	}
	return grandTotal;
    }

    
    /**
     * Get the discount amount for all of the line items
     * @return Total Discount
     */
    public double getTotalDiscount() {
	double discount = 0.0;
	for (LineItem item : lineItems) {
	    discount += item.getDiscount();
	}
	return discount;
    }

    /**
     * Get the net sales, which is total sales - discounts
     * 
     * @return Net Sales
     */
    public double getFinalTotalSale() {
	return this.getTotalBeforeDiscount() - this.getTotalDiscount();
    }
}
