package cn.imcompany.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {


    @Test
    public void testMethod() {

        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        list.stream()
                .filter(s -> s.startsWith("a"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }

    @Test
    public void testStream() {

        Stream<String> stream = Stream.of("aaa", "bbb", "ccc");
        stream.findFirst().ifPresent(System.out::println);

        IntStream.range(0, 10).forEach(System.out::println);

        Arrays.stream(new int[]{1, 2, 3})
                .map(i -> i * 2 + 1)
                .forEach(System.out::println);
    }

    @Test
    public void testStream2() {
        Stream.of("a1", "a2", "a3")
                .filter(s -> s.startsWith("a"))
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .forEach(System.out::println);
    }

    @Test
    public void testStream3() {

        Stream.of(
                new Person("Pa", 11),
                new Person("ab", 12),
                new Person("Pfaf", 13),
                new Person("Pab", 14)
        ).filter(p -> p.getName().startsWith("P"))
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)
                .ifPresent(System.out::println);
    }

    @Test
    public void testStream4() {

        Person result = Stream.of(
                new Person("a1", 21),
                new Person("a1333", 23),
                new Person("a434", 25),
                new Person("b12342", 24)
        ).reduce(new Person("", 0), (p1, p2) -> {
            p1.setAge(p1.getAge() + p2.getAge());
            p1.setName(p1.getName() + p2.getName());
            return p1;
        });
        System.out.println(result);
    }

    @Test
    public void testStream5() {

        Integer ageSum = Stream.of(
                new Person("a1", 21),
                new Person("a1333", 23),
                new Person("a434", 25),
                new Person("b12342", 24)
        ).reduce(0,
                (sum, p) -> sum += p.getAge(),
                (sump1, sump2) -> sump1 + sump2
        );
        System.out.println(ageSum);
    }

    @Test
    public void testStream6() {

        List<Person> personList = Arrays.asList(
                new Person("a1", 21),
                new Person("a1333", 23),
                new Person("a434", 25),
                new Person("b12342", 24)
        );

        double asDouble = personList.stream()
                .filter(p -> p.getAge() > 22)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
        System.out.println(asDouble);
    }

    @Test
    public void testStreamStream() {

        Supplier<Runnable> c = () -> () -> System.out.println("hi");
        c.get().run();

    }

}
