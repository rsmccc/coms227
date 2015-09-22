/**
 * Illustration of exception handling.
 */
public class ExceptionExample
{
  /**
   * @param args not used
   */
  public static void main(String[] args)
  {
    ExceptionExample t = new ExceptionExample();
    System.out.println("main calling m1()");
    t.m1();
  }

  
  // Called by main()
  public void m1()
  {
    System.out.println("Starting m1 ");
 
    try
    {
      m2();
      
      // remaining code is not executed if m2 throws an exception
      System.out.println("Finishing try block of m1");
    }
    catch (MyException e)
    {
      System.out.println("m1 caught exception: " + e);
      
      // if we want, look at the stack trace
      //e.printStackTrace(System.out);
    }
    
    // we could also catch other exception types
    catch (NullPointerException npe)
    {
      System.out.println("m1 caught a NullPointerException");
    }
    
    // remaining code is still executed if m2 throws MyException,
    // which we caught and handled above
    System.out.println("Executing last line of m1");
  } 
  
  // Called by m1()
  public void m2() throws MyException
  {
    try
    {
      System.out.println("  Starting m2");
      m3();
      
      // remaining code is not executed if m3 throws an exception
      System.out.println("  Finishing try block of m2");
    }
    finally
    {
      System.out.println("  Finally block of m2 executes no matter what");
    }
    
    // remaining code is not executed if m3 throws an exception
    System.out.println("  Executing last line of m2");
  }
  
  // Called by m2()
  public void m3() throws MyException
  {
    System.out.println("    Starting m3");
    m4();
    
    // remaining code is not executed if m4 throws an exception
    System.out.println("    Executing last line of m3");
  }
  
  // Called by m3()
  public void m4() throws MyException
  {
    System.out.println("      Starting m4");
    
    // throw a "checked" exception...
    System.out.println("      About to throw MyException from m4");
    throw new MyException("This happened in m4");
    
    // or, throw a runtime exception...
//    System.out.println("      About to throw NullPointerException from m4");
//    Object obj = null;
//    obj.toString();
    
    // or, just return normally
    //System.out.println("      Returning normally from m4");

  }
}

/**
 * A simple subclass of Exception.  Note this is a "checked"
 * exception, since we aren't extending RuntimeException.
 */
class MyException extends Exception
{
  public MyException(String message)
  {
    super(message);
  }
  public MyException()
  {
    super();
  }
}