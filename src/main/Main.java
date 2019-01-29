package main;

import controller.Controller;
import model.Model;
import view.View;

public class Main
{
	public static void main(String[]args)
	{
		System.out.println("Hello World");
		Model model = new Model();
		View view = new View(model);
		Controller controller = new Controller(model, view);
	}
}
