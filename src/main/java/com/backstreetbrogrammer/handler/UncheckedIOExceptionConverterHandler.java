package com.backstreetbrogrammer.handler;

import java.io.IOException;
import java.io.UncheckedIOException;

public class UncheckedIOExceptionConverterHandler<S> implements Handler<S> {
    private final Handler<S> other;

    public UncheckedIOExceptionConverterHandler(final Handler<S> other) {
        this.other = other;
    }

    @Override
    public void handle(final S s) {
        try {
            other.handle(s);
        } catch (final IOException e) {
            // convert checked exception to unchecked exception and let the current thread terminate
            throw new UncheckedIOException(e);
        }
    }
}
