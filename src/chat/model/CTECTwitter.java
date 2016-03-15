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
		for (int spot =0; spot < wordList.size(); spot++)
		{
			if (wordList.get(spot).equals (""))
			{
				wordList.remove(spot);
				spot--;// WHEN REMOVEING THINGS FORM A LIST DO -- Because it will go over if you don't  
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void removeCommonglishWords(ArrayList<String> wordList)
	{
		String[] boringWords = importWordsToArray();
		for (int count = 0; count < wordList.size();count++)
		{
			for (int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if (wordList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					wordList.remove(count);
					count--;// when you remove you have to --
					removeSpot = boringWords.length;
				}
			}
		}
		//removeTwitterUsernamesFromList(wordList);
		
		//return wordList;
	}

	private String[] importWordsToArray()
	{
		// TODO Auto-generated method stub
		return null;
	}

	private String removePuntuation(String currentString)
	{
		String punctuaion = ".,'?!:;\"(){}^[]<>-;"; // This is everything that it will remove
		String scrubbedString = "";
		for(int i =0;i< currentString.length(); i++) // It is going through the text
		{
			if (punctuaion.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);// This is taking the changed text and adding it to the array. It removes the text at the top.
			}
		}
		
		return scrubbedString;
	}

	
}
