package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JPanel
{
	private final int WIDTH = 600;
	private final int HEIGHT = 600;

	private JFrame frame;

	public Window()
	{
		frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("Grabity");
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		initListeners();
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

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.setColor(Color.BLACK);
		g.fillRect(10, 10, 100, 100);

		repaint();
	}
}
