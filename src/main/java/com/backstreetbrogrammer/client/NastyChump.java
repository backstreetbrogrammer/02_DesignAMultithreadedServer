package com.backstreetbrogrammer.client;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class NastyChump {

    public static void main(final String[] args) throws InterruptedException {
        final int totalSockets = 3000;
        final Socket[] sockets = new Socket[totalSockets];
        for (int i = 0; i < sockets.length; i++) {
            try {
                sockets[i] = new Socket("localhost", 8082);
            } catch (final IOException ie) {
                ie.printStackTrace();
            }
        }
        System.out.printf("Total %d sockets connected%n", totalSockets);
        TimeUnit.SECONDS.sleep(100);
    }

}
