/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.discountstrategy;

/**
 *
 * @author jryder
 */
public class Product {

    private String productId;
    private String name;
    private double unitSell;
    private DiscountStrategy discountStrategy;
 
    public Product(String prod, String nam, double sell, DiscountStrategy disc) {

	productId = prod;
	name = nam;
	unitSell = sell;
	discountStrategy = disc;
	
    }

    public String getProductId() {
	return productId;
    }

    public void setProductId(String productId) {
	this.productId = productId;
    }

    public DiscountStrategy getDiscountStrategy() {
	return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
	this.discountStrategy = discountStrategy;
    }

    public String getName() {
	return name;
    }
    
    public double getDiscount(int qty){
	return  discountStrategy.getDiscount(unitSell, qty); //pull this from the line item later
    }

    public void setName(String name) {
	this.name = name;
    }

    public double getUnitSell() {
	return unitSell;
    }

    public void setUnitSell(double unitSell) {
	this.unitSell = unitSell;
    }

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
