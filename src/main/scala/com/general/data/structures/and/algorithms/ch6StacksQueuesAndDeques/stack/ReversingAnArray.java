package com.general.data.structures.and.algorithms.ch6StacksQueuesAndDeques.stack;

public class ReversingAnArray<E> {

    public E[] reverse(E[] array) {
        Stack<E> stack = new ArrayStack<>(array.length);
        for (int i = 0; i < array.length; i ++) {
            stack.push(array[i]);
        }

        ((ArrayStack<E>) stack).printItemsInStack();

        //Creating a generic version of an array
        E[] outputArray = (E[]) new Object[array.length];
        for (int i = 0; i < array.length; i ++) {
            outputArray[i] = stack.pop();
        }
        return outputArray;
    }
}

class ReversingAnArrayTest {
    public static void main(String[] args) {
        ReversingAnArray<Object> r = new ReversingAnArray<>();
        String[] familyMembers = new String[]{"Srinivas", "Kirthika", "Sadhana", "Sadhiv"};

        Integer[] numbers = new Integer[]{1,2,3,4,5};

        Object[] reversedArray = r.reverse(numbers);

        for (Object s : reversedArray) {
            System.out.println(s);
        }

        Object[] reversedArrayString = r.reverse(familyMembers);

        for (Object s : reversedArrayString) {
            System.out.println(s);
        }


    }
}