package chat.model;
import java.util.ArrayList;

import twitter4j.*;
/**
 * 
 * @author bsha6756
 * @version 0.03
 * This is going to talk with Twitter
 *
 */


public class CTECTwitter
{
	
	
	private ArrayList <Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;


	public CTECTwitter()
	{
		chatbotTwitter = TwitterFactory.getSingleton();
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
	}
	
	public void sendTweet(String tweet)
	{
		try
		{
			chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks #ShamelessPlugin @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		}
		catch (TwitterException e)
		{
			
			e.printStackTrace();
		}
	}
}
