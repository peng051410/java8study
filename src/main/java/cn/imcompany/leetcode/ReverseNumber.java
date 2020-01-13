package cn.imcompany.leetcode;

/**
 * Created by tomyli on 2020/1/6.
 * Github: https://github.com/peng051410
 */
public class ReverseNumber {

    public static int reverse(int x) {

        int res = 0;
        while (x != 0) {

            int pop = x % 10;
            x = x / 10;

            if ((res > (Integer.MAX_VALUE / 10)) || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if ((res < (Integer.MIN_VALUE / 10)) || (res == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            res = res * 10 + pop;

        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(reverse(-123));
        System.out.println(Integer.MAX_VALUE / 10);
        System.out.println(Integer.MAX_VALUE);
    }
}
