import java.util.Random;

public class LinkedListJava {
    public static LinkedList sum(LinkedList l1, LinkedList l2) {
        LinkedList result = new LinkedList();
        int carry = 0;
        int sum = 0;
        if (l1.getFirst().next == null && l2.getFirst().next == null) {
            sum = l1.getFirst().data + l2.getFirst().data;
            if (sum < 10)
                result.createNode(sum);
            else {
                result.createNode(sum % 10);
                result.createNode(1);
            }
        } else {
            while (l1.getFirst() != null || l2.getFirst() != null) {
                if (l1.getFirst().next != null && l2.getFirst().next == null) {
                    sum = l1.getFirst().data + carry;
                    if (sum < 10) {
                        result.createNode(sum);
                        carry = 0;
                    } else {
                        result.createNode(sum % 10);
                        result.createNode(1);
                        carry = 1;
                    }
                    l1.delete_first();
                } else if (l1.getFirst().next == null && l2.getFirst().next != null) {
                    sum = l2.getFirst().data + carry;
                    if (sum < 10) {
                        result.createNode(sum);
                        carry = 0;
                    } else {
                        result.createNode(sum % 10);
                        carry = 1;
                    }
                    l2.delete_first();
                } else {
                    sum = l1.getFirst().data + l2.getFirst().data + carry;
                    if (sum < 10) {
                        result.createNode(sum);
                        carry = 0;
                    } else {
                        result.createNode(sum % 10);
                        carry = 1;
                    }
                    l1.delete_first();
                    l2.delete_first();
                }
            }
            result.createNode(carry);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        LinkedList Num1 = new LinkedList();
        LinkedList Num2 = new LinkedList();
        LinkedList Sum = new LinkedList();
        Random rand = new Random();
        int uData = 0;
        for (int i = 0; i < 4; i++) {
            uData = rand.nextInt(10);
            Num1.createNode(uData);
        }
        for (int i = 0; i < 4; i++) {
            uData = rand.nextInt(10);
            Num2.createNode(uData);
        }
        Num1.display();
        Num2.display();
        Sum = sum(Num1, Num2);
        Sum.display();
    }

}
