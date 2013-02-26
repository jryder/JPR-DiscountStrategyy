

package jpr.discountstrategy;

/**
 *
 * @author jorda_000
 */
public class FakeDatabase implements DataConnectionStrategy {

    private Customer[] customers = {
        new Customer("100", "Aaron Rodgers"),
        new Customer("200", "Randall Cobb"),
        new Customer("300", "Mason Crosby")
    };
    
    // Notice we assign a default discount strategy component object to each product
    Product[] products = {
        new Product("A1", "Tower PC Case", 19.95, new FlatPercentDiscount(0.15)),
        new Product("A2", "USB Card", 35.50, new QtyIncreaseDiscount(.10, 0.2)),
        new Product("A3", "Media PC Kit", 9.50, new FlatAmountDiscount()),
        new Product("A4", "Corsair Power Supply", 9.50, new FlatAmountDiscount()),
        new Product("A5", "ATI 5850 Graphics", 9.50, new FlatAmountDiscount()),
        new Product("A6", "Seagate 2TB Harddrive", 9.50, new FlatAmountDiscount())
    };


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
