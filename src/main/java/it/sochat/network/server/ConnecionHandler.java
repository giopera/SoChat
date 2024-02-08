package it.sochat.network.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static it.sochat.Main.logger;

public class ConnecionHandler extends Thread {

    Socket socket;
    PrintWriter out;
    Scanner in;

    public ConnecionHandler(Socket socket) {
        this.socket = socket;
        try{
            out = new PrintWriter(socket.getOutputStream());
            in = new Scanner(socket.getInputStream());
        } catch (IOException ignored){

        }
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
                if(!in.hasNextLine())
                    continue;
                logger.debug("Trying reading line");
                String s = in.nextLine();
                if(s != null)
                    System.out.print(s);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
