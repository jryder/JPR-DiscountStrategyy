

package jpr.discountstrategy;

/**
 *
 * This is a mock database that is used for testing the POS system in a development
 * environment without an actual database connection
 * 
 * @author Jordan Ryder
 */
public class FakeDatabase implements DataConnectionStrategy {

    private Customer[] customers = {
        new Customer("100", "Aaron Rodgers"),
        new Customer("200", "Randall Cobb"),
        new Customer("300", "Mason Crosby")
    };
    
    // Notice we assign a default discount strategy component object to each product
    Product[] products = {
        new Product("A1", "Tower PC Case", 20.00, new FlatPercentDiscount(0.15)),
        new Product("A2", "USB Card", 36.00, new QtyIncreaseDiscount(.10, 0.2)),
        new Product("A3", "Media PC Kit", 10.00, new FlatAmountDiscount()),
        new Product("A4", "Corsair Power Supply", 10.00, new FlatAmountDiscount()),
        new Product("A5", "ATI 5850 Graphics", 10.00, new FlatAmountDiscount()),
        new Product("A6", "Seagate 2TB Harddrive", 10.00, new FlatAmountDiscount())
    };


    /**
     * 
     * This searches for a customer and returns the customer if a customer ID exists
     * 
     * @param custId
     * @return Customer object of Customer
     */
    
    @Override
    public final Customer findCustomer(final String custId) {
        // validation is needed
        Customer customer = null;
        for (Customer c : customers) {
            if (custId.equals(c.getCustomerId())) {
                customer = c;
                break;
            }
        }
        return customer;
    }


    
    /**
     * 
     * This finds a product and returns the product if the ID matches
     * 
     * @param prodId
     * @return Product - instance of Product class
     */
    @Override
    public final Product findProduct(final String prodId) {
        // validation is needed
        Product product = null;
        for (Product p : products) {
            if (prodId.equals(p.getProductId())) {
                product = p;
                break;
            }
        }

        return product;
    }
}
