import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DataClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	    //le flux envoye par le client
	    DataOutputStream out=new DataOutputStream(socket.getOutputStream());
	    
	    out.writeUTF(chaine1);
	    out.writeUTF(chaine2);
	    
	    //recuper le flux envoye par le serveur
	    DataInputStream in=new DataInputStream(socket.getInputStream());
	    String clientInput = in.readUTF();
	    System.out.println(clientInput);
	    out.flush();

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
