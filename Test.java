import java.util.*;
import java.io.*;
import java.net.*;

public class Test {

    public static void main(String[] args){
	Socket s = null;
        try{
            s = new Socket("127.0.0.1", 6969);
        } catch (IOException ignored) {
            System.err.println("Error in socket creation");
        }
        System.out.println("Socket created");
        if(s == null){
            return;
        }
        try {
            PrintWriter writer = new PrintWriter(s.getOutputStream());
            writer.println("Ciao");
	    Thread.sleep(10000);
	    writer.close
        } catch (IOException ignored) {
            System.err.println("Error with write to socket");
        } catch (InterruptedException e) {
	    e.printStackTrace();
	}

        System.out.println("Wrote to socket");
    }
}
