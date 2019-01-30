package controller;

import model.Model;
import view.View;

public class Controller
{
	private View view;
	
	public Controller(View view)
	{
		this.view = view;
	}
	
	public void startLoop()
	{
		new Loop(this).run();
	}
	public void update()
	{
		// TODO: Genetic Algorithm here-ish?
		view.update();
	}
}
