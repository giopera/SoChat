package it.sochat.network.client;

import it.sochat.network.packets.Packet;
import it.sochat.network.packets.c2c.C2CMessageSend;
import it.sochat.network.packets.c2c.C2CUpdateInfo;

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
                Packet p = (Packet) in.readObject();
                logger.debug("Something is coming in");
                if(p == null)
                    return;
                logger.debug(p.toString());
            } catch (IOException | ClassNotFoundException e){
                if(e.getClass().equals(EOFException.class))
                    break;
                else
                    throw new RuntimeException(e);
            }
        }

    }

    public void handlePacket(Packet p){
        Class<?> cl = p.getPacketType();
        if(cl.equals(C2CMessageSend.class)){
            //TODO: Handle packet when GUI is available
        } else if (cl.equals(C2CUpdateInfo.class)){
            //TODO: Handle packet when GUI is available
        }

    }
}
