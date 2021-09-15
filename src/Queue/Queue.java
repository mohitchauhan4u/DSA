package Queue;

public class Queue {

    public static void main(String[] args) {
        QueueUsingArray queue=new QueueUsingArray();
       // QueueUsingLL queue=new QueueUsingLL();
        System.out.println(queue.isEmpty());
        queue.front();
        queue.enQueue(1);
        queue.enQueue(2);
      queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(7);
        queue.enQueue(8);
        queue.enQueue(9);
        queue.enQueue(10);
        System.out.println(queue.front());
        System.out.println(queue.size());
        queue.enQueue(111);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        queue.deQueue();
        System.out.println(queue.front());
        queue.deQueue();
        System.out.println(queue.front());
        queue.deQueue();
        System.out.println(queue.front())
        ;queue.deQueue();
        System.out.println(queue.front());
        queue.deQueue();
        System.out.println(queue.front());
        queue.deQueue();
        System.out.println(queue.front());
        System.out.println(queue.size());
    }
}
