package cn.imcompany.leetcode;

public class MyCircurlarQueue {

    private int[] queue;
    private int headIndex;
    private int count;

    public MyCircurlarQueue(int capacity) {
        this.queue = new int[capacity];
    }

    private boolean inQueue(int value) {
        if (isFull()) {
            return false;
        }

        queue[(headIndex + count - 1) % queue.length] = value;
        count++;
        return true;
    }

    private boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        headIndex = (headIndex + 1) % queue.length;
        count--;
        return true;
    }

    private int First() {
        if (isEmpty()) {
            return -1;
        }

        return queue[(headIndex + 1) % queue.length];
    }

    private int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return queue[(headIndex + count - 1) % queue.length];
    }

    private boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == queue.length;
    }
}
