public class IsCycle {

    public static boolean isCycle (Node head) {

        Node p1 = head;
        Node p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p2 == p1) {
                return true;
            }
        }
        return false;
    } 



    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {
    
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;         //             _________
        node4.next = node5;         //            |         |
        node5.next = node3;        //  1 --  2 -- 3 -- 4 -- 5


        Node node21 = new Node(1);
        Node node22 = new Node(2);
        Node node23 = new Node(3);
        Node node24 = new Node(4);
        Node node25 = new Node(5);

        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;  //   1 -- 2 -- 3 -- 4 -- 5

        if (isCycle(node1)) {
            System.out.println("node1 isCycle !");
        }

        if (isCycle(node21)) {
            System.out.println("node2 isCycle !");
        }

    }
}
