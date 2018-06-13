package tools.server;

import java.io.IOException;
import java.net.Socket;

public class ClientConnection implements Runnable {

    @Override
    public void run() {
        Socket socket;
        try {
            socket = new Socket("localhost",2009);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
