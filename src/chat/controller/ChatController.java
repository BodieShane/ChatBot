//this is where we import everything

package chat.controller;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;

import chat.model.CTECTwitter;
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
	
	//this is where we declare everything
	
	private CTECTwitter chatTwitter;
	private ChatFrame baseFrame;
	private ChatView myDisplay;
	private Scanner ChatBotScanner;
	private Chatbot myBot;
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	private ChatPanel changeRandomColor;
	
	//this is where we can control the chatBot
	public ChatController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.grabText("What is your name?");
		myBot = new Chatbot(userName);
		baseFrame = new ChatFrame (this); 
		chatTwitter = new CTECTwitter();
	}
	
	//Using this we can start the code.
	public void start()

	{
		
		//myDisplay.displaymessage("Hello " + myBot.getUserName());
		
		//chat();
	
	}
	


		// It was the old pop up method.
	private void chat() 
	
	{
		String conversation = myDisplay.grabText("What would you like to talk about today " + myBot.getUserName() + "?" );
		while(myBot.lengthChecker(conversation))
		{
			
			
			conversation = myBot.prossesConersation(conversation);
			conversation = myDisplay.grabText(conversation);
			

		}
	}
	
	public void sendTweet(String tweatText)
	{

		chatTwitter.sendTweet(tweatText);
		
	}
	//This if for the conversation
	public String userToChabot(String conversation)
	{
		String response ="";
		if(myBot.quitChecker(conversation))
		{
			quitChecker();
		}
		response = myBot.prossesConersation(conversation);
		
		
		return response;
	}
	
	//Allows the program to quit
	private void quitChecker()
	{
		myDisplay.grabText("Goodbye," + myBot.getUserName() + " it has been my pleasure to talk with you");
		System.exit(0);
	}

	//Returns myBot
	public Object getChatbot()
	{
		
		return myBot;
	}

	//returns myDisplay
	public Object getChatView()
	{
		
		return myDisplay;
	}

	//it returns baceFrame.
	public ChatFrame getBaseFrame()
	{
		
		return baseFrame;
	}
}
