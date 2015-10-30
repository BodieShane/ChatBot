package chat.model;
import javax.swing.JOptionPane;
import chat.controller.ChatBotController;

import java.util.ArrayList;

import javax.print.DocFlavor.STRING;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part of the project. Added pop ups to the
 * project
 * 
 * @author Bodie Shane
 * @version 1.3 10/24/15
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;

	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * 
	 * @param userName
	 *            The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.userName = userName;
		this.content = "Game's";
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		buildMemesList();
		buildPoliticalTopicsList();
	}

	private void buildMemesList()
	{
		this.memesList.add("me gusta y no ");
		
		this.memesList.add("what if i told you ");
		this.memesList.add("rare pepe ");
		this.memesList.add("aliens ");
		this.memesList.add("doge ");
		this.memesList.add("bad luck brian ");
		this.memesList.add("unhelpful highschool teacher");
		this.memesList.add("spoderman");
		this.memesList.add("cute animals ");
		this.memesList.add("JOHN CENA ");
		this.memesList.add("troll ");
		

	}

	private void buildPoliticalTopicsList()
	{
		this.politicalTopicList.add("Income Tax ");
		this.politicalTopicList.add("jobs");
		this.politicalTopicList.add(" Women's Rights");
		this.politicalTopicList.add("Gay Rights");
		this.politicalTopicList.add("Defense of Marriage Act");
		this.politicalTopicList.add(" Energy");
		this.politicalTopicList.add(" Unemployment Benefits");
		this.politicalTopicList.add(" Police Abuse");
		this.politicalTopicList.add(" Tort Reform");
		this.politicalTopicList.add("Combat Drones");

	}

	/**
	 * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true.
	 * 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;

		if (currentInput != null)
		{
			if (currentInput.length() >= 1)
			{
				hasLength = true;
			}
		}

		if (currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}

		return hasLength;
	}

	/**
	 * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hascotent = false;

		if (currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hascotent = true;
		}

		return hascotent;
	}

	/**
	 * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		
		boolean haspoliticalTopic = false;
		for ( String currentpoliticalTopic:politicalTopicList )
		{
			
			if(currentInput.equalsIgnoreCase(currentpoliticalTopic))
			{
				haspoliticalTopic =true;
			}
			
			
			
			
		}
	
		
		return haspoliticalTopic;
		
		
	}

	/**
	 * Checks to see that the supplied String value is in the current memesList
	 * variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		for ( String currentMeme:memesList )
		{
			
			if(currentInput.equalsIgnoreCase(currentMeme))
			{
				hasMeme = true;
				 
			
			}
				
			
		}
	
		
		return hasMeme;
	}

	/**
	 * Returns the username of this Chatbot instance.
	 * 
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * Returns the content area for this Chatbot instance.
	 * 
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * Getter method for the memesList object.
	 * 
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}

	/**
	 * Getter method for the politicalTopicList object.
	 * 
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return null;
	}

	/**
	 * Updates the content area for this Chatbot instance.
	 * 
	 * @param content
	 *            The updated value for the content area.
	 */
	public void setContent(String content)
	{

	}
}