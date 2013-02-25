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
	return discountStrategy.getDiscount(unitSell, 2);
    
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
	Product p1 = new Product(123, "nice product", 50.00, new FlatPercentDiscount());

	p1.getDiscount();
	
	Product p2 = new Product(123, "nice product", 50.00, new FlatAmountDiscount());
	FlatAmountDiscount d2 = new FlatAmountDiscount();
	p2.getDiscount();	
	
	DiscountStrategy q = new QtyIncreaseDiscount();
	q.set;
	Product p3 = new Product(123, "nice product", 50.00, new QtyIncreaseDiscount());
	FlatAmountDiscount d3 = new FlatAmountDiscount();
	p3.getDiscount();		
	
	
	
    }
}
