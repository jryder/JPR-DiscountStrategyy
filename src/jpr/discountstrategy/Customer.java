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

    public String getCustomerName() {
	return customerName;
    }

    public void setCustomerName(String customerName) {
	this.customerName = customerName;
    }
    
    
    public Customer(){};
    
    public Customer(String custId, String custName) {
	customerId = custId;
	customerName = custName;
    }

    public String getCustomerId(){
	return this.customerId;
    }
    
}
