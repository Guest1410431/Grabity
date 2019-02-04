package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import model.Model;

public class Window
{
	private final int WIDTH = 600;
	private final int HEIGHT = 600;
	
	private JFrame frame;
	
	private Model model;
	private DrawPanel drawPanel;
	
	public Window()
	{
		frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("Grabity");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
		
		initListeners();
	}
	
	public void setModel(Model model)
	{
		this.model = model;
		
		drawPanel = new DrawPanel(model);
		frame.add(drawPanel);
	}
	
	private void initListeners()
	{
		frame.addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e)
			{
				int key = e.getKeyCode();
				
				if (key == KeyEvent.VK_ESCAPE)
				{
					System.exit(0);
				}				
			}
			
			public void keyReleased(KeyEvent e)
			{
			}
			
			public void keyTyped(KeyEvent e)
			{
			}
		});
	}
	
	public void update()
	{
		frame.repaint();
		drawPanel.repaint();
	}
}
