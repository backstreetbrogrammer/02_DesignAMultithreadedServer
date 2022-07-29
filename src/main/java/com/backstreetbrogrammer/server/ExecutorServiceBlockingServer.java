package com.backstreetbrogrammer.server;

import com.backstreetbrogrammer.handler.ExecutorServiceHandler;
import com.backstreetbrogrammer.handler.Handler;
import com.backstreetbrogrammer.handler.PrintingHandler;
import com.backstreetbrogrammer.handler.TransmogrifyHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

public class ExecutorServiceBlockingServer {

    public static void main(final String[] args) throws IOException {
        final ServerSocket ss = new ServerSocket(8082);
        final Handler<Socket> handler =
                new ExecutorServiceHandler<>(
                        new PrintingHandler<>(
                                new TransmogrifyHandler()
                        ),
                        Executors.newFixedThreadPool(10)
                );

        while (true) {
            final Socket s = ss.accept(); // this blocks and s can never be null
            handler.handle(s);
        }
    }

}
