package cn.imcompany.domain;

import org.junit.Test;

import java.util.stream.IntStream;

public class PersonTest {


    @Test
    public void testIterate() {

        for (int i = 0; i < 7; i++) {
            System.out.println(i);
        }

        IntStream intStream = IntStream.iterate(0, e -> e + 1).limit(7);
        intStream.forEach(System.out::println);

//        IntStream intStream = IntStream.iterate(0, e -> e - 1).limit(7);
    }
}
