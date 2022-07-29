package com.backstreetbrogrammer.handler;

import java.io.IOException;
import java.io.UncheckedIOException;

public class UncheckedIOExceptionConverterHandler<S> extends DecoratedHandler<S> {
    public UncheckedIOExceptionConverterHandler(final Handler<S> other) {
        super(other);
    }

    @Override
    public void handle(final S s) {
        try {
            super.handle(s);
        } catch (final IOException e) {
            // convert checked exception to unchecked exception and let the current thread terminate
            throw new UncheckedIOException(e);
        }
    }
}
