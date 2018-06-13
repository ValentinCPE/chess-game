package controler.controlerMultiplayer;

import tools.server.ClientConnection;

public class ChessControlerClient implements Runnable {

    @Override
    public void run() {

        ClientConnection clientConnection = new ClientConnection();

        clientConnection.run();

    }

}
