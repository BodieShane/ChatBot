package chat.controller;
import javax.swing.JOptionPane;

import chat.model.Chatbot;
import chat.view.ChatView;

import java.util.ArrayList;
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
	//private String Text;
	//private String  Name;
	//private String  MyName;
	//private String TextName;
	private Chatbot myBot;
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	
	
	public ChatBotController()
	{
		myDisplay = new ChatView();
		String userName= myDisplay.grabText("What is your name?");
		myBot = new Chatbot(userName);
		
		
		ChatBotScanner = new Scanner(System.in);
		
	}
	
	
	public void start()

	{
		myDisplay.displaymessage("Hello " + myBot.getUserName());
		
		chat();
		
		//JOptionPane.showMessageDialog(null, "HAHAHAHA I WILL LIVE ON IN EVREY PROJRAM");
		//Text = JOptionPane.showInputDialog(null, "YOU WILL NEVER STOP ME!!!!! WHAT CAN YOU EVEN DO");
		
		
		//JOptionPane.showMessageDialog(null, "You think saying " + Text + " will scare me? You will NEVER be enough to stop me?");
		//Name = JOptionPane.showInputDialog(null," Tell me kid what is your name?");
		 
		//MyName = JOptionPane.showInputDialog(null, " well hello " + Name + " what is my name?");
		
		
		
		//JOptionPane.showMessageDialog(null,"So my name is " + MyName + ". You know what I like your name better we can just swich");
		
		//TextName = JOptionPane.showInputDialog(null, "So my name is " + Name + " and you are " + MyName + ". What do you think about that?");
		
		//Text = JOptionPane.showInputDialog(null, "Yes I see " + MyName +" You know what that's a bad name what do you want to change it to?" );
		//JOptionPane.showMessageDialog(null," ok your new name is 'But face' ");
		
		
		
	
	}
	
	private void chat() 
	
	{
		String conversation = myDisplay.grabText("What would you like to talk about today " + myBot.getUserName() + "?" );
		while(myBot.lengthChecker(conversation))
		{
			if(myBot.contentChecker(conversation))
			{
				myDisplay.displaymessage("wow, I had no idea you are interested in " + myBot.getContent());
			}
			else if(myBot.memeChecker(conversation))
			{
				myDisplay.displaymessage("what a lame meme. I am have all of that " + myBot.getUserName() + ". I wanted more from you." ) ;
				myDisplay.displaymessage("I do hava favrate meme. Do you know what it is?");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!");
				myDisplay.displaymessage("Troll!"); 
				myDisplay.displaymessage("Troll!");
			}
			
			else if(myBot.politicalTopicChecker(conversation))
			{
				myDisplay.displaymessage("What political Topic " + myBot.getUserName() + ". So you do know how you use that big lump of gray matter in your head!" );
			}
			else if(myBot.CatlistChecker(conversation))
			{
				myDisplay.displaymessage("Wow that sentence was CATtaculer!!!" );
			}
			conversation = myDisplay.grabText(conversation);
		}
	}
}
