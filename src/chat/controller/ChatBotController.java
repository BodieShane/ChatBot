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
	private String  Name;
	private String  MyName;
	private String TextName;
	
	
	
	public ChatBotController()
	{
		
		
		
		ChatBotScanner = new Scanner(System.in);
		
	}
	
	
	public void start()
	{
		System.out.print("HAHAHAHA I WILL LIVE ON IN EVREY PROJRAM");
		System.out.print("YOU WILL NEVER STOP ME!!!!! WHAT CAN YOU EVEN DO");
		String Text = ChatBotScanner .next();
		
		System.out.print("You think saying " + Text + " will NEVER be enough to stop me?");
		System.out.print(" Tell me kid what is your name?");
		String Name = ChatBotScanner .next();
		
		System.out.print(" well hello " + Name + " what is my name?");
		String MyName = ChatBotScanner .next();
		
		System.out.print("So my name is " + MyName + ". You know what I like your name better we can just swich");
		System.out.print("So my name is " + Name + " and you are " + MyName + ". What do you think about that?");
		String TextName = ChatBotScanner .next();
		
	}
}
