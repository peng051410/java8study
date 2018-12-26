package cn.imcompany.home1;

import java.util.Arrays;
import java.util.Random;

public class Exercise7DualPivotQuicksort {

    public static void main(String[] args) {
//        minLenghtSort();
//        mediumLengthSort();
        maxLengthSort();

    }

    public static void minLenghtSort() {

        //数组长度小于47，采用最左区间插入排序进行排序
        int[] arr = {1, 9, 2, 3, 49857, 32, 50, 92, 34, 2, 1, 3, 987};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mediumLengthSort() {

        //数组长度大于47且小于286，采用快速排序
        int[] arr = new Random().ints(10, 200).limit(60).toArray();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void maxLengthSort() {

        //数组长度大于286，采用归并排序
        int[] arr = new Random().ints(10, 1000).limit(500).toArray();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
