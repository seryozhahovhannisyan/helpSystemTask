package quiz;

import entity.Item;
import quiz.Quiz;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 08.06.2017.
 */
public class QuizTest {

    public static void main(String[] args) {
        checkBracketTest();
        reverseItemTest();
    }

    private static void checkBracketTest() {
        Quiz quiz = new Quiz();
        String msg = quiz.checkBracket("[");
        System.out.println(msg);
        msg = quiz.checkBracket("]");
        System.out.println(msg);
        msg = quiz.checkBracket("[}");
        System.out.println(msg);
        msg = quiz.checkBracket("[]");
        System.out.println(msg);
    }


    private static void reverseItemTest() {
        Quiz quiz = new Quiz();
        List<Item> items = initItems();
        print(items);
        System.out.println();
        items = quiz.reverseItem(items);
        print(items);
    }

    private static List<Item> initItems() {
        List<Item> items = new LinkedList<Item>();
        Item item5 = new Item(5);
        Item item4 = new Item(4, item5);
        Item item3 = new Item(3, item4);
        Item item2 = new Item(2, item3);
        Item item1 = new Item(1, item2);

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        return items;
    }

    private static void print(List<Item> items) {
        for (Item item : items) {
            System.out.println(item);
        }
    }

}
