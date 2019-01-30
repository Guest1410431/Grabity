package view;

import java.awt.Graphics;

import javax.swing.JPanel;

import model.Model;

public class DrawPanel extends JPanel
{
	private Model model;
	
	public DrawPanel(Model model)
	{
		this.model = model;
	}
	
	protected void paintComponent(Graphics g)
	{
		model.render(g);
	}
}
