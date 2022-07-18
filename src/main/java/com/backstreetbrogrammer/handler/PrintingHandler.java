package com.backstreetbrogrammer.handler;

import java.io.IOException;

public class PrintingHandler<S> implements Handler<S> {
    private final Handler<S> other;

    public PrintingHandler(final Handler<S> other) {
        this.other = other;
    }

    @Override
    public void handle(final S s) throws IOException {
        System.out.printf("Connected to %s%n", s);
        try {
            other.handle(s);
        } finally {
            System.out.printf("Disconnected from %s%n", s);
        }
    }
}
