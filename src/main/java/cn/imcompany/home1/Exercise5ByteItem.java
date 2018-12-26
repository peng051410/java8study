package cn.imcompany.home1;

import cn.imcompany.domain.ByteStore;
import cn.imcompany.domain.ByteStore2;
import cn.imcompany.domain.MyItem;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise5ByteItem {

    public static void main(String[] args) {

        ByteStore byteStore = new ByteStore();
        MyItem item1 = produceItem((byte) 1, (byte) 1, (byte) 6);
        MyItem item2 = produceItem((byte) 2, (byte) 2, (byte) 7);
        MyItem item3 = produceItem((byte) 3, (byte) 2, (byte) 8);
        byteStore.putMyItem(0, item1);
        byteStore.putMyItem(1, item2);
        byteStore.putMyItem(2, item3);

        MyItem myItem1 = byteStore.getMyItem(0);
        MyItem myItem2 = byteStore.getMyItem(1);
        MyItem myItem3 = byteStore.getMyItem(2);

        System.out.println(myItem1 == item1);
        System.out.println(myItem2 == item2);
        System.out.println(myItem3 == item3);

        fillByteStore();
        exe1000Item();

    }

    private static MyItem produceItem(byte i, byte i1, byte i2) {
        return new MyItem(i, i1, i2);
    }

    private static void fillByteStore() {

        ByteStore2 byteStore = new ByteStore2();
        MyItem item1 = produceItem((byte) 1, (byte) 1, (byte) 6);
        MyItem item2 = produceItem((byte) 2, (byte) 2, (byte) 7);
        MyItem item3 = produceItem((byte) 3, (byte) 3, (byte) 8);
        byteStore.putMyItemBitOperation(0, item1);
        byteStore.putMyItemBitOperation(1, item2);
        byteStore.putMyItemBitOperation(2, item3);

        MyItem myItem1 = byteStore.getItemBitOperation(0);
        MyItem myItem2 = byteStore.getItemBitOperation(1);
        MyItem myItem3 = byteStore.getItemBitOperation(2);

        System.out.println(myItem1);
        System.out.println(myItem2);
        System.out.println(myItem3);

        System.out.println(myItem1 == item1);
        System.out.println(myItem2 == item2);
        System.out.println(myItem3 == item3);

    }

    private static void exe1000Item() {

        ByteStore byteStore = new ByteStore();

        Random random = new Random(127);
        List<MyItem> myItems = IntStream.range(0, 1000).mapToObj(
                i -> new MyItem((byte) (i % 2 == 1 ? 0 : 1), (byte) (i % 2 == 1 ? 1 : 2), (byte) (random.nextInt()))
        ).collect(Collectors.toList());

        for (int i = 0; i < myItems.size(); i++) {
            byteStore.putMyItem(i, myItems.get(i));
        }

        byte tmpType, tmpColor, tmpPrice;
        byte[] storeByteArray = byteStore.getStoreByteArray();

        System.out.println("原始数组为：" + Arrays.toString(storeByteArray));
        for (int i = 0; i < storeByteArray.length / 3 - 1; i++) {
            for (int j = 0; j < storeByteArray.length / 3 - i - 1; j++) {
                if (storeByteArray[j * 3 + 2] < storeByteArray[(j + 1) * 3 + 2]) {

                    tmpType = storeByteArray[j * 3];
                    tmpColor = storeByteArray[j * 3 + 1];
                    tmpPrice = storeByteArray[j * 3 + 2];

                    storeByteArray[j * 3] = storeByteArray[(j + 1) * 3];
                    storeByteArray[j * 3 + 1] = storeByteArray[(j + 1) * 3 + 1];
                    storeByteArray[j * 3 + 2] = storeByteArray[(j + 1) * 3 + 2];

                    storeByteArray[(j + 1) * 3] = tmpType;
                    storeByteArray[(j + 1) * 3 + 1] = tmpColor;
                    storeByteArray[(j + 1) * 3 + 2] = tmpPrice;
                }
            }
        }

        System.out.println("排序后的数组为：" + Arrays.toString(storeByteArray));

    }
}
