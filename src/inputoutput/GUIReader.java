/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inputoutput;

import javax.swing.JOptionPane;

/**
 *
 * @author jryder
 */
public class GUIReader implements Reader {

    private String message;
    
    @Override
    public void read() {
	
	this.message = JOptionPane.showInputDialog(null, message, "Enter value to Copy", 1);
    }

    @Override
    public String getMessage() {
	return this.message;
    }
    
}
