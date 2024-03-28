package it.sochat.network.client;

import it.sochat.Main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ConnectionAccepter {
    ServerSocket server;

    ArrayList<ConnectionHandler> activeHandlers = new ArrayList<>();

    public ConnectionAccepter(){
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
                    addHandler(new ConnectionHandler(s)).start();
            }
        }).start();
        Main.logger.debug("run() exit");
    }

    public synchronized ConnectionHandler addHandler(ConnectionHandler h){
        activeHandlers.add(h);
        return h;
    }
}
