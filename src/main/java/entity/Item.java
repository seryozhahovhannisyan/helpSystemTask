package entity;

/**
 * Created by User on 08.06.2017.
 */
public class Item {

    private int field;
    private Item next;

    public Item(int field) {
        this.field = field;
    }

    public Item(int field, Item next) {
        this.field = field;
        this.next = next;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    public Item getNext() {
        return next;
    }

    public void setNext(Item next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (field != item.field) return false;
        return next != null ? next.equals(item.next) : item.next == null;

    }

    @Override
    public int hashCode() {
        int result = field;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "field=" + field +
                ", next=" + next +
                '}';
    }
}
