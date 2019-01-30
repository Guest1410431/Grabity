package view;

import model.Model;

public class View
{
	private Model model;
	
	private Window window;
	
	public View(Model model)
	{
		this.model = model;
		
		window = new Window();
		window.setModel(model);
	}
	
	public void update()
	{
		model.update();
		window.update();
	}
}