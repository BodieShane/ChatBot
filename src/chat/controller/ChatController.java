package chat.controller;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;

import chat.model.Chatbot;
import chat.view.*;
import chat.controller.*;
/**
 * Application controller for the Chatbot project.
 * @author bsha6756
 *@version 1.11 10/21/15 fixed error
 */
public class ChatController 
{
	private ChatFrame baseFrame;
	private ChatView myDisplay;
	private Scanner ChatBotScanner;

	private Chatbot myBot;
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	private ChatPanel changeRandomColor;
	
	
	public ChatController()
	{
		myDisplay = new ChatView();
		String userName= myDisplay.grabText("What is your name?");
		myBot = new Chatbot(userName);
		baseFrame = new ChatFrame (this); 
	}
	
	
	public void start()

	{
		
		//myDisplay.displaymessage("Hello " + myBot.getUserName());
		
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
	public String userToChabot(String conersation)
	{
		String response ="";
		if(myBot.quitChecker(conersation))
		{
			quitChecker();
		}
		response = myBot.prossesConersation(conersation);
		
		
		return response;
	}
	
	
	private void quitChecker()
	{
		myDisplay.grabText("Goodbye," + myBot.getUserName() + " it has been my pleasure to talk with you");
		System.exit(0);
	}


	public Object getChatbot()
	{
		
		return myBot;
	}


	public Object getChatView()
	{
		
		return myDisplay;
	}


	public ChatFrame getBaseFrame()
	{
		
		return baseFrame;
	}
}
