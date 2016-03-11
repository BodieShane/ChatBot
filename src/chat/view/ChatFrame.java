package chat.view;


import java.awt.Dimension;

import javax.swing.JFrame;

import chat.controller.*;

public class ChatFrame extends JFrame
{
	private ChatController baceController;
	private ChatPanel basePanel;

	public ChatFrame(ChatController baceController)
	{
		this.baceController = baceController;
		basePanel = new ChatPanel (baceController);
		
		setupFrame();
	
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(600,600);
		this.setTitle("ChatBot");
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	public ChatController getBaseController()
	{
		return baceController;
	}
}
