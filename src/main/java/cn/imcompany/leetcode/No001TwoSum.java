package cn.imcompany.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给一个int数组，返回数组中两个数字相加的和是目标数的下标。
 * 可以假设每个输入只有一个解决方案，并且不能使用同一个元素两次。
 * <p>
 * Created by tomyli on 2019-04-13.
 * Github: https://github.com/peng051410
 */
public class No001TwoSum {

    volatile int sum = 0;

    public static void main(String[] args) {

        System.out.println(Arrays.toString(sum2(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] sum2(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            int second = target - arr[i];
            if (map.containsKey(second)) {
                return new int[]{map.get(second), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }
}
