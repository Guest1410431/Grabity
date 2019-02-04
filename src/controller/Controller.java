package controller;

import model.Generation;
import model.Model;
import model.Planet;
import view.View;

public class Controller
{
	private Model model;
	private View view;
	private Planet planet;
	private Generation generation;

	public Controller(Model model, View view)
	{
		this.model = model;
		this.view = view;
	}

	public void startLoop()
	{
		new Loop(this).run();
	}
	public void update()
	{
		// TODO: Genetic Algorithm here-ish?

		// Check if old planet dies
		if (model.getPlanet().isDead())
		{
			generation.add(model.getPlanet());

					// Check if end of Generation (10-15 trials)
						// If end of generation, what (n)best planets from most recently finished generation are averaged out
						// Start next generation
		}

		//System.out.println("Hello");
		view.update();
	}
}
