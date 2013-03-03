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

    LineItem lineItems[];
    Customer customer;
    DataConnectionStrategy data;

    /**
     *
     * @return printed receipt
     */
    public String addString(String s1, String s2) {
	return s1 + "\n" + s2;

    }

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

    public int getLineItemCount() {

	if (lineItems == null) {
	    return 0;
	}
	return lineItems.length;
    }

    public Customer getCustomer() {
	return customer;
    }

    public void setCustomer(Customer customer) {
	this.customer = customer;
    }

    public String getCustomerName() {
	if (customer == null) {
	    return null;
	}
	return customer.getCustomerName();
    }

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
    // Here's how to loop through all the line items and get a grand total

    public double getTotalBeforeDiscount() {
	double grandTotal = 0.0;
	for (LineItem item : lineItems) {
	    grandTotal += item.getOrigPriceSubtotal();
	}
	return grandTotal;
    }

    public double getTotalDiscount() {
	double discount = 0.0;
	for (LineItem item : lineItems) {
	    discount += item.getDiscount();
	}
	return discount;
    }

    public double getFinalTotalSale() {
	return this.getTotalBeforeDiscount() - this.getTotalDiscount();
    }
}
