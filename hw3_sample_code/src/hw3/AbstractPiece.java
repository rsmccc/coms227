
package hw3;

import hw3.api.IPolyomino;

public abstract class AbstractPiece implements IPolyomino
{

  // TODO: add any constructors, instance variables, or methods that you need.
  
  
  /**
   * Returns a deep copy of this object.
   * 
   * @return 
   *   a deep copy of this object.
   */
  public IPolyomino clone()
  {
    // The built-in cloning mechanism of the Java runtime will
    // create an object of the correct runtime type.
    AbstractPiece cloned = null;
    try
    {
      cloned = (AbstractPiece) super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      // can't happen in this case
    }
    
    //
    // TODO: 
    //
    // Since clone() only gives us a "shallow" copy that shares  
    // references with the original, we have to make copies for all 
    // instance variables that are references (such as the Position 
    // and Block[] attributes).  See hw3.example.SamplePiece for an
    // example.
    //
    

    
    
    return cloned;
  }

}
