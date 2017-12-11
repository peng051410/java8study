package cn.imcompany.home1;

public class OneArray {

    public static void main(String[] args) {

        byte[][] bytes = new byte[10240][10240];
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j < bytes[i].length; j++) {
                bytes[i][j] = ((byte) (i + j));
            }
        }

        int result = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j < bytes[i].length; j++) {
                result += bytes[i][j];
            }
        }
        System.out.println("row:" + (System.currentTimeMillis() - start) + ",result:" + result);

        int result1 = 0;
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j < bytes[i].length; j++) {
                result1 += bytes[j][i];
            }
        }
        System.out.println("column" + (System.currentTimeMillis() - start1) + ",result:" + result1);
    }
}
