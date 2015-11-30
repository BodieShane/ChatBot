package chat.view;

import javax.swing.*;

import	chat.controller.ChatBotController;

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
	
	public ChatBotPanel (ChatBotController baceController)
	{
			this.baseController = baseController;
			baseLayout = new SpringLayout();
			submitButton = new JButton("Enter");
			
			TextField = new JTextField ("Words can be typed here");
			chatArea = new JTextArea (10,30);
			promptLabel = new JLabel("Talk with me");
			TextField.setToolTipText("Type Here for the ChatBot");
			
			setupPanel();
			setupLayout();
			setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
	
		this.add(TextField);
		this.add(chatArea);
		this.add(promptLabel);
		this.add(submitButton);
		
		
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
	baseLayout.putConstraint(SpringLayout.WEST, chatArea, 37, SpringLayout.WEST, this);
	baseLayout.putConstraint(SpringLayout.WEST, promptLabel, 175, SpringLayout.WEST, this);
			baseLayout.putConstraint(SpringLayout.SOUTH, promptLabel, -14, SpringLayout.NORTH, chatArea);
	baseLayout.putConstraint(SpringLayout.NORTH, TextField, 254, SpringLayout.NORTH, this);
			baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -6, SpringLayout.NORTH, TextField);
			baseLayout.putConstraint(SpringLayout.WEST, TextField, 132, SpringLayout.WEST, this);
	baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -87, SpringLayout.SOUTH, this);
	baseLayout.putConstraint(SpringLayout.WEST, submitButton, 0, SpringLayout.WEST, promptLabel);
	
	
	
	
	
	}

	private void setupListeners()
	{
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
			
			
				
			// NEVER USE THIS
			//changeRandomColor();
			}
		
			public void mouseDragged(MouseEvent dragged)
			{
			//changeRandomColor();
			}
	
		});
	}
	
}
