package cn.imcompany.base;

import org.junit.Test;

public class BaseData {

    @Test
    public void testDataType() {

        byte aa = ((byte) 0xf0);
        System.out.println(aa);

        byte bb = ((byte) 0b11110000);
        System.out.println(bb);
    }
}
