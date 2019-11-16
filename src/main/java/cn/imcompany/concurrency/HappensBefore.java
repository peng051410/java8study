package cn.imcompany.concurrency;

/**
 * Created by tomyli on 2019-06-06.
 * Github: https://github.com/peng051410
 */
public class HappensBefore {

    private static int value = 0;
    private static boolean isValid = false;

    public static void main(String[] args) {

        final Thread thread = new Thread(() -> {
            if (isValid) {
                System.out.println(value);
            }
        });

        thread.start();
        
        isValid = true;
        value = 10;


    }

}
