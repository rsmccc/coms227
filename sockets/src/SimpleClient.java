
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Test client for use with SimpleServer.
 */
public class SimpleClient
{
  /**
   * @param args
   */
  public static void main(String[] args)
  {
    Socket s = null;
    try
    {
      // open a connection to the server on port 2222
      s = new Socket("localhost", 2222);

      // for line-oriented output we use a PrintWriter
      PrintWriter pw = new PrintWriter(s.getOutputStream());
      pw.println("Hello, server!");
      pw.println("It's nice to finally connect with you.");
      pw.println(); // empty line terminates input
      pw.flush();  // don't forget to flush...    
      
      // read response, which we expect to be line-oriented text
      Scanner scanner = new Scanner(s.getInputStream());
      while (scanner.hasNextLine())
      {
        System.out.println(scanner.nextLine());
      }
    }
    catch (IOException e)
    {
      System.out.println(e);
    }
    finally
    {
      // be sure streams are closed
      try
      {
        s.close();
      }
      catch (IOException ignore){}
    }

  }

}
