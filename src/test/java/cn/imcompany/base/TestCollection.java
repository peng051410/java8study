package cn.imcompany.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCollection {

    @Test
    public void testRetainAll() {

        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("bbb");
        list.add("ccc");
        list.add("dddd");

        List<String> list2 = new ArrayList<>();
        list2.add("aaaa");
        list2.add("cccd");

        System.out.println(list.retainAll(list2));
        System.out.println(list);
    }

    @Test
    public void testStream() {


    }

}
