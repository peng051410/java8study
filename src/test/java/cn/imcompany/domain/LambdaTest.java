package cn.imcompany.domain;


import org.junit.Test;

import java.util.*;
import java.util.function.*;

public class LambdaTest {

    @Test
    public void test() {

        List<Integer> list = Arrays.asList(100, 200, 300, 400, 500);
        Integer result = list.stream().filter(i -> i > 100).map(i -> i * 2 - 1)
                .reduce(0, (sum, a) -> sum += a);

        System.out.println(result);
    }

    @Test
    public void testList() {

        Student[] students = new Student[20];

        for (int i = 0; i < 20; i++) {
            Student student = new Student();
            student.setAge(new Random().nextInt(20));
            student.setName("test" + i);
            student.setSex(i % 2 == 0 ? 1 : 2);
            student.setTag("tag" + i);
            students[i] = student;
        }

        Arrays.sort(students, Comparator.comparingInt(Student::getAge));
        Arrays.stream(students).forEach(s -> {
            System.out.println(s.getAge());
        });

    }

    @Test
    public void testPredicate() {

        Set<String> sets = new HashSet<>();
        sets.add("10");

        Predicate<String> predicate = sets::contains;
        System.out.println(predicate.test("20"));
    }

    @Test
    public void testPrint() {

        int i = 10;
        Student student = new Student();
        student.setAge(new Random().nextInt(20));
        student.setName("test" + i);
        student.setSex(i % 2 == 0 ? 1 : 2);
        student.setTag("tag" + i);

        Function<Student, String> firstFunction = s -> s.getName() + "," + s.getAge();
        Function<Student, String> secondFunction = s -> s.getName() + "," + s.getSex();
        System.out.println(student.printStudent(firstFunction));
        System.out.println(student.printStudent(secondFunction));
    }

    @Test
    public void testSystemMethod() {

        Consumer<Integer> sConsumer = System::exit;
        Consumer<Object[]> arrayConsumer = Arrays::sort;

        Set<String> knowNames = new HashSet<>();
        Predicate<String> predicate = knowNames::contains;
        System.out.println(predicate.test("haha"));

        IntFunction<int[]> array = int[]::new;
        int[] ints = array.apply(10);
        System.out.println(ints.length);

        IntFunction<long[]> longArr= long[]::new;
        long[] apply = longArr.apply(5);
        System.out.println(apply.length);

        IntFunction<Student[]> functions = Student[]::new;
        Student[] students = functions.apply(6);
        System.out.println(students.length);

        LongFunction<String> i = Long::toUnsignedString;
        System.out.println(i.apply(20));

        IntFunction<String> intFunction = Integer::toUnsignedString;
        System.out.println(intFunction.apply(100));
    }
}
