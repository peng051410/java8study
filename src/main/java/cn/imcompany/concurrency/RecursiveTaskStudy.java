package cn.imcompany.concurrency;

import java.util.concurrent.RecursiveTask;

/**
 * Created by tomyli on 2019-05-06.
 * Github: https://github.com/peng051410
 */
public class RecursiveTaskStudy {

    public static void main(String[] args) {

    }

    static class MyTask extends RecursiveTask<Long> {

        @Override
        protected Long compute() {
            return null;
        }
    }
}
