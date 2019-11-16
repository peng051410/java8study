package cn.imcompany.ideapro;

/**
 * Created by tomyli on 2019-08-28.
 * Github: https://github.com/peng051410
 */
public class MyServiceImpl implements MyService {

    @Override
    public void sayHello(String name) {
        System.out.println("hello");
        final MyUserV2 myUser = new MyUserV2("");
        System.out.println(myUser);
        System.out.println("hello");

    }

    @Override
    public void sayBye(String name) {

        System.out.println("format");
        new Thread(() -> System.out.println("ffffff"));
        System.out.println("hello");
        System.out.println("hello");
    }

    @Override
    public void longMethod(String name, String address, int age, float money, long bb) {

    }

    @Override
    public void test() {
        
    }

    @Override
    public void test2() {
    }

    @Override
    public String testN() {

        return null;
    }

    @Override
    public String test3() {
        return null;
    }

    @Override
    public void test4() {

    }

}
