package com.general.data.structures.and.algorithms.ch6StacksQueuesAndDeques.stack;



public class HTMLValidator {


    public boolean htmlValidator(String string) {
        final char startingTag = '<';
        final String endingTag = "</";
        final String closingTagChar = ">";

        boolean isValidString = false;
        Stack<String> stack = new LinkedStack<>();
        for (int i = 0; i < string.length(); i ++)
        {

            char currentChar = string.charAt(i);

            if (currentChar == startingTag) {
                String tag = string.substring(string.indexOf(currentChar, i), string.indexOf(closingTagChar, i) + 1);
                if (tag.contains("/")) {
                    if (stack.isEmpty()) {
                        isValidString = false;
                    } else {
                        String tagFromStack = stack.pop();
                        if (tagFromStack.equals(tag.replace("/", ""))) {
                            isValidString = true;
                        } else {
                            isValidString = false;
                        }
                        ;
                    }
                }
                else {
                    stack.push(tag);
                }
            }
        }
        return isValidString && stack.isEmpty();
    }

    public boolean htmlValidatorV1(String string) {
        //This is much better as we do not loop through the whole loop for every character
        Stack<String> buffer = new LinkedStack<>();
        final char tagChar = '<';
        int j = string.indexOf(tagChar);

        while(j != -1) {
            //System.out.println("j " + j);
            int k = string.indexOf('>', j);
            //System.out.println("Next tag end " + k);
            if (k == -1) return false;
            String tag = string.substring(j, k); //Strip away both the < and >
            tag = tag.replace("</", "").replace("<", "");
            System.out.println(tag);

            if (!tag.startsWith("/")) { //new starting tag
                buffer.push(tag);
            } else { //new ending tag
                if (buffer.isEmpty()) return false; //at this point the stack should not be empty
                String topTag = buffer.pop();
                if (tag.substring(1).equals(topTag)) {
                    return true;
                } else {
                    return false;
                }
            }
            j = string.indexOf(tagChar, j + 1);
        }
        return buffer.isEmpty();
    }

    public void printTags(String string) {
        int j = 0;
        while (j != -1) {

            int k = string.indexOf('>', j);
            String tag = string.substring(string.indexOf('<', j), string.indexOf('>', j) + 1);
            System.out.println(tag);
            j = string.indexOf('<', j + 1);
        }
    }
}



class HTMLValidatorTest {
    public static void main(String[] args) {
        HTMLValidator html = new HTMLValidator();
        System.out.println(html.htmlValidator("<br>String</br>"));
        System.out.println(html.htmlValidator("<br>String</dr>"));
        System.out.println(html.htmlValidator("<br>String</br><hr>"));
        System.out.println(html.htmlValidator("<br>String</br></hr>"));

        String str = "<br>String</br></hr>";

        System.out.println();
        System.out.println();
        System.out.println(html.htmlValidatorV1(str));

        html.printTags(str);

    }
}