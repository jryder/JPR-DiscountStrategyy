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

    private int productId;
    private String name;
    private double unitSell;
    DiscountStrategy discountStrategy;
 
    public Product(int prod, String nam, double sell, DiscountStrategy discountStrategy) {

	productId = prod;
	name = nam;
	unitSell = sell;
	
    }

    public int getProductId() {
	return productId;
    }

    public void setProductId(int productId) {
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
    
    public double getDiscount(){
	System.out.println("test");
	return discountStrategy.getDiscount(2, 2); //pull this from the line item later
    
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
	
	DiscountStrategy p = new FlatPercentDiscount();
	p.setVariable(.20);
	Product p1 = new Product(123, "nice product", 50.00, p);
	//System.out.println(p1.getDiscount());
	
	System.out.println(p.getDiscount(1,2));
	
	
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
