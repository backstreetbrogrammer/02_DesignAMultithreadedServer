package com.backstreetbrogrammer.singlethreadedblockingserver;

import com.backstreetbrogrammer.handler.Handler;
import com.backstreetbrogrammer.handler.PrintingHandler;
import com.backstreetbrogrammer.handler.TransmogrifyHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedBlockingServer {

    public static void main(final String[] args) throws IOException {
        final ServerSocket ss = new ServerSocket(8080);
        final Handler<Socket> handler = new PrintingHandler<>(
                new TransmogrifyHandler()
        );

        while (true) {
            final Socket s = ss.accept(); // this blocks and s can never be null
            handler.handle(s);
        }
    }

}
