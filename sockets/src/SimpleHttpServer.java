import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Simple web server that writes a requested text file 
 * in response to a GET request from a client.
 * <p>
 * WARNING: DO NOT RUN THIS ON A PUBLIC NETWORK!
 * Clients can gain access to ALL files on the host.
 */
public class SimpleHttpServer
{  
  /**
   * Starts an instance of the server on port 2222.
   */
  public static void main(String args[])
  {   
    new SimpleHttpServer().runServer(2222);
  }

  /**
   * Basic server loop. Note this version has the following
   * potential deficiencies:
   * <ul> 
   *   <li> if an I/O error occurs, the server
   * will exit rather than attempting to re-create the 
   * server socket.
   *   <li> the server is single-threaded, that is, while
   * handling a connection, new connections cannot be 
   * accepted.
   * </ul>
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
        
        // blocks here until a client attempts to connect
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
   * Helper method for handling a client connection.  This server
   * only handles GET requests and will attempt to return the 
   * file named in the request. Closes the socket (and therefore 
   * the associated streams) when the method returns.
   * @param s
   *   Socket representing the client connection
   * @throws IOException
   */
  private void handleConnection(Socket s)
  {
    try
    {
      Scanner scanner = new Scanner(s.getInputStream());
      PrintWriter writer = new PrintWriter(s.getOutputStream());

      // first line is request
      String request = scanner.nextLine();
      System.out.println(request);
      
      // read and display remaining headers
      while (scanner.hasNextLine())
      {
        String line = scanner.nextLine();
        if (line.length() == 0)
        {
          break; // blank line is end of headers
        }
        System.out.println(line);
      }
      System.out.println("(end of headers)");
      
      // parse request
      int i = request.indexOf("GET");
      int j = request.indexOf('/', i);
      if (i == 0 && j > i + 3)
      {
         
       // strip off everything up until the first slash
        request = request.substring(j + 1);
        // strip off anything after the filename (if there 
        // is anything after the filename it is separated
        // by a space)
        j = request.indexOf(' ');
        if (j >= 0)
        {
          request = request.substring(0, j);
        }

        // if the request was just "/" we have an empty string
        if (request.equals(""))
        {
          request = ".";
        }
        
        System.out.println("File requested: " + request);       
        
        try
        {        
          File f = new File(request);
          if (f.isDirectory() || !f.exists())
          {
            writer.println("404 Not Found\r\n\r\n");
            writer.flush();
          }
          else
          {
            // copy contents of file to output stream; note we're assuming it's text
            scanner = new Scanner(f);
            while (scanner.hasNextLine())
            {
              writer.println(scanner.nextLine());
            }
            writer.flush();
          }
        }
        catch (FileNotFoundException e)
        {
          System.out.println("File not found: " + e);
          writer.println("404 Not Found\r\n\r\n");
          writer.flush();
        }
      }
      else
      {
        // This wasn't a well-formed GET request
        writer.println("400 Bad Request\r\n\r\n");
        writer.flush();
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