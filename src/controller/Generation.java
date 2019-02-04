package controller;

import java.util.ArrayList;

import model.Planet;

public class Generation
{
  private ArrayList<Planet>generation;

  public Genenration()
  {
    generation = new ArrayList<Planet>();
  }
  public void addPlanet(Planet planet)
  {
    generation.add(planet);

    Collections.sort(generation, new Comparator<Planet>()
    		{
    			public int compare(Planet planet, Planet otherPlanet)
    			{
    				return Integer.compare(planet.getScore(), otherPlanet.getScore());
    			}
    		});
  }
  // Checks FULL generation.
  // Returns average of given (n) best performing planets based on score
  public Planet averagePlanet (int best)
  {
    float xposAverage=0;
    float yposAverage=0;
    float xforceAverage=0;
    float yforceAverage=0;
    float massAverage=0;

    for(int i=0; i<best; i++)
    {
      xposAverage += generation.get(i).getXPos();
      yposAverage += generation.get(i).getYPos();
      xforceAverage += generation.get(i).getXforce();
      xforceAverage += generation.get(i).getYforce();
      massAverage += generation.get(i).getMass();
    }
    return new Planet(xposAverage/best, yposAverage/best, xforceAverage/best, yforceAverage/best, massAverage/best, true);
  }


  public int size()
  {
    return generation.size();
  }
  public void clear()
  {
    generation.clear();
  }
}
