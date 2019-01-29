package model;

import java.awt.Color;
import java.awt.Graphics;

public class Planet
{
	private final int INTERSECTION_THRESHOLD = 10;
	private final float DENSITY = 2;
	
	private float xPos;
	private float yPos;
	private int score;
	private float xforce;
	private float yforce;
	private float mass;
	private boolean moves;
	private float radius;
	
	public Planet(float xPos, float yPos, float xforce, float yforce, float mass, boolean moves)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.xforce = xforce;
		this.yforce = yforce;
		this.mass = mass;
		this.moves = moves;
		
		radius = DENSITY * mass;
	}
	
	public void interacts(Planet planet)
	{
		float dx = planet.getXPos() - xPos;
		float dy = planet.getYPos() - yPos;
		double r = calculateDistance(planet);
		double inv_r3 = 1.0 / (r * r * r);
		// Precalculate force component (1/r^2) times direction (dx/r) = dx /
		// r^3
		dx *= inv_r3;
		dy *= inv_r3;
		// calculate accelerations for both bodies
		if (moves)
		{
			xforce += planet.getMass() * dx;
			yforce += planet.getMass() * dy;
		}
		if (planet.getMoves())
		{
			planet.setXforce(planet.getXforce() + (mass * -dx));
			planet.setYforce(planet.getYforce() + (mass * -dy));
		}
	}
	
	private float calculateDistance(Planet planet)
	{
		float planetx = Math.abs(planet.getXPos() - this.getXPos());
		float planety = Math.abs(planet.getYPos() - this.getYPos());
		float c = planetx * planetx + planety * planety;
		return (float) Math.sqrt(c);
	}
	
	public boolean intersects(Planet planet)
	{
		return calculateDistance(planet) <= INTERSECTION_THRESHOLD + radius;
	}
	
	public float getXPos()
	{
		return xPos;
	}
	
	public float getYPos()
	{
		return yPos;
	}
	
	public float getXforce()
	{
		return xforce;
	}
	
	public float getYforce()
	{
		return yforce;
	}
	
	private void setYforce(float xforce)
	{
		this.yforce = yforce;
	}
	
	private void setXforce(float f)
	{
		this.xforce = xforce;
	}
	
	public boolean getMoves()
	{
		return moves;
	}
	
	public float getMass()
	{
		return mass;
	}
	
	public void render(Graphics g)
	{
		g.setColor((moves) ? new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)) : Color.YELLOW);
		
	}
}
