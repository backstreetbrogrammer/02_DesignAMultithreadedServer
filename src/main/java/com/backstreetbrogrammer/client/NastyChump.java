package com.backstreetbrogrammer.client;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class NastyChump {

    public static void main(final String[] args) throws IOException, InterruptedException {
        final int totalSockets = 10000;
        final Socket[] sockets = new Socket[totalSockets];
        for (int i = 0; i < sockets.length; i++) {
            sockets[i] = new Socket("localhost", 8081);
        }
        System.out.printf("Total %d sockets connected%n", totalSockets);
        TimeUnit.SECONDS.sleep(100);
    }

}
