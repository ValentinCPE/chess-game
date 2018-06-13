package controler.controlerMultiplayer;

import tools.server.ServerSettings;

import java.io.IOException;

public class ChessControlerServer implements Runnable {

    @Override
    public void run() {
        try {

            ServerSettings serverSettings = new ServerSettings();

            serverSettings.initServer();

        } catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }

}
