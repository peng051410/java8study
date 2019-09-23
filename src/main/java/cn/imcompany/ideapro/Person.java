package cn.imcompany.ideapro;


/**
 * Created by tomyli on 2019-09-05.
 * Github: https://github.com/peng051410
 */
public class Person {

    private String name;
    public String age;

    public String getName() {
        return name;
    }

    public Person setName(String name) throws ClassNotFoundException {

        new MyServiceImpl().test2();
        Class.forName("");
        boolean aa = true;
        this.name = name;
    }

    public static void main(String[] args) {

        new Thread(() -> {

        });
    }
}

