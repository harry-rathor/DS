package ds;

public class List {

    public static void main(String[] args) {
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.next.next.next.next = new Node(5);

        //making circular list
        //list.next.next.next.next.next = list.next;
        findCircleInList(list);

        //printList(list);
        //Node reverseList = reverseListWithIterative(list);
        //printList(reverseList);

    }

    private static void findCircleInList(Node list) {
        Node p1=list,p2=list;
        boolean isCircleFound=false;
        while(p1!=null && p2!=null&&p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1==p2){
                isCircleFound=true;
                break;
            }
        }

        if(isCircleFound){
            System.out.println("Circle Found");
        } else {
            System.out.println("Circle Not Found");
        }

    }

    private static Node reverseListWithIterative(Node list) {
        if (list == null || list.next == null) {
            return list;
        }

        Node prev=null;
        Node current=list;
        Node next=null;

        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }

        return prev;
    }


    private static void printList(Node list) {

        while (list != null) {
            System.out.print("=>" + list.data);
            list = list.next;
        }

    }

    private static Node reverseListWithRecursive(Node list) {
        if (list == null || list.next == null) {
            return list;
        } else {
            Node newHeadNode = reverseListWithRecursive(list.next);
            System.out.println("t=>" + newHeadNode.data + ",l=>" + list.data);
            list.next.next = list;
            list.next = null;

            return newHeadNode;
        }

    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

    }
}
