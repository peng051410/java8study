package cn.imcompany.leetcode;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by tomyli on 2020/1/23.
 * Github: https://github.com/peng051410
 */
public class ReverseLinkedList {

    private static class ListNode {
        int val;

        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("val", val)
                    .toString();
        }
    }

    public static ListNode reverse(ListNode node) {

        //保存当前节点的上一个节点
        ListNode prev = null;
        ListNode cur = node;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            //prev与cur向前走
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    //1->2->3->null
    public static ListNode reverse1(ListNode node) {

        if (node == null || node.next == null) {
            return node;
        }
        ListNode cur = reverse1(node.next);
        node.next.next = node;
        node.next = null;
        return cur;
        
    }


    public static void main(String[] args) {

        final ListNode listNode = new ListNode(1);

        final ListNode next = new ListNode(2);
        listNode.next = next;

        next.next = new ListNode(3);

        final ListNode x = reverse(listNode);
        System.out.println(x);
    }
}
