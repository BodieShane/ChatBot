package chat.model;
import javax.swing.JOptionPane;
import chat.controller.ChatController;

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
	private ArrayList<String> keyboardMash;
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private ArrayList<String> catList;
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
		this.keyboardMash = new ArrayList<String>();
		this.userName = userName;
		this.content = "Game's";
		this.catList = new ArrayList<String>();
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		buildMemesList();
		buildPoliticalTopicsList();
		buildCatList();
		buildkeyboardMash();
	}
	
	private void buildkeyboardMash()
	{
		
		this.keyboardMash.add("sdf");
		this.keyboardMash.add("dfg");
		this.keyboardMash.add(",./");
		this.keyboardMash.add("cvb");
		
	}
	
	private void buildMemesList()
	{
		this.memesList.add("me gusta y no ");
		
		this.memesList.add("what if i told you");
		this.memesList.add("rare pepe");
		this.memesList.add("aliens");
		this.memesList.add("doge");
		this.memesList.add("bad luck brian ");
		this.memesList.add("unhelpful highschool teacher");
		this.memesList.add("spoderman");
		this.memesList.add("cute animals");
		this.memesList.add("JOHN CENA");
		this.memesList.add("troll");
		

	}

	private void buildPoliticalTopicsList()
	{
		this.politicalTopicList.add("Income Tax");
		this.politicalTopicList.add("jobs");
		this.politicalTopicList.add(" Women's Rights");
		this.politicalTopicList.add("Gay Rights");
		this.politicalTopicList.add("Republican");
		this.politicalTopicList.add("Democrat");
		this.politicalTopicList.add("Unemployment Benefits");
		this.politicalTopicList.add("Police Abuse");
		this.politicalTopicList.add("Tort Reform");
		this.politicalTopicList.add("Combat Drones");
		this.politicalTopicList.add("Hillary Clinton");
		this.politicalTopicList.add("Martin O'Malley");
		this.politicalTopicList.add("Bernie Sanders ");
		this.politicalTopicList.add("Jeb Bush");
		this.politicalTopicList.add("Ben Carson");
		this.politicalTopicList.add("Chris Christie");
		this.politicalTopicList.add("11/4/16");
		this.politicalTopicList.add("Carly Fiorina");
		this.politicalTopicList.add("Jim Gilmore");
		this.politicalTopicList.add("Lindsey Graham");
		this.politicalTopicList.add("Mike Huckabee");
		this.politicalTopicList.add("Bobby Jindal");
		this.politicalTopicList.add("john Kasich");
		this.politicalTopicList.add("George Pataki");
		this.politicalTopicList.add("Rand Paul");
		this.politicalTopicList.add("Marco Rubio");
		this.politicalTopicList.add("Rick Santorum");
		this.politicalTopicList.add("Donald Trump");
		

	}
	
	
	private void buildCatList()
	{
		this.catList.add("Cat");
		this.catList.add("purr");
		this.catList.add("catastrophe");
		this.catList.add("Cat's");
		
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
		boolean hascontent = false;

		if (currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hascontent = true;
		}

		return hascontent;
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
	public boolean quitChecker(String currentInput)
	{
		boolean hasQuit = false;
		
		if (currentInput.equals("quit"))
		{
					hasQuit = true;
		}
				return hasQuit;
	}
	
	
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean haskeyboardMash = false;
		for (String currentkeyboardMash: keyboardMash)
		{
			if(currentInput.equalsIgnoreCase(currentkeyboardMash))
			{
				haskeyboardMash = true;
			}
		}
		return haskeyboardMash;
	}
	
	public boolean CatlistChecker(String currentInput)
	{
		boolean hasCatlist = false;
		for (String currentcatlist:catList)
		{
			if(currentInput.equalsIgnoreCase(currentcatlist))
			{
				hasCatlist = true;
			}
		}
		
		return hasCatlist;
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
	
	
	public  String prossesConersation(String currentChat)
	{
		String nextConversation = "Oh, what else would you like to talk about?";
		int   randomTopic =(int) (Math.random() * 10);//generates a random number between 0 and 4
		
		switch (randomTopic)
				{
				
				
			case 0:
				if(memeChecker(currentChat))
				{
					nextConversation = "But now that you know we can talk about something else : l";
					if(memeChecker(currentChat))
					{
						JOptionPane.showMessageDialog(null,"That meme is so last year. Do you know what my favrate meme is?");
						JOptionPane.showMessageDialog(null,"Troll!");
						JOptionPane.showMessageDialog(null,"Troll!");
						JOptionPane.showMessageDialog(null,"Troll!");
						JOptionPane.showMessageDialog(null,"Troll!");
						JOptionPane.showMessageDialog(null,"Troll!");
						JOptionPane.showMessageDialog(null,"Troll!");
						JOptionPane.showMessageDialog(null,"Troll!");
						JOptionPane.showMessageDialog(null,"Troll!");
						JOptionPane.showMessageDialog(null,"Troll!");
						JOptionPane.showMessageDialog(null,"Troll!");
						JOptionPane.showMessageDialog(null,"Troll!");
						JOptionPane.showMessageDialog(null,"Troll!");
						JOptionPane.showMessageDialog(null,"Troll!");
						JOptionPane.showMessageDialog(null,"Troll!");
						JOptionPane.showMessageDialog(null,"Troll!");
						JOptionPane.showMessageDialog(null,"Troll!");
						JOptionPane.showMessageDialog(null,"Troll!");
						
					}
				}
				break;
			case 1:
				if(politicalTopicChecker(currentChat))
				{
					nextConversation = "Oh a political topic! I see well I think that you should let me run evrething.  ";
				}
				break;
			case 2:
				if(currentChat.length () > 20)
				{
					nextConversation = "Oh wow your useing a lot of big words there.You used a length more then 20. Good job.  ";
				}
				break;
			case 3:
				if(CatlistChecker(currentChat))
				{
					nextConversation = "this is PURRfict";
				}
				break;
			case 4:
				nextConversation = "You should try clicking on the screen background : ). ";
				break;
			case 5:
				if(memeChecker(currentChat))
				{
					nextConversation = "Oh that's such a fun meme :D";
				}
				break;
			case 6:
				if(politicalTopicChecker(currentChat))
				{
					nextConversation = "Oh a political topic! That's fun";
				}
				break;
			case 7:
				if(currentChat.length () > 20)
				{
					nextConversation = "What? The length is more then 20. Good job.  ";
				}
				break;
			case 8:
				if(CatlistChecker(currentChat))
				{
					nextConversation = "I can't think of a cat pun. so ";
				}
				break;
			case 9:
				nextConversation = "have you tryed to hold down alt and moving your mouse on the background? ";
				break;
			default: 
				nextConversation = "if you found this then the universe has ended. Try restarting it. That fixes it most of the time.";
				break;
				
	}
		
				
		
		
		return nextConversation;
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
		return politicalTopicList;
	}

	public ArrayList<String> getkeyboardMash()
	{
		return keyboardMash;
	}
	/**
	 * Updates the content area for this Chatbot instance.
	 * 
	 * @param content
	 *            The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content= content;
	}
}