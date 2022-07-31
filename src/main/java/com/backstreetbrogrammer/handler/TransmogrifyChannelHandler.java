package com.backstreetbrogrammer.handler;

import com.backstreetbrogrammer.util.Util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TransmogrifyChannelHandler implements Handler<SocketChannel> {
    @Override
    public void handle(final SocketChannel sc) throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(80);
        int read = sc.read(buf);
        if (read == -1) {
            sc.close();
            return;
        }
        if (read > 0) {
            Util.transmogrify(buf);
            while (buf.hasRemaining()) {
                sc.write(buf);
            }
            // buf.compact();
        }
    }
}
