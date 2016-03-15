package chat.model;
import java.util.ArrayList;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import chat.controller.ChatController;
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
	private ChatController baseController;
	

	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		chatbotTwitter = TwitterFactory.getSingleton();
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
	}
	
	public void sendTweet(String tweet)

	{
		try
		{
			chatbotTwitter.updateStatus("Lower text book prices!!!!!");
		}
		catch (TwitterException error)
		{
			
			baseController.handleErrors(error.getErrorMessage());
			
		}
	}

	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statuspage = new Paging (1,200);
		int page = 1;
		while (page <= 10)
		{
			statuspage.setPage(page);
			statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandle,statuspage));
			
			
			page ++;
		}
		for(Status currentStatus : statusList)
		{
			String[] tweetText = currentStatus.getText().split("");
			for(String word: tweetText)
			{
				wordList.add(removePuntuation(word).toLowerCase());
			}
		
		}
		
		removeCommonglishWords(wordList);
		removeEmptyText();
	}

	private void removeEmptyText()
	{
		
	}

	private void removeCommonglishWords(ArrayList<String> wordList2)
	{
		
	}

	private String removePuntuation(String currentString)
	{
		String punctuaion = ".,'?!:;\"(){}^[]<>-;";
		String scrubbedString = "";
		for(int i =0;i< currentString.length(); i++)
		{
			if (punctuaion.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		
		return scrubbedString;
	}

	
}
