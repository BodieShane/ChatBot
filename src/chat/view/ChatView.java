package chat.view;

/**
 * Base version of the 2015 ChatbotView class. 
 * 
 * @author Bodie Shane
 * @version 1.3 11/5/15 Addedd popup windows Icons!
 */
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;



public class ChatView 
{
	private String windowMessage;
	private ImageIcon chatIcon;

	public ChatView()
	{
		windowMessage = "Hello form your not so friendly Chat Bot : )";
		chatIcon = new ImageIcon(getClass().getResource("images/MyRobotFace.png"));
			
	}
	
	public  void displaymessage(String message)
	{
		JOptionPane.showMessageDialog(null, message,windowMessage, JOptionPane.INFORMATION_MESSAGE,chatIcon );
		
	}
	
	public String grabText (String message)
	{
		String output = "";
		
		output = JOptionPane.showInputDialog(null, message, windowMessage, JOptionPane.PLAIN_MESSAGE,chatIcon,null,"Type here").toString();
		
		return output;

				
	}
	
}
