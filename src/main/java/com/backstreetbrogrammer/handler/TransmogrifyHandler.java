package com.backstreetbrogrammer.handler;

import com.backstreetbrogrammer.util.Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TransmogrifyHandler implements Handler<Socket> {
    @Override
    public void handle(final Socket socket) throws IOException {
        try (
                socket;
                final InputStream in = socket.getInputStream();
                final OutputStream out = socket.getOutputStream()
        ) {
            //in.transferTo(out); // default buffer size is 8192
            int data;
            while ((data = in.read()) != -1) { // read 1 byte at a time and -1 means EOF
                out.write(Util.transmogrify(data));
            }
        }
    }
}
