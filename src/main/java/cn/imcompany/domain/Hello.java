package cn.imcompany.domain;

import java.util.concurrent.Callable;

public class Hello {

    Runnable r1 = () -> System.out.println(this);
    Runnable r2 = () -> System.out.println(toString());

    public String toString() {
        return "Hello, world";
    }

    public static void main(String... args) {
        new Hello().r1.run();
        new Hello().r2.run();

    }

    Callable<String> helloCallable(String name) {
        String hello = "Hello";
        return () -> (hello + ", " + name);
    }
}
