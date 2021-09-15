package Queue;

public class QueueUsingArray {
    private int[] data;
    private int front;
    private int rear;
    private int size;

    public QueueUsingArray() {
        System.out.println("Default size of Queue is " + 5);
        data = new int[5];
        front = -1;
        rear = -1;
    }

    public QueueUsingArray(int sizeOfQueue) {
        System.out.println("Default size of Queue is " + sizeOfQueue);
        data = new int[sizeOfQueue];
        front = -1;
        rear = -1;
    }

    private void doubleCapacity() {
        System.out.println("Queue size is doubled");
        int temp[] = data;
        data = new int[2 * temp.length];
        for (int i = 0; i < temp.length; i++) {
            data[i] = temp[i];
        }

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enQueue(int element) {
        if (size == 0) {
            front = 0;
        }
        if (size == data.length) {
            doubleCapacity();
            data[++rear] = element;
            size++;
        } else {
            data[++rear] = element;
            size++;
        }
    }

    public void deQueue() {
        if (size == 0) {
            System.out.println("Queue is empty");
        } else {
            size--;
            System.out.println("Removed element from queue is " + data[front++]);
        }
    }

    public int front() {
        if (size != 0) {
            return data[front];
        } else {
            System.out.print("Queue is empty ");
            return -1;
        }
    }
}
