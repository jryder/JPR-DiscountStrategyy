/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.discountstrategy;

/**
 *
 * @author jorda_000
 */
class Customer {
    String customerId;
    String customerName;
    
    
    Customer(String custId, String custName) {
	customerId = custId;
	customerName = custName;
    }

    public String getCustomerId(){
	return this.customerId;
    }
    
}
