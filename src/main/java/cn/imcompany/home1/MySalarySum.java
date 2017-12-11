package cn.imcompany.home1;

import cn.imcompany.domain.Salary;

import java.util.Arrays;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MySalarySum {

    private static char[] arr = new char[52];

    static {
        String letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        byte[] bytes = letter.getBytes();
        letter.getChars(0, bytes.length, arr, 0);
    }

    public static void main(String[] args) {

        Salary[] salaries = new Salary[10000];

        IntFunction<Salary> intFunction = i -> new Salary(generateName(), generateBase(), generateBouns());
        Arrays.setAll(salaries, intFunction);
        for (Salary salary : salaries) {
            System.out.println(salary);
        }
    }

    private static int generateBase() {

        IntStream ints = new Random().ints(1, 5, 100_0000);
        return ints.findFirst().getAsInt();
    }

    private static int generateBouns() {

        IntStream ints = new Random().ints(1, 0, 10_0000);
        return ints.findFirst().getAsInt();
    }

    private static String generateName() {

        IntStream ints = new Random().ints(5, 0, 47);
        return ints.mapToObj(i -> String.valueOf(arr[i])).collect(Collectors.joining());
    }

}
