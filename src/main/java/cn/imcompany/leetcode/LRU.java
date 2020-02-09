package cn.imcompany.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tomyli on 2020/1/23.
 * Github: https://github.com/peng051410
 */
public class LRU {

    public static void main(String[] args) {

        List<Integer> LRUList = new LinkedList<>();
        final List<Integer> list = Arrays.asList(2, 3, 4, 2, 3, 8, 1, 5, 6);
        for (Integer integer : list) {
            final int i = myLru(LRUList, integer);
            System.out.println(LRUList);
        }
    }

    public static int myLru(List<Integer> list, int queryValue) {

        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == queryValue) {
                index = i;
                break;
            }
        }

        if (index > -1) {
            list.remove(index);
            list.add(0, queryValue);
            return list.size();
        }

        if (list.size() >= 5) {
            list.remove(list.size() - 1);
        }
        list.add(0, queryValue);
        return list.size();
    }
}
