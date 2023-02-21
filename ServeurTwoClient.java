import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServeurTwoClient {
    public static void main(String[] args) throws ClassNotFoundException {
        int port = 1286;
        Scanner scan = new Scanner(System.in);
        int nbMaxClients = 2;
        int nbClients = 0;

        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Le serveur est en attente");
            while (nbClients < nbMaxClients) {
                Socket clientSocket = ss.accept();
                nbClients++;
                System.out.println("Accepted connection from client " + nbClients + ": " + clientSocket.getInetAddress());
                System.out.println("Client " + nbClients + " IP address: " + clientSocket.getInetAddress().getHostAddress());
                System.out.println("Client " + nbClients + " port: " + clientSocket.getPort());

                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

                Object chaine1 = (String) in.readObject();
                Object chaine2 = (String) in.readObject();

                if (((String) chaine1).contains((String) chaine2)) {
                    out.writeObject(chaine1 + " contient " + chaine2);
                    out.flush();
                } else {
                    out.writeObject(chaine1 + " ne contient pas " + chaine2);
                    out.flush();
                }

                in.close();
                out.close();
                clientSocket.close();
                nbClients--;
            }

            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
