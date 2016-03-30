package chat.model;
import java.util.ArrayList;
import java.util.Scanner;

import twitter4j.GeoLocation;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
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
	private ArrayList<String> wordsList;
	private Twitter chatbotTwitter;
	private ChatController baseController;
	

	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		chatbotTwitter = TwitterFactory.getSingleton();
		statusList = new ArrayList<Status>();
		wordsList = new ArrayList<String>();
	}
	
	public void sendTweet(String tweet)

	{
		try
		{
			chatbotTwitter.updateStatus("Lower text book prices!!!!!-  Bodie Shane");
		}
		catch (TwitterException error)
		{
			
			baseController.handleErrors(error.getErrorMessage());
			
		}
	}

	public void loadTweets(String twitterHandle) throws TwitterException
	{
		statusList.clear();
		wordsList.clear();
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
				wordsList.add(removePuntuation(word).toLowerCase());
			}
		
		}
		
		removeCommonglishWords(wordsList);
		removeEmptyText();
	}

	private void removeEmptyText()
	{
		for (int spot =0; spot < wordsList.size(); spot++)
		{
			if (wordsList.get(spot).equals (""))
			{
				wordsList.remove(spot);
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
	
	public String topResults()
	{
		String tweetResults = "";
		int topWordLocation = 0;
		
		int topCount = 0;
		
		for(int index =0; index < wordsList.size(); index++)
		{
			int wordUseCount = 1;
			for(int spot = index + 1; spot < wordsList.size(); spot++)
			{
				if(wordsList.get(index).equals(wordsList.get(spot)))
				{
					wordUseCount ++;
				}
				if(wordUseCount > topCount)
				{
					topCount = wordUseCount;
					topWordLocation = index;
				}
			}
		}
		
		tweetResults = " the top wod in the tweets was" + wordsList.get(topWordLocation) + " and it was used"+
		topCount + "times!";
		return tweetResults;
		
		
	}
	
	private String[] importWordsToArray()
	{
		String[]boringWords;
		int wordCount =0;
		
			Scanner wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
			while (wordFile.hasNext())
			{
				wordCount ++;
				wordFile.next();
			}
			wordFile= new Scanner(getClass().getResourceAsStream("commonWords.text"));
			boringWords = new String [wordCount];
			int boringWordCount = 0;
			while (wordFile.hasNext())
			{
				boringWords[boringWordCount]= wordFile.next();
				boringWordCount ++;
			}
			wordFile.close();
			return boringWords;
	}

	
	
	public String sampleInvestigation()
	{
		String results="";
		Query query = new Query ("marathon");
		query.setCount(100);
		query.setGeoCode(new GeoLocation(40.487521,-111.869176), 8, Query.MILES);
		try
		{
			QueryResult result = chatbotTwitter.search ( query);
			results += "Count; " + result.getTweets().size() + "\n";
			{
				for (Status tweet: result.getTweets())
				{
					results+="@" + tweet.getUser().getName()+ ":" + tweet.getText() + "\n";
					
					
				}
			}
			}
			catch (TwitterException error)
			{
				error.printStackTrace();
			}
			return results;
		
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

	
	// When I click the button it goes to the analyze in the controller. Then it goes to top results. and prints it on the screen.  

	
}
