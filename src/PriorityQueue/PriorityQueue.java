package PriorityQueue;

import java.util.ArrayList;

public class PriorityQueue {
    public static void main(String[] args) {
        PriorityQueueMin<Integer> q = new PriorityQueueMin<Integer>();
        System.out.println(q.getMin());
        q.insert(1, 1);
        q.insert(2, 2);
        q.insert(3, 3);
        q.insert(4, 4);
        System.out.println(q.size());
        System.out.println(q.getMin().value);
        q.removeMin();
        //q.removeMin();
        System.out.println(q.size());
        System.out.println(q.getMin().value);
    }
}

class PriorityQueueMin<T> {
    private ArrayList<Element<T>> heap;

    public PriorityQueueMin() {
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority) {
        Element<T> e = new Element<>(value, priority);
        heap.add(e);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0) {
            if (heap.get(childIndex).priority < heap.get(parentIndex).priority) {
                Element temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    public Element<T> getMin() {
        if (isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    public T removeMin() {
        if (isEmpty()) {
            return null;
        }
        Element<T> e = getMin();
        heap.set(0, heap.get(size() - 1));
        heap.remove(heap.size() - 1);
        int index = 0;
        int midIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        while (leftChildIndex < heap.size()) {

            if (heap.get(leftChildIndex).priority < heap.get(midIndex).priority) {
                midIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).priority < heap.get(midIndex).priority) {
                midIndex = rightChildIndex;
            }
            if (midIndex == index) {
                break;
            } else {
                Element<T> temp = heap.get(index);
                heap.set(index, heap.get(midIndex));
                heap.set(midIndex, temp);
                index = midIndex;
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;
            }
        }
        return e.value;
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }
}
// wrong and incomplete
class PriorityQueueMax<T> {
    private ArrayList<Element<T>> heap;

    public PriorityQueueMax() {
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority) {
        Element<T> e = new Element<>(value, priority);
        heap.add(e);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0) {
            if (heap.get(childIndex).priority < heap.get(parentIndex).priority) {
                Element temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    public Element<T> getMax() {
        if (isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    public T removeMin() {
        if (isEmpty()) {
            return null;
        }
        Element<T> e = getMax();
        heap.set(0, heap.get(size() - 1));
        heap.remove(heap.size() - 1);
        int index = 0;
        int midIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        while (leftChildIndex < heap.size()) {

            if (heap.get(leftChildIndex).priority < heap.get(midIndex).priority) {
                midIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).priority < heap.get(midIndex).priority) {
                midIndex = rightChildIndex;
            }
            if (midIndex == index) {
                break;
            } else {
                Element<T> temp = heap.get(index);
                heap.set(index, heap.get(midIndex));
                heap.set(midIndex, temp);
                index = midIndex;
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;
            }
        }
        return e.value;
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }
}
