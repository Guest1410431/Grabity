package model;

import java.awt.Color;
import java.awt.Graphics;

public class Model
{
	private Planet planet;
	private Planet sun;

	public Model()
	{
		planet = new Planet((float) (Math.random() * 200), (float) (Math.random() * 200), (float) (Math.random() * 4) - 2, (float) (Math.random() * 4) - 2, (float) (Math.random() * 20), true);
		sun = new Planet(200, 200, 0, 0, 25f, false);
	}

	public void setPlanet(float xPos, float yPos, float xforce, float yforce, float mass)
	{
		planet = new Planet(xPos, yPos, xforce, yforce, mass, true);
	}
	public Planet getPlanet()
	{
		return planet;
	}

	public void update()
	{
		planet.interacts(sun);

		planet.update();
	}

	public void render(Graphics g)
	{
		planet.render(g);
		sun.render(g);
		System.out.println("Hello");
		g.setColor(Color.BLACK);
		g.drawLine((int) (planet.getXPos()), (int) (planet.getYPos()), (int) (sun.getXPos()), (int) (sun.getYPos()));
	}
}
