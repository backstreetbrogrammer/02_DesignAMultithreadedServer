package com.backstreetbrogrammer.util;

import java.nio.ByteBuffer;

public class Util {
    public static int transmogrify(final int data) {
        return Character.isLetter(data) ? data ^ ' ' : data;
    }

    public static void transmogrify(ByteBuffer buf) {
        buf.flip();
        for (int i = 0; i < buf.limit(); i++) {
            buf.put(i, (byte) transmogrify(buf.get(i)));
        }
    }
}
