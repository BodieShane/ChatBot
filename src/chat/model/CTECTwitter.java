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


	public CTECTwitter()
	{
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
	}
}
