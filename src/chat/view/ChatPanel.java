package chat.view;

import javax.swing.*;

import	chat.controller.*;
import chat.model.*;
import chat.view.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton submitButton;
	private JTextField TextField;
	private SpringLayout baseLayout;
	private JTextArea chatArea;
	private JLabel	promptLabel; 
	private JButton quitButton;
	private ChatView myDisplay;
	private Chatbot myBot;
	private JButton alyzeTwitterButton;
	
	/////update////////
	private JButton tweetButton;
	private JButton saveButton;
	private JButton lodeButton;
	private JScrollPane textPane;
	
	
	//The base Controller is what the chat Bot is useing to make what is on the JButton and JText Area...so on.
	public ChatPanel (ChatController baseController)
	{
			this.baseController = baseController;
			baseLayout = new SpringLayout();
			submitButton = new JButton("Enter");
			TextField = new JTextField ("Words can be typed here");
			chatArea = new JTextArea (10,30);
			promptLabel = new JLabel("Talk with me");
			quitButton = new JButton("Quit");
			tweetButton = new JButton("tweet");
			
			alyzeTwitterButton = new JButton("alyzeTwitter");
			
			
			
			setupChatPane();
			setupPanel();
			setupLayout();
			setupListeners();
	}
	
	
	
	
	private void setupChatPane()
	{
		
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
		textPane = new JScrollPane(chatArea);
		
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	}
	
	// the chat bot uses this to set up the Panel

	private void setupPanel()

	{
		
		this.setLayout(baseLayout);
		this.add(submitButton);
		this.add(TextField);
		this.add(textPane);
		this.add(promptLabel);
		this.add(quitButton);
		this.add(tweetButton);
		this.add(alyzeTwitterButton);
		this.setPreferredSize(new Dimension(600,600));
		
		
		TextField.setToolTipText("Type Here to talk with the ChatBot");
		
		chatArea.setEditable(false);
	}

	//I used this to change colors in my chat bot.
	private void changeRandomColor()
	{
		int red,green,blue;
		red = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);
		blue = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red,green,blue));
				
	}
	//this is pretty much the dumping ground for my code.
private void setupLayout()
	{
	baseLayout.putConstraint(SpringLayout.EAST, tweetButton, 0, SpringLayout.EAST, submitButton);
	baseLayout.putConstraint(SpringLayout.SOUTH, alyzeTwitterButton, -118, SpringLayout.NORTH, TextField);
	baseLayout.putConstraint(SpringLayout.NORTH, tweetButton, 0, SpringLayout.NORTH, alyzeTwitterButton);
	baseLayout.putConstraint(SpringLayout.WEST, alyzeTwitterButton, 0, SpringLayout.WEST, TextField);
	baseLayout.putConstraint(SpringLayout.NORTH, textPane, 30, SpringLayout.NORTH, this);
	baseLayout.putConstraint(SpringLayout.WEST, textPane, 20, SpringLayout.WEST, this);
	baseLayout.putConstraint(SpringLayout.SOUTH, textPane, 250, SpringLayout.NORTH, this);
	baseLayout.putConstraint(SpringLayout.EAST, textPane, -20, SpringLayout.EAST, this);
	baseLayout.putConstraint(SpringLayout.WEST, promptLabel, 256, SpringLayout.WEST, this);
	baseLayout.putConstraint(SpringLayout.SOUTH, promptLabel, -6, SpringLayout.NORTH, chatArea);
	baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 3, SpringLayout.SOUTH, quitButton);
	baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -5, SpringLayout.NORTH, TextField);
	baseLayout.putConstraint(SpringLayout.EAST, chatArea, 0, SpringLayout.EAST, this);
	baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 1, SpringLayout.NORTH, TextField);
	baseLayout.putConstraint(SpringLayout.SOUTH, TextField, -10, SpringLayout.SOUTH, this);
	baseLayout.putConstraint(SpringLayout.WEST, TextField, 37, SpringLayout.WEST, this);
	baseLayout.putConstraint(SpringLayout.EAST, TextField, -135, SpringLayout.EAST, this);
	baseLayout.putConstraint(SpringLayout.WEST, submitButton, 6, SpringLayout.EAST, TextField);
	baseLayout.putConstraint(SpringLayout.WEST, chatArea, 0, SpringLayout.WEST, this);
	baseLayout.putConstraint(SpringLayout.EAST, quitButton, -10, SpringLayout.EAST, this);
	}
		//This is where the code lessens to . 
	private void setupListeners()
	{
		alyzeTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String user = TextField.getText();
				String results = baseController.analyzeTweet();
				chatArea.setText(results);
			}

		});
		
		alyzeTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String user = TextField.getText();
				String results = baseController.analyze(user);
				chatArea.setText(results);
			}

		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.sendTweet("no text to send");
			}
		});
		
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = TextField.getText();
				chatArea.append("\nUser:" + userText);
				TextField.setText("");
				String response = baseController.userToChabot(userText);
				chatArea.append("\nChatbot:" + response);
			}
		});
		quitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				JOptionPane.showMessageDialog(null,"Goodbye it has been my pleasure to talk with you");
				System.exit(0);
			}
		});
		
		
		this.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent click)
			{
				
			}
			public void mousePressed(MouseEvent pressed)
			{
				changeRandomColor();
			}
			public void mouseExited(MouseEvent exited)
			{
				//	changeRandomColor();
			}
			public void mouseReleased(MouseEvent Released)
			{
		//		changeRandomColor();
		
			}
			public void mouseEntered(MouseEvent Entered)
			{
				//	changeRandomColor();
				
			}
});
		
		this .addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseMoved(MouseEvent moved)
			{
			if(moved.isAltDown())
			{
				changeRandomColor();
			}
			
			
				
			// NEVER USE THIS IT WILL KILL YOUR EYES!!!
			//changeRandomColor();
			}
		
			public void mouseDragged(MouseEvent dragged)
			{
			//changeRandomColor();
			}
	
		});
	}
//this is just to to return the Text field.
	public JComponent getTextField()
	{
		
		return TextField;
	}
	
}
