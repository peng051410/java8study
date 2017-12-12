package cn.imcompany.domain;

import lombok.Data;

@Data
public class ByteStore {

    private byte[] storeByteArray = new byte[1000];

    public void putMyItem(int index, MyItem item) {

        int arrIndex = 3 * index;
        storeByteArray[arrIndex] = item.getType();
        storeByteArray[arrIndex + 1] = item.getColor();
        storeByteArray[arrIndex + 2] = item.getPrice();
    }

    public MyItem getMyItem(int index) {

        int arrIndex = 3 * index;
        return new MyItem(storeByteArray[arrIndex], storeByteArray[arrIndex + 1], storeByteArray[arrIndex + 2]);
    }
}
