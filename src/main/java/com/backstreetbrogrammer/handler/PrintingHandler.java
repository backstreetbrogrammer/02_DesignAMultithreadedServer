package com.backstreetbrogrammer.handler;

import java.io.IOException;

public class PrintingHandler<S> extends DecoratedHandler<S> {
    public PrintingHandler(final Handler<S> other) {
        super(other);
    }

    @Override
    public void handle(final S s) throws IOException {
        System.out.printf("Connected to %s%n", s);
        try {
            super.handle(s);
        } finally {
            System.out.printf("Disconnected from %s%n", s);
        }
    }
}
