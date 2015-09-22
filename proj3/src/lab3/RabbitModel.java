package lab3;


/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel
{
  
  private int population;
  private int year;
  private int before;
  private int last;

	
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel()
  {
    population = 1;
    before = 0;
    last = 1;
    year = 0;
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation()
  {
    
    return population;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
	  year += 1;
	  before = last;
	  last = population;
	  population += before;
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
    population = 1;
    before = 0;
    last = 1;
  }
}
