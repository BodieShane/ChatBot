package chat.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import chat.view.*;
import chat.controller.*;

public class ChatFrameTest
{
	private ChatBotFrame baseFrame;
	private ChatBotController baseController;

	@Before
	public void setUp() throws Exception
	{
		baseController = new ChatBotController();
		baseFrame = new ChatBotFrame(baseController);
	}

	@After
	public void tearDown() throws Exception
	{
		baseFrame = null;
		baseController = null;
	}

	@Test
	public void testChatFrame()
	{
		assertNotNull("Baseframe is not instanciated", baseFrame);
		assertNotNull("Pane not installed", baseFrame.getContentPane());
	}
	
	@Test
	public void testSetupFrame()
	{
		assertNotEquals("Blank titles are boring", baseFrame.getTitle(), "");
		assertTrue("Minimum width not made", baseFrame.getWidth() > 300);
		assertTrue("Minimum height not made", baseFrame.getHeight() > 300);
		assertTrue("You need to see this", baseFrame.isVisible());
		assertTrue("Panel is installed", baseFrame.getContentPane() instanceof ChatBotPanel);
	}

}