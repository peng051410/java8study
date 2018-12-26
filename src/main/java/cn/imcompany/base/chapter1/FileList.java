package cn.imcompany.base.chapter1;

import cn.imcompany.domain.RunnableEx;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FileList {

    public static void main(String[] args) {

        listFile("/Users/tomyli/work/dz", "sql");
        exercise5();

        new Thread(andThen(
                () -> System.out.println("1."),
                () -> System.out.println("2.")
        )).start();

        exercise8();
    }

    private static void listFile(String fileName, String suffix) {

        File file = new File(fileName);
        if (file.isDirectory()) {
            System.out.println(fileName);
            System.out.println(suffix);
            String[] list = file.list((lfile, name) -> lfile.isFile() && name.endsWith(suffix));

            Arrays.stream(list).forEach(System.out::println);
        }

    }

    private static void fileArray() {

        File[] files = new File[10];
        for (int i = 0; i < files.length; i++) {
            files[i] = new File("11111" + i);
        }
//        Arrays.sort(files, (File f1, File f2) -> {
//            if ((f1.isDirectory() && f2.isDirectory()) || f1.isFile() && f2.isFile()) {
//                return f1.getPath().compareTo(f2.getPath());
//            }
//        });

    }

    private static void exercise5() {

        Runnable runnable = () -> System.out.println(1);
        new Thread(runnable).start();

        new Thread(uncheck(() -> {
            System.out.println("Zzzzz!!");
            Thread.sleep(2000);
            System.out.println("!!!!!");
        })).start();

    }

    private static Runnable uncheck(RunnableEx runner) {

        return () -> {
            try {
                runner.run();
            } catch (Exception e) {
                System.out.println(e);
            }
        };
    }

    //exercise7
    private static Runnable andThen(Runnable r1, Runnable r2) {

        return () -> {
            r1.run();
            r2.run();
        };
    }

    //exercise8
    private static void exercise8() {
        String[] names = {"peter", "paul", "mary"};
        List<Runnable> runners = new ArrayList<>();
        for (String name : names) {
            runners.add(() -> System.out.println(name));
        }

        for (Runnable runner : runners) {
            new Thread(runner).start();
        }

    }

    //exercise9
    interface Collection2<T> extends Collection<T> {
        default void forEachIf(Consumer<T> action, Predicate<T> filter) {
            forEach(
                    e -> {
                        if (filter.test(e)) {
                            action.accept(e);
                        }
                    }
            );
        }
    }

    private static void exercise9() {
        Predicate<String> predicate = s -> s.length() > 5;
    }

    private static void testCount() {

    }

}
