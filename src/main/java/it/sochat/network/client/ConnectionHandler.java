package it.sochat.network.client;

import it.sochat.network.packets.Packet;

import java.io.*;
import java.io.ObjectInputFilter.Status;
import java.net.Socket;

import static it.sochat.Main.logger;

public class ConnectionHandler extends Thread {

    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;

    public ConnectionHandler(Socket socket) {
        this.socket = socket;
        try{
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ignored){

        }
    }

    @Override
    public void run() {
        while(true){
            try {
                Packet s = (Packet) in.readObject();
                logger.debug("Something is coming in");
                if(s == null)
                    return;
                logger.debug(s.toString());
            } catch (IOException | ClassNotFoundException e){
                if(e.getClass().equals(EOFException.class))
                    break;
                else
                    throw new RuntimeException(e);
            }
        }

    }

    public void handlePacket(){

    }
}
