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


    
    
public void addItemToSale(String prodId, int qty) {
	FakeDatabase db =  new FakeDatabase();
        Product product = db.findProduct(prodId);
        
		// if found, add the lineItem to the receipt
		// but it's the receipt's job to do this!
        if(product != null) {
           addLineItem(product, qty);
	}
    }

    // Here's how Receipt class adds a purchased product as a LineItem
    // Note that the Receipt must have a LineItem[]  lineItems array property
    public void addLineItem(Product product, int qty) {
        LineItem item = new LineItem(product, qty);
        addToArray(item);
    }

	// Since arrays are fixed in size, to add a new element you must resize
	// the array, but wait, you can't do that in Java! Well, you can fake it. Here's how:
	// Create a new temporary array that's one larger than the original. Then,
	// copy all the data from the original into the temporary array.
	// Finally, add the new item to the new element in the temporary array. Then,
	// set the original = temporary. That's it!
    private void addToArray(LineItem item) {
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }

	// Here's how to loop through all the line items and get a grand total
    public double getTotalBeforeDiscount() {
        double grandTotal = 0.0;
        for(LineItem item : lineItems) {
            grandTotal += item.getOrigPriceSubtotal();
        }
        return grandTotal;
}

}
