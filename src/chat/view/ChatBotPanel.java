package chat.view;

import javax.swing.*;

import	chat.controller.*;
import chat.model.*;
import chat.view.*;

import java.awt.Color;
import java.awt.event.*;

public class ChatBotPanel extends JPanel
{
	private ChatBotController baseController;
	private JButton submitButton;
	private JTextField TextField;
	private SpringLayout baseLayout;
	private JTextArea chatArea;
	private JLabel	promptLabel; 
	private JButton quitButton;
	private ChatView myDisplay;
	private Chatbot myBot;
	
	public ChatBotPanel (ChatBotController baseController)
	{
			this.baseController = baseController;
			baseLayout = new SpringLayout();
			submitButton = new JButton("Enter");
			
			TextField = new JTextField ("Words can be typed here");
			
			
			chatArea = new JTextArea (10,30);
			
			
			
			promptLabel = new JLabel("Talk with me");
			
			
			quitButton = new JButton("Quit");
			
			
			
			
			setupPanel();
			setupLayout();
			setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(submitButton);
		this.add(TextField);
		this.add(chatArea);
		this.add(promptLabel);
		this.add(quitButton);
		
		TextField.setToolTipText("Type Here to talk with the ChatBot");
		
		chatArea.setEditable(false);
	}
	private void changeRandomColor()
	{
		int red,green,blue;
		red = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);
		blue = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red,green,blue));
				
	}
	private void setupLayout()
	{
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

	private void setupListeners()
	{
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

	public JComponent getTextField()
	{
		
		return TextField;
	}
	
}
