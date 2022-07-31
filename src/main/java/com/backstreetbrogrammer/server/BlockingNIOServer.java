package com.backstreetbrogrammer.server;

import com.backstreetbrogrammer.handler.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.Executors;

public class BlockingNIOServer {

    public static void main(final String[] args) throws IOException {
        final ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(8083));
        final Handler<SocketChannel> handler =
                new ExecutorServiceHandler<>(
                        new PrintingHandler<>(
                                new BlockingChannelHandler(
                                        new TransmogrifyChannelHandler()
                                )
                        ),
                        Executors.newFixedThreadPool(10)
                );

        while (true) {
            final SocketChannel s = ssc.accept(); // never null
            handler.handle(s);
        }
    }

}
