import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Simple example of an http client that sends a single
 * GET request for a file.  It reads the result
 * from the server as text and displays it (including
 * response headers, if any).  To try with Example 1
 * (see below), start up SimpleHttpServer first.
 */
public class SimpleHttpClient
{
  /**
   * Starts the client and performs a single request.
   * @param args
   *   path to the resource to be retrieved.  Optional;
   *   defaults to /testdoc.txt
   */
  public static void main(String[] args)
  {
    // Example 1 - download a text file that we know is in a local directory
    //String host = "localhost";
    //int port = 2222;    
    //String path = "/src/SimpleServer.java";
    
    // Example 2 - download the html text of Steve's homepage
    String host = "www.cs.iastate.edu";
    int port = 80;   
    String path = "/~smkautz/homepage.html";
    
    if (args.length > 0)
    {
      path = args[0];
    }
    
    Socket s = null;
    try
    {
      // open a connection to the server
      s = new Socket(host, port);
      
      // for line-oriented output we use a PrintWriter
      PrintWriter pw = new PrintWriter(s.getOutputStream());
      pw.print("GET " + path + " HTTP/1.0\r\n");
      pw.print("\r\n");
      pw.flush(); 
      
      // Read response from server.  Note we're
      // assuming everything will be text, and we're just printing it
      // on the screen
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
      try
      {
        s.close();
      }
      catch (IOException ignore){}
    }
  }
}
