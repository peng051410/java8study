package cn.imcompany.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tomyli on 2019-07-01.
 * Github: https://github.com/peng051410
 */
public class LockDemo {

    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    private static List<Long> notEmpty = new ArrayList<>();
    private static List<Long> notFull = new ArrayList<>();

    public static void main(String[] args) {

    }
    public static void add() {
        if (notEmpty.isEmpty()) {
//            condition.await();
        }
    }
}
