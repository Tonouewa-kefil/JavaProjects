public class DoublyLinkedList {
    private Node Head;
    private Node Tail;

    public DoublyLinkedList() {
        Head = null;
        Tail = null;
    }

    public void createNewNode(int udata) {
        Node temp = new Node(udata);
        if (Head == null) {
            Head = temp;
            Tail = temp;
            temp = null;
            Head.previous = null;
            Head.next = null;
        } else {
            Head.next = temp;
            Head.next.previous = Head;
            Head.next.next = Tail;
        }

    }

    public void display() {
        Node temp = Head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}
