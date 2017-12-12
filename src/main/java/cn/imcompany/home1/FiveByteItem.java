package cn.imcompany.home1;

import cn.imcompany.domain.ByteStore;
import cn.imcompany.domain.MyItem;

public class FiveByteItem {

    public static void main(String[] args) {

        ByteStore byteStore = new ByteStore();
        MyItem item1 = new MyItem(((byte) 1), ((byte) 1), ((byte) 6));
        MyItem item2 = new MyItem(((byte) 2), ((byte) 2), ((byte) 7));
        MyItem item3 = new MyItem(((byte) 3), ((byte) 3), ((byte) 8));
        byteStore.putMyItem(0, item1);
        byteStore.putMyItem(1, item2);
        byteStore.putMyItem(2, item3);

        MyItem myItem1 = byteStore.getMyItem(0);
        MyItem myItem2 = byteStore.getMyItem(1);
        MyItem myItem3 = byteStore.getMyItem(2);

        System.out.println(myItem1 == item1);
        System.out.println(myItem2 == item2);
        System.out.println(myItem3 == item3);

    }
}
