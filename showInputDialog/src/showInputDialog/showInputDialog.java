package showInputDialog;

import javax.swing.JOptionPane;


public class showInputDialog {
  public static void main(String[] args) {
    String input = JOptionPane.showInputDialog(null,
    		"Enter an input", 
    		"Input Dialog Demo", 
    		JOptionPane.QUESTION_MESSAGE);
    JOptionPane.showMessageDialog(null, input, "Display Message", JOptionPane.INFORMATION_MESSAGE);
  }
}
