package com.backstreetbrogrammer.handler;

import java.io.IOException;

// Decorator pattern abstract superclass
public abstract class DecoratedHandler<S> implements Handler<S> {
    private final Handler<S> other;

    public DecoratedHandler(final Handler<S> other) {
        this.other = other;
    }

    @Override
    public void handle(final S s) throws IOException {
        other.handle(s);
    }
}
