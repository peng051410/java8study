package cn.imcompany.base.chapter1;

import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by tomyli on 2018-12-21.
 * Github: https://github.com/peng051410
 */
public class TestIntegerCompare {


    public static void main(String[] args) {

        List<MyAccount> myAccounts = Stream.of(new MyAccount(12, 2), new MyAccount(13, 2), new MyAccount(8, 3))
                .sorted(Comparator.comparing(MyAccount::getLevel).reversed()
                        .thenComparing(MyAccount::getAge).reversed())
                .collect(Collectors.toList());
        System.out.println(myAccounts);

        List<Integer> list = Stream.of(12000, 1999, 333333, 234454).collect(Collectors.toList());

        list.sort(Integer::compare);
        System.out.println(list);

        List<Integer> list1 = Stream.of(12000, 1999, 333333, 234454).collect(Collectors.toList());

        List<Integer> list2 = list1.stream().sorted((o1, o2) -> Integer.compare(o2, o1)).collect(Collectors.toList());
        System.out.println(list2);
    }

    static class MyAccount {

        private int age;
        private int level;

        MyAccount(int age, int level) {
            this.age = age;
            this.level = level;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", MyAccount.class.getSimpleName() + "[", "]")
                    .add("age=" + age)
                    .add("level=" + level)
                    .toString();
        }
    }

}
