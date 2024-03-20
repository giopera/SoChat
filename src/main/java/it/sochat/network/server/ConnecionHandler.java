package it.sochat.network.server;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

import static it.sochat.Main.logger;

public class ConnecionHandler extends Thread {

    Socket socket;
    PrintWriter out;
    InputStream in;

    public ConnecionHandler(Socket socket) {
        this.socket = socket;
        try{
            out = new PrintWriter(socket.getOutputStream());
            in = socket.getInputStream();
        } catch (IOException ignored){

        }
    }

    @Override
    public void run() {
        while(true){
            try {
                logger.debug("Trying to read a line");
                int s = in.read();
                if(s == -1)
                    return;
                logger.debug((char) s);
            } catch (IOException e){
                throw new RuntimeException(e);
            }
        }

    }
}
