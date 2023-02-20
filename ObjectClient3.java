import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ObjectClient3 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		int port=1286;
	  	String host="localhost";
	  	Scanner scan=new Scanner(System.in);
	    try {
	    	
	    System.out.print("donner la chaine 3:");
		String chaine3=scan.next();	
	    	
	    System.out.print("donner la chaine 4:");
	    String chaine4=scan.next();
	    
	    InetAddress adr=InetAddress.getByName(host);
	    	
	    Socket socket = new Socket(adr, port);
	    //le flux envoye par le client
	    ObjectOutputStream out2=new ObjectOutputStream(socket.getOutputStream());
	    
	    out2.writeObject(chaine3);
	    out2.writeObject(chaine4);
	    
	    //recuper le flux envoye par le serveur
	    ObjectInputStream in2=new ObjectInputStream(socket.getInputStream());
	    
	    String clientInput = (String)in2.readObject();
	    System.out.println(clientInput);
	   out2.flush();

	    System.out.println("Server IP address: " + socket.getInetAddress().getHostAddress());
        System.out.println("Client IP address: " + InetAddress.getLocalHost().getHostAddress());
        System.out.println("Client port: " + socket.getLocalPort());
	     
	    socket.close();
	      
	    } catch (UnknownHostException e) {
	        e.printStackTrace();
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	}

}
