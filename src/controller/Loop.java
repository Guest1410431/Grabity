package controller;

public class Loop extends Thread
{
	private Controller controller;
	
	public Loop(Controller controller)
	{
		this.controller = controller;
	}
	
	public void run()
	{
		long tickTime = 1000 / 60;
		long startTime;
		long sleepTime;
		
		while (true)
		{
			startTime = System.currentTimeMillis();
			
			try
			{
				controller.update();
			}
			finally
			{
				
			}
			sleepTime = tickTime - (System.currentTimeMillis() - startTime);
			
			try
			{
				if (sleepTime > 0)
				{
					sleep(sleepTime);
				}
				else
				{
					sleep(10);
				}
			}
			catch (Exception e)
			{
				
			}
		}
	}
}
