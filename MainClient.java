import java.net.*;
import java.util.Scanner;
import java.io.*;



public class MainClient {
  public static void main(String[] args) {
	  int port=1222;
  	String host="localhost";
  	Scanner scan=new Scanner(System.in);
    try {
    System.out.print("donner la chaine 1:");
    String chaine1=scan.next();
    	
    System.out.print("donner la chaine 2:");
    String chaine2=scan.next();
    
    InetAddress adr=InetAddress.getByName(host);
    	
      Socket socket = new Socket(adr, port);
      
      InputStreamReader reader=new InputStreamReader(socket.getInputStream());
      BufferedReader in = new BufferedReader(reader);
      PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
      BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

      String clientInput = console.readLine();
      out.println(chaine1+" "+ clientInput);
      out.println(chaine2+" "+ clientInput);
      out.flush();

      String serverResponse = in.readLine();
      
      System.out.println("mon adress client:"+socket.getLocalAddress()+" "+socket.getLocalPort());      
      System.out.println("mon adress serveur:"+socket.getInetAddress()+" "+socket.getPort());
      System.out.println("Server Response: " +serverResponse);
     
      socket.close();
      
    } catch (UnknownHostException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
  }
}