import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class DataServeur {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port=1222;
		  Scanner scan=new Scanner(System.in);
	    try {
	    	
	    	
	      ServerSocket ss = new ServerSocket(port);
	      System.out.println("Le serveur est en attente");
	      Socket soc = ss.accept();
	      
	     

	      DataInputStream in=new DataInputStream(soc.getInputStream());
	      DataOutputStream out=new DataOutputStream(soc.getOutputStream());
	      
	      
	      String chaine1 = in.readUTF();
	      String chaine2 = in.readUTF();
	     
	    
	      
	      if (chaine1.contains(chaine2)) {
	        out.writeUTF(chaine1 +" contient "+chaine2);
	        out.flush();
	      } else {
	    	  out.writeUTF(chaine1+" ne contient pas "+chaine2);
	        out.flush();
	      }
	      
	      System.out.println("Accepted connection from " + soc.getInetAddress());
          System.out.println("Client IP address: " + soc.getInetAddress().getHostAddress());
          System.out.println("Client port: " + soc.getPort());
	      
	      ss.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	}


