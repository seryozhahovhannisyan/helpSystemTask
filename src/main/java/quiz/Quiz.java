package quiz;

import entity.Item;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by User on 08.06.2017.
 */
public class Quiz {

    public String checkBracket(String content) {

        Stack<Character> stack = new Stack<Character>();
        Character stackValue = null;
        char errorBracket = 0;
        String message = null;

        int i = 0;
        lab:
        for (; i < content.length(); i++) {
            char ch = content.charAt(i);
            switch (ch) {
                case '{':
                case '(':
                case '[':
                    stack.add(ch);
                    break;
                case '}':
                    stackValue = stack.empty() ? null : stack.pop();
                    if (stackValue == null || stackValue != '{') {

                        errorBracket += ch;
                        break lab;
                    }
                    break;
                case ')':
                    stackValue = stack.empty() ? null : stack.pop();
                    if (stackValue == null || stackValue != '(') {
                        errorBracket += ch;
                        break lab;
                    }
                    break;
                case ']':
                    stackValue = stack.empty() ? null : stack.pop();
                    if (stackValue == null || stackValue != '[') {
                        errorBracket += ch;
                        break lab;
                    }
                    break;
            }
        }
        Character stackItem = stack.empty() ? null : stack.pop();
        if (i < content.length()) {
            if (stackValue == null) {
                message = "ERROR: closed '" + errorBracket + "' but not opened";
            } else {
                message = "ERROR: opened '" + stackValue + "' but closed '" + errorBracket + "'";
            }
        } else if (stackItem != null) {
            message = "ERROR: opened '" + stackItem + "' but not closed";
        }
        message = message != null ? message : "SUCCESS " + content;
        return message;
    }

    public List<Item> reverseItem(List<Item> items) {
        Item first = items.get(0);
        reverseItem(first);

        List<Item> reversed = new LinkedList<Item>();
        for (Item item : items) {
            reversed.add(0, item);
        }

        return reversed;
    }

    private Item reverseItem(Item item) {
        while (item.hasNext()) {
            Item reverse = reverseItem(item.getNext());
            reverse.setNext(item);
            item.setNext(null);
        }

        return item;
    }
}
