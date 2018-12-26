package cn.imcompany.base.chapter6;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Chapter6 {

    public static void main(String[] args) {

        AtomicLong atomicLong = new AtomicLong();
        atomicLong.incrementAndGet();

        LongAdder longAdder = new LongAdder();
        longAdder.add(2);
        System.out.println(longAdder.intValue());

        ConcurrentHashMap map = new ConcurrentHashMap<String, String>();
        ConcurrentHashMap.KeySetView<String, Boolean> strings = ConcurrentHashMap.newKeySet();
    }
}
