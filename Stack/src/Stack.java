public class Stack {

    // private node Tail;
    private node Head;

    public boolean empty() {
        boolean isEmpty = false;
        if (Head == null)
            isEmpty = true;
        return isEmpty;
    }

    public Stack() {
        Head = null;
    }

    public node top() {
        if (empty()) {
            System.out.println("The stack is empty. Nothing to see!");
            return null;
        } else {
            return Head;
        }
    }

    public node pop() {
        if (empty()) {
            System.out.println("The stack is empty. Nothing to see!");
            return null;
        } else {
            // node temp = Head;
            Head = Head.next;
            ;

            return Head;
        }
    }

    public void push(int udata) {
        node Data = new node(udata);
        if (Head == null) {
            Head = Data;
            Data = null;
        } else {
            node Temp;
            Temp = Head;
            Head.data = udata;
            Head.next = Temp;
            Temp = null;
        }
    }
}
