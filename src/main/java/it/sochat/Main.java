package it.sochat;

import it.sochat.network.server.Server;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {

    public static Logger logger = LogManager.getLogger();
    public static Server server = new Server();
    public static void main(String[] args) {
        server.run();
        Socket s = null;
        logger.debug("Server Runned");
        try{
            s = new Socket("127.0.0.1", 6969);
        } catch (IOException ignored) {
            logger.error("Error in socket creation");
        }
        logger.debug("Socket created");
        if(s == null){
            return;
        }
        try {
            new PrintWriter(s.getOutputStream()).println("Ciao");
        } catch (IOException ignored) {
            logger.debug("Error with write to socket");
        }
        logger.debug("Writed to socket");
    }
}
