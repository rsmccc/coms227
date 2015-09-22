package lab3;
import plotter.SimulationPlotter;

public class RabbitSimApp 
{
	public static void main(String[] args)
	{
		RabbitModel myModel = new RabbitModel();
		SimulationPlotter plotter = new SimulationPlotter();
		plotter.simulate(myModel);
	}
}
