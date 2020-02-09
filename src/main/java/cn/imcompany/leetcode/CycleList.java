package cn.imcompany.leetcode;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.*;

/**
 * see https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode/
 * Created by tomyli on 2020/2/1.
 * Github: https://github.com/peng051410
 */
public class CycleList {

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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ListNode listNode = (ListNode) o;
            return val == listNode.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }

    public static void main(String[] args) {

        List<Long> list = new ArrayList<>();
        list.contains(123);
        final ListNode listNode = new ListNode(1);

        final ListNode next = new ListNode(2);
        listNode.next = next;

        final ListNode listNode1 = new ListNode(3);
        next.next = listNode1;
        listNode1.next = listNode;

        final boolean x = hasCycleWithTwoPointer2(listNode);
        System.out.println(x);
    }

    private static boolean hasCycle(ListNode listNode) {

        Set<ListNode> set = new HashSet<>();
        while (listNode != null) {
            if (set.contains(listNode)) {
                return true;
            } else {
                set.add(listNode);
            }
            listNode = listNode.next;
        }
        return false;
    }

    private static boolean hasCycleWithTwoPointer(ListNode listNode) {

        if (listNode == null || listNode.next == null) {
            return false;
        }
        
        ListNode slow = listNode;
        ListNode fast = listNode.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    private static boolean hasCycleWithTwoPointer2(ListNode node) {

        ListNode slow = node;
        ListNode fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


}
