package it.sochat;

import it.sochat.network.client.ConnectionAccepter;
import it.sochat.network.packets.c2c.C2CMessageSend;
import it.sochat.objects.ByteBuffer;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.Arrays;

public class Main {

    public static Logger logger = LogManager.getLogger();
    public static ConnectionAccepter connectionAccepter = new ConnectionAccepter();
    public static void main(String[] args) {
        /*
        connectionAccepter.run();
        Socket s = null;
        logger.debug("Server Runned");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            s = new Socket("127.0.0.1", 6969);
        } catch (IOException ignored) {
            logger.error("Error in socket creation");
            return;
        }
        logger.debug("Socket created");
        try {
            ObjectOutputStream writer = new ObjectOutputStream(s.getOutputStream());
            writer.writeObject(new C2CMessageSend("Ciao", new Timestamp(System.currentTimeMillis())));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                logger.error("Error in timed wait");
                return;
            }
            writer.close();
        } catch (IOException ignored) {
            logger.error("Error with write to socket");
            return;
        }
        logger.debug("Wrote to socket");

         */

        ByteBuffer b = new ByteBuffer(new C2CMessageSend());
        b.addTimestamp(new Timestamp(System.currentTimeMillis()));
        System.out.println(System.currentTimeMillis());
        System.out.println(new Timestamp(System.currentTimeMillis()));
        System.out.println(Arrays.toString(b.getByteArr()));
        System.out.println(b.getTimestamp(0));
    }
}
