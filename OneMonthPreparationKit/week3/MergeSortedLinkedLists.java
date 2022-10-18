package week3;

import java.io.IOException;

public class MergeSortedLinkedLists {

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(node.data);

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
        System.out.println();
    }

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode temp = head;
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);

        while (position-- > 1) {
            temp = temp.next;
        }
        SinglyLinkedListNode temp2 = temp.next;
        temp.next = node;
        node.next = temp2;
        return head;
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        while (head1 != null || head2 != null) {
            if (head1 != null && head2 != null) {
                if (head1.data < head2.data) {
                    linkedList.insertNode(head1.data);
                    head1 = head1.next;
                } else {
                    linkedList.insertNode(head2.data);
                    head2 = head2.next;
                }
            } else {
                if (head1 == null) {
                    linkedList.insertNode(head2.data);
                    head2 = head2.next;
                } else {
                    linkedList.insertNode(head1.data);
                    head1 = head1.next;
                }
            }
        }
        return linkedList.head;
    }

    public static void main(String[] args) throws IOException {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertNode(1);
        linkedList.insertNode(3);
        linkedList.insertNode(5);
        linkedList.insertNode(9);


        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insertNode(2);
        list2.insertNode(4);
        list2.insertNode(6);
        list2.insertNode(8);
        list2.insertNode(18);
        list2.insertNode(20);

        printSinglyLinkedList(insertNodeAtPosition(linkedList.head, 7, 3), "-");

        printSinglyLinkedList(list2.head, "-");

        printSinglyLinkedList(mergeLists(linkedList.head, list2.head), "-");

    }

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }


    }
}