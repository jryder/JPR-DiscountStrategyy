/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.discountstrategy;

/**
 *
 * @author jorda_000
 */
public class Receipt {

    LineItem lineItems[];
    Customer customer;

    public Customer getCustomer() {
	return customer;
    }

    public void setCustomer(Customer customer) {
	this.customer = customer;
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
	LineItem[] tempItems = new LineItem[lineItems.length + 1];
	System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
	tempItems[lineItems.length] = item;
	lineItems = tempItems;
    }

    // Here's how to loop through all the line items and get a grand total
    public double getTotalBeforeDiscount() {
	double grandTotal = 0.0;
	for (LineItem item : lineItems) {
	    grandTotal += item.getOrigPriceSubtotal();
	}
	return grandTotal;
    }
}
