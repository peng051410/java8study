package cn.imcompany.home1;

import cn.imcompany.domain.Salary;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise4MySalarySum {

    private static char[] arr = new char[52];

    static {
        String letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        byte[] bytes = letter.getBytes();
        letter.getChars(0, bytes.length, arr, 0);
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        junwenRealize();
        System.out.println(System.currentTimeMillis() - start);

        long start1 = System.currentTimeMillis();
        myRealize();
        System.out.println(System.currentTimeMillis() - start1);

    }

    private static void myRealize() {

        Salary[] salaries = new Salary[10000];

        IntFunction<Salary> intFunction = i -> new Salary(generateName(), generateBase(), generateBonus(), 0);
        Arrays.setAll(salaries, intFunction);

        Arrays.stream(salaries)
                .map(salary -> new Salary(salary.getName(), salary.getBaseSalary(), salary.getBonus(),
                        salary.getBaseSalary() * 13 + salary.getBonus()))
                .sorted(Comparator.comparing(Salary::getTotalSalary).reversed()).limit(10)
                .forEach(salary -> System.out.println("name:" + salary.getName() + "," + salary.getTotalSalary()));
    }

    private static void junwenRealize() {

        String format = "%s:%d%n";
        Random random = new Random(550);
        random.ints(50, 1000 + 1)
                .mapToObj(i -> {
                    ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
                    return new Salary(
                            (threadLocalRandom.nextInt(10000, 100000 + 1) + "  ").substring(0, 5),
                            i / 10,
                            threadLocalRandom.nextInt(0, 100000 + 1) / 10000, 0L);
                })
                .map(salary -> new Salary(salary.getName(), salary.getBaseSalary(), salary.getBonus(),
                        salary.getBaseSalary() * 13 + salary.getBonus())
                )
                .limit(10000)
                .sorted((x, y) -> Long.compare(y.getTotalSalary(), x.getTotalSalary()))
                .limit(10)
//                .forEach(k-> System.out.format(format, k.getName(), k.getTotalSalary()));
                .forEachOrdered(k -> System.out.format(format, k.getName(), k.getTotalSalary()));
    }

    private static int generateBase() {

        IntStream ints = new Random().ints(1, 5, 100_0000);
        return ints.findFirst().orElse(-1);
    }

    private static int generateBonus() {

        IntStream ints = new Random().ints(1, 0, 10_0000);
        return ints.findFirst().orElse(-1);
    }

    private static String generateName() {

        IntStream ints = new Random().ints(5, 0, 47);
        return ints.mapToObj(i -> String.valueOf(arr[i])).collect(Collectors.joining());
    }

}
