
package jpr.discountstrategy;

/**
 *
 * Interface that dictatates what methods are required for a data connection
 * 
 * @author Jordan Ryder
 */

public interface DataConnectionStrategy {
    public abstract Customer findCustomer(final String custId);
    public abstract Product findProduct(final String prodId);
}
