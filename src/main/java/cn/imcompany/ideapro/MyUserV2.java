package cn.imcompany.ideapro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomyli on 2019-08-28.
 * Github: https://github.com/peng051410
 */
public class MyUserV2 implements Serializable {

    private static final long serialVersionUID = 9141152591113168654L;
    private String name;
    private int age;


    public MyUserV2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public MyUserV2(String name) {
        this.name = name;
    }

    public static String testA(String name) {

        return "MyUser.testA";
    }


    public static void main(String[] args) {
        //do it//do not
        String what = "";

        System.out.println("format");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("bb");
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        int aa = 10;
        int bb = 12;
        sum(aa, bb);

        String a = "aa";
        String b = "bb";

    }

    private static void sum(int aa, int bb) {

    }

    public static boolean myEquals(String a, String b) {

        List<Integer> list = new ArrayList<>();
        list.stream()
                .map(integer -> {
                    return 0;
                });

        /**
         * java for me
         */
        if (a.equals(b)) {
            System.out.println("equals");
            return true;
        }

        try {
            final Class<?> aa = Class.forName("aa");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        final int i = Integer.parseInt(a);

        System.out.println("not equals");
        return false;
    }
}
