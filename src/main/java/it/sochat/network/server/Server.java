package it.sochat.network.server;

import it.sochat.Main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket server;

    public Server(){
        try {
            server = new ServerSocket(6969);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void run(){
        Main.logger.debug("Server Run()");
        new Thread(() -> {
            while(true){
                Main.logger.debug("Server probe");
                Socket s = null;
                try {
                    s = server.accept();
                } catch (IOException ignored) {}
                if(s != null)
                    new ConnecionHandler(s).start();
            }
        }).start();
        Main.logger.debug("run() exit");
    }
}
