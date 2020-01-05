package com.ttdys108.commons.utils;

import java.util.Arrays;

/**
 * 类似stringbuilder功能
 *
 * 这个类不是线程安全的
 */
public class ByteBuilder {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private byte[] bytes;

    /**
     * 下一个byte的index
     */
    private int tail = 0;

    public ByteBuilder() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ByteBuilder(int initialCapacity) {
        this.bytes = new byte[initialCapacity];
    }

    public ByteBuilder append(byte b) {
        insureCapacity(1);
        bytes[tail] = b;
        tail++;
        return this;
    }

    public ByteBuilder append(byte[] b) {
        insureCapacity(b.length);
        System.arraycopy(b, 0, bytes, tail, b.length);
        tail += b.length;
        return this;
    }

    public byte[] toBytes() {
        return Arrays.copyOf(bytes, tail);
    }

    /**
     * 每次append前检查容量，不够的话扩大一倍
     */
    public void insureCapacity(int need) {
        int newLength = bytes.length;
        while(tail + need > newLength)
            newLength <<= 1;
        if(newLength == bytes.length) //不需要扩充
            return;
        byte[] tmp = new byte[newLength];
        System.arraycopy(bytes, 0, tmp, 0, tail);
        bytes = tmp;
    }

    public static void main(String[] args) {
        ByteBuilder bb = new ByteBuilder();
        bb.append((byte) 1);
        bb.append((byte) 3);
        bb.append((byte) 5);
        byte[] arr = new byte[] {(byte) 6,  (byte) 7,(byte) 8,(byte) 9,(byte) 10,(byte) 11,(byte) 12};
        bb.append(arr);
        byte[] res = bb.toBytes();
        for(byte i : res) {
            System.out.println(i);
        }
    }

}
