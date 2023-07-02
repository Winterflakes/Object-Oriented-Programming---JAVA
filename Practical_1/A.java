package Practical_1;

public class A {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.push(60); // Stack is full

        stack.pop();
        stack.pop();
        stack.pop();

        stack.pop();
        stack.pop();
        stack.pop(); // Stack is empty

        stack.peek(); // Stack is empty
    }
}

class Stack {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public Stack(int size) {
        maxSize = size;
        top = -1;
        stackArray = new int[maxSize];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push element: " + value);
        } else {
            stackArray[++top] = value;
            System.out.println("Pushed element: " + value);
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            return -1;
        } else {
            int poppedElement = stackArray[top--];
            System.out.println("Popped element: " + poppedElement);
            return poppedElement;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No element to peek.");
            return -1;
        } else {
            int peekedElement = stackArray[top];
            System.out.println("Peeked element: " + peekedElement);
            return peekedElement;
        }
    }
}



