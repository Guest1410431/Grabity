package model;

import java.util.ArrayList;

public class Generation
{
	private int numTrials;
	
	private int currentGeneration;
	private int currentPlanet;
	
	private ArrayList<Planet>planetGeneration;
	
	public Generation(int numTrials)
	{
		this.numTrials = numTrials;
		
		currentGeneration = 0;
		currentPlanet = 0;
		planetGeneration = new ArrayList<Planet>();
	}
	public void runGeneration()	
	{
		
	}
}

















