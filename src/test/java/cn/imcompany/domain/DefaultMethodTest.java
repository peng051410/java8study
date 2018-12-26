package cn.imcompany.domain;

import org.junit.Test;

public class DefaultMethodTest {

    @Test
    public void testTwoMethodExist() {

        XiaoPerson xiaoPerson = new XiaoPerson();
        System.out.println(xiaoPerson.sayHi());

        DaPerson daPerson = new DaPerson();
        System.out.println(daPerson.sayHi());
    }
}
