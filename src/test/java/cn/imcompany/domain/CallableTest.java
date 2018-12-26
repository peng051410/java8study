package cn.imcompany.domain;

import org.junit.Test;

import java.util.concurrent.Callable;

public class CallableTest {

    @Test
    public void testCall() {

        Callable<Void> callable = ()->{
            System.out.println("hhee");
            Thread.sleep(1000);
            return null;
        };

        Runnable runnable = ()-> {
            System.out.println("eee");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
