package chat.view;


import javax.swing.JFrame;

import chat.controller.*;

public class ChatBotFrame extends JFrame
{
	private ChatBotController baceController;
	private ChatBotPanel basePanel;

	public ChatBotFrame(ChatBotController baceController)
	{
		this.baceController = baceController;
		basePanel = new ChatBotPanel (baceController);
		
		setupFrame();
	
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(600,600);
		this.setTitle("ChatBot");
		this.setResizable(true);
		this.setVisible(true);
	}
	
	public ChatBotController getBaseController()
	{
		return baceController;
	}
}
