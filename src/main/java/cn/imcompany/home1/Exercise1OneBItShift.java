package cn.imcompany.home1;

import java.nio.channels.SelectionKey;

public class Exercise1OneBItShift {

    public static void main(String[] args) {

        byte ba = 127;
        int bba = ba << 2;
        System.out.println(bba);

        byte bb = (byte) (ba << 2);
        System.out.println(bb);


        System.out.println(SelectionKey.OP_ACCEPT);
        System.out.println(SelectionKey.OP_CONNECT);
        System.out.println(SelectionKey.OP_READ);
        System.out.println(SelectionKey.OP_WRITE);

        //00011101
    }
}
