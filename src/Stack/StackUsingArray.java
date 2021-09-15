package Stack;

//every method in this class has time complexity id O(1) except doubleCapacity
public class StackUsingArray {
    private int[] data;
    private int topIndex;

    public StackUsingArray() {
        System.out.println("Default size of stack is 10");
        data = new int[10];
        topIndex = -1;
    }

    public StackUsingArray(int sizeOfStack) {
        System.out.println("Default size of stack is " + sizeOfStack);
        data = new int[sizeOfStack];
        topIndex = -1;
    }

    public int top() {
        if (topIndex == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return data[topIndex];
        }
    }

    public void pop() {
        if (topIndex == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Popped element is " + data[topIndex--]);
        }
    }

    public void push(int element) {
        if (topIndex == data.length - 1) {
            System.out.println("We has doubled the capacity of stack");
            doubleCapacity();
        }
        data[++topIndex] = element;
    }

    // complexity is O(n)
    private void doubleCapacity() {
        int temp[] = data;
        data = new int[2 * temp.length];
        for (int i = 0; i < temp.length; i++) {
            data[i] = temp[i];
        }
    }

    public int size() {
        return topIndex + 1;
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public boolean isFull() {
        return topIndex == 9;
    }
}
