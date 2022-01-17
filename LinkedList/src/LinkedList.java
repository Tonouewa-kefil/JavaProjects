
public class LinkedList {

    private node Head;
    private node Tail;

    public LinkedList() {
        Head = null;
        Tail = null;
    }

    public void createNode(int uData) {
        node temp = new node(uData);
        if (Head == null) {
            Head = temp;
            Tail = temp;
            temp = null;
        } else {
            Tail.next = temp;
            Tail = temp;
        }

    }

    public void display() {
        node temp = Head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

    public void delete_position(int pos) {
        if (pos > getSize()) {
            System.out.println("Input a valid position. There are only " + getSize() + " element(s) in the list.");
        } else if (pos == 0) {
            delete_first();
        } else {
            node current;
            node temp = null;
            current = Head;
            int nexPos = 1;
            while (nexPos != pos) {
                temp = current;
                current = current.next;
                nexPos++;
            }
            temp.next = current.next;
            current = null;
        }
    }

    public void delete_first() {
        node temp = Head;
        Head = Head.next;
        temp = null;
    }

    public boolean isEmpty() {
        boolean result;
        if (Head == null) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public int getSize() {
        int size = 0;
        node temp = Head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    public node getFirst() {
        node first = Head;
        return first;
    }
}
