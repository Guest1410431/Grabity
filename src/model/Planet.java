package model;

import java.awt.Color;
import java.awt.Graphics;

public class Planet
{
	private final int INTERSECTION_THRESHOLD = 0;
	private final float DENSITY = 2.0f;

	private float xPos;
	private float yPos;
	private int score;
	private float xforce;
	private float yforce;
	private float mass;
	private boolean moves;
	private boolean	dead;
	private float radius;

	public Planet(float xPos, float yPos, float xforce, float yforce, float mass, boolean moves)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.xforce = xforce;
		this.yforce = yforce;
		this.mass = mass;
		this.moves = moves;

		dead = false;

		score = 0;
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

	public void update()
	{
		xPos += xforce;
		yPos += yforce;
		score++;
	}

	private float calculateDistance(Planet planet)
	{
		float planetx = Math.abs(planet.getXPos() - this.getXPos());
		float planety = Math.abs(planet.getYPos() - this.getYPos());
		float c = planetx * planetx + planety * planety;

		System.out.println("C: " + (float) Math.sqrt(c));
		return (float) Math.sqrt(c);
	}

	public boolean intersects(Planet planet)
	{
		boolean intersects = calculateDistance(planet) <= planet.getRadius() + radius;

		if(intersects)
		{
			dead = true;
		}
		
		return intersects;
	}
	public int getScore()
	{
		return score;
	}
	public boolean isDead()
	{
		return dead;
	}

	public float getRadius()
	{
		return radius;
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

	private void setYforce(float yforce)
	{
		this.yforce = yforce;
	}

	private void setXforce(float xforce)
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
		g.setColor((moves) ? Color.BLACK : Color.YELLOW);

		g.fillOval((int) (xPos-radius), (int) (yPos-radius), (int) (radius * 2), (int) (radius * 2));

		g.setColor(Color.RED);
		g.fillOval((int)(xPos)-1, (int)(yPos)-1, 2, 2);
	}

	public boolean leavesBounds(int i, int j)
	{
		return (xPos > i || xPos < 0 || yPos < 0 || yPos > j);
	}
}
