package cn.imcompany.domain;

import lombok.Data;

@Data
public class ByteStore2 {

    private int[] storeByteArray = new int[10000];

    public void putMyItemBitOperation(int index, MyItem item) {

        storeByteArray[index] = item.getType() << 16 | item.getColor() << 8 | item.getPrice();
    }

    public MyItem getItemBitOperation(int index) {

        return new MyItem(
                (byte) (storeByteArray[index] >> 16),
                (byte) ((storeByteArray[index] & 0x0000ff00) >> 8),
                (byte) (storeByteArray[index] & 0x000000ff)
        );
    }
}
