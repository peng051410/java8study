package cn.imcompany;

import java.util.Arrays;
import java.util.Random;
import java.util.function.UnaryOperator;

/**
 * lizp@ishugui.com
 *
 * @author tomyli 2016/11/03 09:53.
 */
public class TestJava8 {

    public static void main(String[] args) {

        Random random = new Random();

        UnaryOperator<Integer> operator = a -> random.nextInt();
        System.out.println(operator.apply(11));

        System.out.println("----------------");
        System.out.println("fffff");
        System.out.println("faasdf");

        int[] arr = new int[5];
        Arrays.setAll(arr, a -> (random.nextInt()));

        for (int i : arr) {
            System.out.println(i);
        }

    }
}
