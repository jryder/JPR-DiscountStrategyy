

package jpr.discountstrategy;

/**
 *
 * This line item class is responsible for knowing the product and quantity for 
 * each one item on the receipt.  To handle multiple line items, the high level class
 * will store an array of this class
 *  
 * 
 * @author Jordan Ryder
 */
public class LineItem {
    private int qty;
    private Product product; 
   
    
    /**
     * Getter for the line quantity
     * 
     * @return qty
     */
    public int getQty() {
	return qty;
    }
    
    

    /**
     * constructor that sets the
     * 
     * 
     * @param product
     * @param qty 
     */
    public LineItem(Product product, int qty) {
	this.qty = qty;
	this.product = product;
    }
    
    
    /**
     * This returns the line total without discounts.  
     * 
     * @return Line total without discounts
     */
     public double getOrigPriceSubtotal(){
	 return product.getUnitSell() * qty;
     }
    
     /**
      * Calculate the discount amount
      * @return Line discount amount
      */
    public double getDiscount(){
        return product.getDiscount(qty);
    } 
    
    
    /**
     * Get the product description
     * 
     * @return description of the product
     */
    public String getProductDescription(){
	return product.getName();
    }
    
    
    /**
     * Pulls the unit sell from the lower level product object
     * 
     * @return product unitSell
     */
    public double getUnitSell(){
	return product.getUnitSell();
    }
     
     
}
