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
        sets.add("fd");
        sets.add("10");

        Predicate<String> predicate = sets::contains;
        System.out.println(predicate.test("20"));

        BiPredicate<String, Integer> biPredicate = (s1, i1) -> Integer.parseInt(s1) > i1;
        System.out.println(biPredicate.test("20", 10));

        IntPredicate intPredicate = x -> x > 5;
        System.out.println(intPredicate.test(4));

        LongPredicate longPredicate = y -> y > 1000;
        System.out.println(longPredicate.test(1001));

        DoublePredicate doublePredicate = z -> z > 100.2;
        System.out.println(doublePredicate.test(100.9));

        BiPredicate<Integer, Integer> biInt = (i1, i2) -> i1 + 5 > i2;
        System.out.println(compare(biInt, 20, 15));
    }

    private static boolean compare(BiPredicate<Integer, Integer> bi, Integer i1, Integer i2) {
        return bi.test(i1, i2);
    }

    @Test
    public void testFunction() {

        int i = 10;
        Student student = new Student();
        student.setAge(new Random().nextInt(20));
        student.setName("test" + i);
        student.setSex(i % 2 == 0 ? 1 : 2);
        student.setTag("tag" + i);

        Function<Student, String> firstFunction = (Student s) -> s.getName() + "," + s.getAge();
        Function<Student, String> secondFunction = s -> s.getName() + "," + s.getSex();
        System.out.println(student.printStudent(firstFunction));
        System.out.println(student.printStudent(secondFunction));

        IntFunction<String> intFunction = Integer::toUnsignedString;
        System.out.println(intFunction.apply(20));

        DoubleToIntFunction doubleToIntFunction = x -> (int) (x + 2);
        System.out.println(doubleToIntFunction.applyAsInt(2.4));

        ToLongFunction<String> toLongFunction = Long::parseLong;
    }

    /**
     * BiFunction
     */
    @Test
    public void testBiFunction() {

        BiFunction<String, Integer, Long> biFunction = (s1, i1) -> Long.parseLong(s1) + i1;
        System.out.println(biFunction.apply("20", 10));

        BinaryOperator<String> binaryOperator = String::concat;
        System.out.println(binaryOperator.apply("abbb", "cccc"));

    }

    /**
     * BiConsumer
     */
    @Test
    public void testConsumer() {

        Consumer<Integer> sConsumer = System::exit;
        Consumer<Object[]> arrayConsumer = Arrays::sort;

        Consumer<String> stringConsumer = System.out::println;
        stringConsumer.accept("what?");

        IntConsumer intConsumer = System.out::println;
        intConsumer.accept(12);

        BiConsumer<String, Long> biConsumer = (s1, l1) -> System.out.println(s1 + l1);
        biConsumer.accept("20", 10L);

        ObjDoubleConsumer<String> objDoubleConsumer = (s, d) -> System.out.println(s + d);
        objDoubleConsumer.accept("bbb", 20);
    }

    @Test
    public void testSupplier() {

        Supplier<Integer> supplier = () -> new Random().nextInt();
        System.out.println(supplier.get());

        SunPower sunPower1 = produce(SunPower::new);
        System.out.println(sunPower1);

        Supplier<Person> personSupplier = Person::new;
        System.out.println(personSupplier.get());

        Supplier<Boolean> booleanSupplier = () -> true;
        System.out.println(booleanSupplier.get());

    }

    private static SunPower produce(Supplier<SunPower> supplier) {
        return supplier.get();
    }

    @Test
    public void testSystemMethod() {

        Set<String> knowNames = new HashSet<>();
        Predicate<String> predicate = knowNames::contains;
        System.out.println(predicate.test("haha"));

        IntFunction<int[]> array = int[]::new;
        int[] ints = array.apply(10);
        System.out.println(ints.length);

        IntFunction<long[]> longArr = long[]::new;
        long[] apply = longArr.apply(5);
        System.out.println(apply.length);

        IntFunction<Student[]> functions = Student[]::new;
        Student[] students = functions.apply(6);
        System.out.println(students.length);

        LongFunction<String> i = Long::toUnsignedString;
        System.out.println(i.apply(20));

        IntFunction<String> intFunction = Integer::toUnsignedString;
        System.out.println(intFunction.apply(100));

        BiFunction<Integer, Integer, Integer> biFunction = (a1, a2) -> a1 + a2;
        System.out.println(biFunction.apply(20, 20).intValue());

        Function<String, Integer> function = Integer::parseInt;
        System.out.println(function.apply("2000").intValue());

        Supplier<String> supplier = () -> "hasha";
        System.out.println(supplier.get());
    }

    @Test
    public void testUnaryOperator() {

        UnaryOperator<String> unaryOperator = String::toUpperCase;
        System.out.println(unaryOperator.apply("testUnary"));

        UnaryOperator<Integer> integerUnaryOperator = Integer::valueOf;
        System.out.println(integerUnaryOperator.apply(1230));

        IntUnaryOperator intUnaryOperator = Math::abs;
        System.out.println(intUnaryOperator.applyAsInt(20));

        LongUnaryOperator longUnaryOperator = Math::abs;
        System.out.println(longUnaryOperator.applyAsLong(100));

        DoubleUnaryOperator doubleUnaryOperator = Math::round;
        System.out.println(doubleUnaryOperator.applyAsDouble(10.2));
    }

}
