package com.backstreetbrogrammer.handler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

public class ExecutorServiceHandler<S> extends DecoratedHandler<S> {
    private final ExecutorService pool;
    private final Thread.UncaughtExceptionHandler exceptionHandler;

    public ExecutorServiceHandler(final Handler<S> other,
                                  final ExecutorService pool,
                                  final Thread.UncaughtExceptionHandler exceptionHandler) {
        super(other);
        this.pool = pool;
        this.exceptionHandler = exceptionHandler;
    }

    public ExecutorServiceHandler(final Handler<S> other,
                                  final ExecutorService pool) {
        this(other, pool,
                (t, e) -> System.out.println("uncaught: " + t + " error: " + e));
    }

    @Override
    public void handle(final S s) {
        pool.submit(new FutureTask<>(() -> {
            super.handle(s);
            return null;
        }) {
            @Override
            protected void setException(final Throwable th) {
                exceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
        });
    }
}
