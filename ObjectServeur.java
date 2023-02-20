import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ObjectServeur {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		int port=1286;
		  Scanner scan=new Scanner(System.in);
	    try {
	    	
	    	
	      ServerSocket ss = new ServerSocket(port);
	      System.out.println("Le serveur est en attente");
	      Socket soc = ss.accept();
	     

	     
	      ObjectInputStream in=new ObjectInputStream(soc.getInputStream());
	      ObjectOutputStream out =new ObjectOutputStream(soc.getOutputStream());
	      
	      Object chaine1 = (String)in.readObject();
	      Object chaine2 = (String)in.readObject();
	     
	    
	      
	      if (((String) chaine1).contains((String)chaine2)) {
	        out.writeObject(chaine1 +" contient "+chaine2);
	        out.flush();
	      } else {
	    	  out.writeObject(chaine1+" ne contient pas "+chaine2);
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
