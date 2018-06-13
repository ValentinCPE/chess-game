package tools.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSettings {

    public void initServer() throws IOException {

        ServerSocket socket;

        socket = new ServerSocket(2009);

        Thread t = new Thread(new Accepter_clients(socket));

        t.start();

    }

    class Accepter_clients implements Runnable {


        private ServerSocket socketserver;

        private Socket socket;

        private int nbrclient = 1;

        public Accepter_clients(ServerSocket s){

            socketserver = s;

        }

        public void run() {
            try {
                while(true){
                    socket = socketserver.accept(); // Un client se connecte on l'accepte
                    System.out.println("Le client numéro "+nbrclient+ " est connecté !");
                    nbrclient++;
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
