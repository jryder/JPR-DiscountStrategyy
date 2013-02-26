/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.discountstrategy;

/**
 *
 * @author jryder
 */
public interface DataConnectionStrategy {

    public abstract Customer findCustomer(final String custId);
    public abstract Product findProduct(final String prodId);
    
}
