package cn.imcompany.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Created by tomyli on 2019-09-23.
 * Github: https://github.com/peng051410
 */
public class CollectionsStudy {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> list1 = Arrays.asList(4, 5, 6, 7, 8);
        final List<List<Integer>> lists = zip(list, list1);
        System.out.println(lists);

        final String s = "abc";
        System.out.println(containsOnlySubstringsEfficient(s));
        System.out.println((s + s).indexOf(s, 1));

    }

    public static boolean containsOnlySubstringsEfficient(String string) {
        return ((string + string).indexOf(string, 1) != string.length());
    }

    /**
     * like python zip
     *
     * @param list
     * @param list1
     * @return
     */
    private static List<List<Integer>> zip(List<Integer> list, List<Integer> list1) {
        return listAll(list, list1, (i1, i2) -> Arrays.asList(i1, i2));
    }

    public static <T, U, R> List<R> listAll(List<T> list, List<U> list1, BiFunction<T, U, R> biFunction) {

        List<R> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(biFunction.apply(list.get(i), list1.get(i)));
        }
        return result;
    }


}
