package com.general.data.structures.and.algorithms.ch6StacksQueuesAndDeques.stack;

public class ArrayStack<E> implements Stack<E> {

    public static final int CAPACITY = 1000;
    private E[] data;
    private int t = -1;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }


    @Override
    public int size() {
        return t + 1;
    }

    @Override
    public boolean isEmpty() {
        return (t == -1);
    }

    @Override
    public void push(Object o) throws IllegalStateException {
        if (t == data.length - 1) {
            throw new IllegalStateException("Capacity of Stack is " + data.length + " already we have reached that limit " );
        }
        else {
            E element = (E) o;
            data[++t] = element;
            //System.out.println("t is " + t + " out of " + data.length);
        }
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        } else {
            int lastElement = getNonNullOfArray();
            E temp = data[lastElement - 1];
            data[lastElement - 1] = null;
            t--;
            return temp;
        }
    }

    @Override
    public E top() {
        int lastElement = getNonNullOfArray();
        System.out.println("**** " + getNonNullOfArray());
        return data[t];
    }

    private int getNonNullOfArray() {
        int counter = 0;
        for (Object i : data) {
            if (i != null) {
                counter++;
            }
        }
        return counter;
    }

    public void printItemsInStack() {
        for (Object i : data) {
            E temp = (E) i;
            if (temp != null)
            {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack<Integer> array = new ArrayStack<Integer>();
        System.out.println("Initial size ... " + array.size());
        array.push(11);
        array.push(22);
        array.push(33);
        array.push(44);
        System.out.println("New size ... " + array.size());
        System.out.println("Is stack empty ... " + array.isEmpty());

        System.out.println("Top element ... " + array.top());

        array.printItemsInStack();

        Integer item = array.pop();

        System.out.println(item);

        array.printItemsInStack();
        System.out.println("New stack size " + array.size());


        ArrayStack<Integer> array1 = new ArrayStack<>(2);
        array1.push(1);
        array1.push(2);
        System.out.println(array1.size());
        //array1.push(3);

        ArrayStack<String> array2 = new ArrayStack<>(2);
        array2.push("Srinivas");
        array2.push("Pachari");

        String str = array2.pop();
        System.out.println(str);

        ArrayStack<Character> array3 = new ArrayStack<>(2);
        array3.push("Srinivas");
        array3.push("Pachari");

        String chr = array2.pop();
        System.out.println(chr);
    }
}
