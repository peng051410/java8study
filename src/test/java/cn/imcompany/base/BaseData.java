package cn.imcompany.base;

import cn.imcompany.leetcode.LRU;
import org.junit.Test;

public class BaseData {

    private int  anInt;

    @Test
    public void testDataType() {

        byte aa = ((byte) 0xf0);
        System.out.println(aa);

        byte bb = ((byte) 0b11110000);
        System.out.println(bb);

        LRU lru = new LRU();

        System.out.println(anInt);
        anInt = 5;
    }
}
