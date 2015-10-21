package chat.controller;
import javax.swing.JOptionPane;
import chat.view.ChatView;
import java.util.Scanner;
/**
 * Application controller for the Chatbot project.
 * @author bsha6756
 *@version 1.11 10/21/15 fixed error
 */
public class ChatBotController 
{
	private ChatView myDisplay;
	private Scanner ChatBotScanner;
	private String Text;
	
	public ChatBotController()
	{
		
	}
	
	
	public void start()
	{
		JOptionPane.showMessageDialog(null,"HAHAHAHA I WILL LIVE ON IN EVREY PROJRAM");
		JOptionPane.showMessageDialog(null,"YOU WILL NEVER STOP ME!!!!!");
		String Text = ChatBotScanner .next();
		JOptionPane.showMessageDialog(null,"You think saying " + Text + " will stop me?");
		
		
		
	}
}
