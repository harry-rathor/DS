package ds;

public class LinkList {
    private Node head = null;

    public static LinkList addTwoNumber(LinkList list1, LinkList list2) {
        list1.reverseList();
        list2.reverseList();
        list1.printNode();
        list2.printNode();
        Node curr1 = list1.head;
        Node curr2 = list2.head;
        int carry = 0;

        LinkList resultList = new LinkList();

        while (curr1 != null && curr2 != null) {
            int res = curr1.data + curr2.data + carry;
            carry = res / 10;
            res = res % 10;
            curr1 = curr1.next;
            curr2 = curr2.next;

            resultList.addAtEnd(res);
        }

        while (curr1 != null) {
            int res = curr1.data + carry;
            carry = res / 10;
            res = res % 10;
            curr1 = curr1.next;

            resultList.addAtEnd(res);
        }

        while (curr2 != null) {
            int res = curr2.data + carry;
            carry = res / 10;
            res = res % 10;
            curr2 = curr2.next;

            resultList.addAtEnd(res);
        }


        return resultList;
    }

    public static void main(String[] args) {
        LinkList list1 = new LinkList();
        for (int i = 0; i < 10; i++) {
            list1.addAtEnd(i);
        }

        list1.printNode();

        LinkList list2 = new LinkList();
        for (int i = 4; i <= 9; i++) {
            list2.addAtEnd(i);
        }
       // list2.printNode();
        list1.printreverseList();
        //list1.printNode();
        //addTwoNumber(list1, list2).printNode();
    }

    public void addAtEnd(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }
    }

    public void printNode() {
        Node current = head;
        while (current != null && current != null) {
            System.out.print(current.data + "=>");
            current = current.next;
        }
        System.out.println();
    }

    public void printreverseList(){
        printInReverse(head);
        System.out.println();
    }

    private void printInReverse(Node node)
    {

        if(node==null){
            return;
        }
        printInReverse(node.next);
        System.out.print(node.data+"=>");
    }

    public void reverseList() {
        if (head.next == null) return;
        Node prev = null, current = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;

    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

    }


}
