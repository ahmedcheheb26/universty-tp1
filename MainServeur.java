
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MainServeur{
  public static void main(String[] args) {
	  int port=1222;
	  Scanner scan=new Scanner(System.in);
	  
    try {
    	
    	
      ServerSocket ss = new ServerSocket(port);
      System.out.println("Le serveur est en attente");
      Socket soc = ss.accept();
      
      InputStreamReader reader=new InputStreamReader(soc.getInputStream());
      BufferedReader in = new BufferedReader(reader);
      PrintWriter out = new PrintWriter(soc.getOutputStream(),true);

  
      String chaine1 = in.readLine();
      String chaine2 = in.readLine();
      
      if (chaine1.contains(chaine2)) {
        out.println(chaine1 +" contient "+chaine2);
        out.flush();
      } else {
    	  
        out.println(chaine1+"ne contient pas "+chaine2);
        out.flush();
      }
      System.out.println("adresses client:"+soc.getRemoteSocketAddress());
      System.out.println("mon adress:"+soc.getLocalAddress()+" "+soc.getLocalPort());
      
      ss.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}