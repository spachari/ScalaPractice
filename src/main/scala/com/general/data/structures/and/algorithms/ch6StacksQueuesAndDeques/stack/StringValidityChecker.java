package com.general.data.structures.and.algorithms.ch6StacksQueuesAndDeques.stack;

public class StringValidityChecker {
    public boolean simpleValidityChecker(String string) {
        final String startParantesis = "({[";
        final String endParanthesis = "]})";

        Stack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < string.length(); i ++) {
            char currentCharacter = string.charAt(i);
            if (startParantesis.indexOf(currentCharacter) != -1) {
                stack.push(currentCharacter);
            } else if (endParanthesis.indexOf(currentCharacter) != -1) {
                stack.pop();
            }
        }
        if (stack.isEmpty()) return true; else return false;
    }

    public boolean complexValidityChecker(String string) {
        boolean isValidString = true;
        final String startParantesis = "({[";
        final String endParanthesis =  ")}]";

        Stack<Character> stack = new ArrayStack<>();

        for (int i = 0; i < string.length(); i ++) {
            char currentCharacter = string.charAt(i);
            if (startParantesis.indexOf(currentCharacter) != -1) {
                stack.push(currentCharacter);
            } else if (endParanthesis.indexOf(currentCharacter) != -1) {
                {
                    if (stack.isEmpty()) return false;
                    Character lastCharacterInStack = stack.pop();
                    if (endParanthesis.indexOf(currentCharacter) != startParantesis.indexOf(lastCharacterInStack)) {
                        return false;
                        //break;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}

class StringValidityCheckerTest {
    public static void main(String[] args) {
        StringValidityChecker svc = new StringValidityChecker();
        System.out.println(svc.simpleValidityChecker("(String)"));
        System.out.println(svc.simpleValidityChecker("(String"));

        //Complex checking
        System.out.println(svc.complexValidityChecker("{[(String)]}"));
        System.out.println(svc.complexValidityChecker("{[(String])}"));


    }
}