package chat.view;

import javax.swing.JOptionPane;

public class ChatView 
{

	
	public  void displaymessage(String message)
	{
		JOptionPane.showMessageDialog(null, message);
		
	}
	
	public String grabText (String message)
	{
		String output = "";
		output = JOptionPane.showInputDialog(null, message);
		return output;
				
	}
}
