package cn.imcompany.base.chapter2;

import cn.imcompany.domain.Person;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chapter2 {

    public static void main(String[] args) throws Exception {
//        System.out.println(calculateWordsCountWithLambda());
//        System.out.println(calculateWordsCount());
//        concatStream();
        terminalStream();

    }

    private static int calculateWordsCount() throws Exception {

        List<String> words = getWords();
        long start = System.currentTimeMillis();
        int count = 0;
        for (String word : words) {
            if (word.length() > 12) {
                count++;
            }
        }
        System.out.println("old:" + (System.currentTimeMillis() - start));
        return count;
    }

    private static long calculateWordsCountWithLambda() throws Exception {
        List<String> words = getWords();

        long start = System.currentTimeMillis();
        long count = words.stream().filter(s -> s.length() > 12).count();
        System.out.println("new:" + (System.currentTimeMillis() - start));
        return count;
    }

    private static void baseUsage() {

        Stream<String> empty = Stream.empty();

        Stream<Integer> integerStream = Stream.generate(() -> 123);
        Stream<Random> randomStream = Stream.generate(Random::new);

        Stream<Integer> intIterate = Stream.iterate(0, i -> i + 5);
        Stream<BigInteger> bigIntegerStream = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
    }

    public static Stream<Character> characterStream(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    public static void concatStream() {
        Stream<Character> combinedStream = Stream.concat(characterStream("hello"), characterStream("world"));
        combinedStream.forEach(System.out::println);
    }

    private static void terminalStream() throws Exception {
        List<String> words = getWords();

        Optional<String> any = words.stream()
                .filter(s -> s.startsWith("T"))
                .findFirst();
        any.ifPresent(System.out::println);
        String sElse = any.orElse("");
        System.out.println(sElse);
        any.orElseGet(() -> "1233");
        any.orElseThrow(() -> new RuntimeException("throw eeee"));

        boolean match = words.stream().anyMatch(s -> s.startsWith("H"));
        System.out.println(match);


    }

    private static List<String> getWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("/Users/tomyli/github/java8study/src/main/java/cn/imcompany/base/chapter2/chapter.txt")), StandardCharsets.UTF_8);
        return Arrays.asList(contents.split("[\\P{L}]+"));
    }

    private static void optionalCheck() {

        Optional<String> optionalS = Optional.of("12313");
        Optional<Object> empty = Optional.empty();
        Optional<Integer> integer = Optional.ofNullable(123);

    }

    private static void collectStream() throws Exception {
        List<String> words = getWords();
        words.stream().collect(Collectors.toSet());
        words.stream().collect(Collectors.toCollection(TreeSet::new));
        words.stream().collect(Collectors.joining());

        Random random = new Random();
        List<Person> personList = random.ints(1, 5).mapToObj(i -> new Person("test", i)).collect(Collectors.toList());

        Map<Integer, String> integerStringMap = personList.stream().collect(Collectors.toMap(Person::getAge, Person::getName));
        Map<Integer, Person> personMap = personList.stream().collect(Collectors.toMap(Person::getAge, Function.identity()));
    }

    private static void typeStream() {

        Stream<Integer> integerStream = IntStream.range(0, 10).boxed();
    }
}
