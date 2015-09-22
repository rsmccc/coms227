package lab2;

public class Atom
{
	/**
	 * number of protons in this Atom.
	 */
	private int protons;
	
	/**
	 * number of neutrons in this Atom.
	 */
	private int neutrons;
	
	/**
	 * number of electrons in this Atom.
	 */
	private int electrons;
	
	/**
	   * Constructs an Atom with the given number of protons, neutrons and electrons.
	   * @param givenProtons 
	   *   the number of protons in this Atom
	   * @param givenNeutrons
	   *   the number of neutrons in this Atom
	   * @param givenElectrons
	   *    the number of electrons in this Atom 
	   */
	public Atom(int givenProtons, int givenNeutrons, int givenElectrons) 
	{
		protons = givenProtons;
		neutrons = givenNeutrons;
		electrons = givenElectrons;
	}
	
	/**
	 * Returns the total number of protons plus neutrons for this Atom.
	 *   @return
	 *     atomic mass of this Atom
	 */
	public int getAtomicMass()
	{
		return protons + neutrons;
	}
	
	/**
	 * Returns the difference between the number of protons and electrons for this Atom.
	 *   @return
	 *     atomic charge of this Atom
	 */
	public int getAtomicCharge()
	{
		return protons - electrons;
	}
	
	/**
	 * Decreases the number of protons by 2 and the number of neutrons by 2.
	 */
	public void decay()
	{
		protons = protons - 2;
		neutrons = neutrons - 2;
	}
}
