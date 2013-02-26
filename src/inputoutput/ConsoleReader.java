
package inputoutput;


import java.util.Scanner;
/**
 *
 * @author jryder
 */
public class ConsoleReader implements Reader {
    
    private String message;
    
    @Override
    public void read() {
	System.out.println("Please enter a value to copy");
	Scanner scan = new Scanner(System.in);
	this.message = scan.nextLine();
    }

    @Override
    public String getMessage() {
	return this.message;
    }
    
    
    
    
}
