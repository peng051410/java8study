package cn.imcompany.leetcode;

/**
 * Created by tomyli on 2020/1/13.
 * Github: https://github.com/peng051410
 */
public class Palindrome {

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        if (x % 10 == 0 && x != 0) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;

    }

    public static void main(String[] args) {
        final boolean palindrome = new Palindrome().isPalindrome(11);
        System.out.println(palindrome);
    }
}
