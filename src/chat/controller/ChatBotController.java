package chat.controller;
import javax.swing.JOptionPane;

import chat.model.Chatbot;
import chat.view.*;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Application controller for the Chatbot project.
 * @author bsha6756
 *@version 1.11 10/21/15 fixed error
 */
public class ChatBotController 
{
	private ChatBotFrame baceFrame;
	private ChatView myDisplay;
	private Scanner ChatBotScanner;

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
		baceFrame = new ChatBotFrame (this); 
	}
	
	
	public void start()

	{
		myDisplay.displaymessage("Hello " + myBot.getUserName());
		
		//chat();
	
	}
	
	private void chat() 
	
	{
		String conversation = myDisplay.grabText("What would you like to talk about today " + myBot.getUserName() + "?" );
		while(myBot.lengthChecker(conversation))
		{
			
			
			conversation = myBot.prossesConersation(conversation);
			conversation = myDisplay.grabText(conversation);
			

		}
	}
	private void shutDown()
	{
		myDisplay.grabText("Goodbye," + myBot.getUserName() + " it has been my pleasure to talk with you");
		System.exit(0);
	}
}
