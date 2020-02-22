package cn.imcompany.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tomyli on 2020/2/21.
 * Github: https://github.com/peng051410
 */
public class MyMultiply {

    private static Map<Integer, Integer> map = new HashMap<>();

    private static int doMultip(int a, int b) {

        if (a == 1) {
            return b;
        }

        if (b == 1) {
            return a;
        }
        
        final int result = a + doMultip(a, b - 1);
        if (map.containsKey(b)) {
            return map.get(b);
        } else {
            map.put(b, result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(doMultip(4, 1112));
        System.out.println(map);
    }
}
