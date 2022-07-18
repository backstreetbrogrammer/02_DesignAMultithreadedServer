package com.backstreetbrogrammer.handler;

public class ThreadedHandler<S> extends UncheckedIOExceptionConverterHandler<S> {
    public ThreadedHandler(final Handler<S> other) {
        super(other);
    }

    @Override
    public void handle(final S s) {
        new Thread(() -> super.handle(s)).start();
    }
}
