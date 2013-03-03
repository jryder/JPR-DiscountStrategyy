
package jpr.discountstrategy;

/**
 *
 * This class is responsible for holding information on the specific products on 
 * the receipt.  
 * 
 * @author jryder
 */
public class Product {

    private String productId;
    private String name;
    private double unitSell;
    private DiscountStrategy discountStrategy;
 
    
    /**
     * Constructor, this can not be instantiated without setting what the product is
     * 
     * @param prod
     * @param nam
     * @param sell
     * @param disc 
     */
    public Product(String prod, String nam, double sell, DiscountStrategy disc) {

	productId = prod;
	name = nam;
	unitSell = sell;
	discountStrategy = disc;
	
    }

    /**
     * Getter for the product ID
     * @return ProductId
     */
    public String getProductId() {
	return productId;
    }

    /**
     * Setter for the product ID
     * 
     * @param productId 
     */
    public void setProductId(String productId) {
	this.productId = productId;
    }

    

    /**
     * Returns the name of the product as a string
     * @return name
     */
    public String getName() {
	return name;
    }
    
    
    /**
     * This is called from the line higher level class.  This calculates the total
     * discount by accounting for the quantity.
     * 
     * @param qty
     * @return Total discount for the line
     */
    public double getDiscount(int qty){
	return  discountStrategy.getDiscount(unitSell, qty); //pull this from the line item later
    }

    /**
     * Set name of product
     * 
     * @param name 
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Returns the unit sell for the product
     * 
     * @return unit sell for a quantity of 1
     */
    public double getUnitSell() {
	return unitSell;
    }

    
    /**
     * Sets the product unit sell
     * 
     * @param unitSell 
     */
    public void setUnitSell(double unitSell) {
	this.unitSell = unitSell;
    }

    
    /**
     * Testing only
     * @param args 
     */
    public static void main(String[] args) {
	

	/*
	DiscountStrategy f = new FlatAmountDiscount();
	f.setVariable(10);
	Product p2 = new Product(123, "nice product", 50.00, f);
	FlatAmountDiscount d2 = new FlatAmountDiscount();
	System.out.println(p2.getDiscount());	
	
	DiscountStrategy q = new QtyIncreaseDiscount();
	q.setVariable(.9);
	Product p3 = new Product(123, "nice product", 50.00, q);
	FlatAmountDiscount d3 = new FlatAmountDiscount();
	System.out.println(p3.getDiscount());		
	*/
    }
}
