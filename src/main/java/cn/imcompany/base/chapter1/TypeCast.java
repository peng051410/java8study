package cn.imcompany.base.chapter1;

/**
 * Created by tomyli on 2018-12-25.
 * Github: https://github.com/peng051410
 */
public class TypeCast {

    public static void main(String[] args) {

        byte a = 127;
        int i = a << 2;
        System.out.println(i);


        int bb = 1025;
        int cc = bb << 33;
        System.out.println(cc);
    }
}
