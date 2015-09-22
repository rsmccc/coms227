
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A simple example of a server.  This server accepts
 * connections on port 2222, reads and echos text input 
 * until a blank line is received, and then writes the
 * string "OK" to the client.
 * <p>
 * Try this with SimpleClient.
 */
public class SimpleServer
{
  public static void main(String[] args)
  {
    new SimpleServer().runServer(2222);    
  }

  /**
   * Basic server loop. 
   * @param port
   *   the port number on which to listen
   */
  public void runServer(int port)
  {
    ServerSocket ss = null;
    try
    {
      ss = new ServerSocket(port);
      while (true)
      {
        System.out.println("Server listening on " + port);
        
        // waits here until a client attempts to connect
        Socket s = ss.accept();
        handleConnection(s);
      }      
    }
    catch (IOException e)
    {
      System.out.println("I/O error: " + e);
    }
    finally
    {
      if (ss != null)
      {
        try
        {
          ss.close();
        }
        catch (IOException ignore) {}
      }
    }
  }
  
  /**
   * Basic server loop, with error recovery.  If the server socket fails,
   * a new one is created. 
   * @param port
   *   the port number on which to listen
   */
  public void runServerAlt(int port)
  {
    while(true)
    {
      runServer(port);
       
      // We only get here if the server socket was closed.
      // Wait a few seconds and try opening the socket again.
      try
      {
        Thread.sleep(2000);
      }
      catch (InterruptedException e)
      {
        // shouldn't happen
      }
    }    
  }
  
  /**
   * Helper method for handling a client connection.  Closes the
   * socket (and therefore the associated streams) when the method
   * returns.
   * @param s
   *   Socket representing the client connection
   * @throws IOException
   */
  private void handleConnection(Socket s) throws IOException
  {
    try
    {
      // We expect line-oriented text input, so wrap the input stream
      // in a Scanner
      Scanner scanner = new Scanner(s.getInputStream());
      while (scanner.hasNextLine())
      {
        String line = scanner.nextLine();
        if (line.length() == 0)
        {
          break; // blank line terminates input
        }
        System.out.println(line);
      }
      System.out.println("(end of input to server)");
      
      // Now write a response to the client
      PrintWriter pw = new PrintWriter(s.getOutputStream());
      pw.println("Hello, client!");
      
      // always flush the stream
      pw.flush();      
    }
    finally
    {
      // close the connection in a finally block (closing the
      // socket closes both streams
      s.close();
    }
  }
}
