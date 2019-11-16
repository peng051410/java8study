package cn.imcompany.base.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysSortThread {

    /**
     * Arrays.sort中的比较器的代码与调用sort的线程是同一个吗？
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("main:" + Thread.currentThread().getName());

        String[] arr = new String[5];

        Arrays.fill(arr, "2");
        Arrays.sort(arr, Comparator.comparing(String::length));
        Arrays.sort(arr, (s1, s2) -> {
                System.out.println("sort:" + Thread.currentThread().getName());
                return Integer.compare(s1.length(), s2.length());
            });

        //Yes，线程是同一个
        List<Long> myList = new ArrayList<>();
            myList.add(1L);
            myList.add(2L);
            myList.add(3L);
            myList.add(4L);
    }
}