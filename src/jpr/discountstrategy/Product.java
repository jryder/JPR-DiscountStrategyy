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

    public Product(int prod, String nam, double sell, DiscountStrategy discountStrategy){
    
        productId = prod;
        name = nam;
        unitSell = sell;
        this.discountStrategy = discountStrategy;
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
        Product p = new Product(123,"nice product",50.00,new FlatAmountDiscount());
    }
}
