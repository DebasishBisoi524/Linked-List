package main;

import node.Node;

public class Main {
    public static void main(String[] args) {
        Node head = createLinkedList();
        head = performOperations(head);
        printList(head);
    }

    private static Node createLinkedList() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        one.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(five);
        five.setNext(six);
        six.setNext(seven);
        return one;
    }

    private static Node performOperations(Node head) {
        head = insertAtFront(head, 0);
        head = insertAtEnd(head, 8);
        head = deleteAtFront(head);
        head = deleteFromEnd(head);
        head = insertAtFront(head, 10);
        head = deleteAtFront(head);
        head = insertAtPosition(head, 12, 3);
        head = deleteAtPosition(head, 3);
        head = insertAtEnd(head, 8);
        head = insertAtEnd(head, 9);
        head = insertAtEnd(head, 5);
        head = insertAtEnd(head, 5);
        head = insertAtEnd(head, 5);
        head = insertAtEnd(head, 9);
        head = insertAtEnd(head, 9);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 2);
        head = removeDuplicateNode(head);
        head = insertAtMiddle(head, 0);
        head = deleteFromEnd(head);
        head = deleteFromEnd(head);
        return head;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("The Linked List is Empty");
            return;
        }

        Node current = head;
        int length = 0;
        StringBuilder list = new StringBuilder("The Linked List is: ");
        while (current != null) {
            list.append(current.getData()).append(" -> ");
            current = current.getNext();
            length++;
        }
        list.append("null.\n");
        System.out.print(list);
        System.out.println("The Length of the Linked List is: " + length);
    }

    public static Node insertAtPosition(Node head, int data, int position) {
        Node newNode = new Node(data);
        if (head == null || position <= 0) {
            newNode.setNext(head);
            System.out.println("Added " + data + " at the front");
            return newNode;
        }

        Node current = head;
        int currentPosition = 0;
        while (current.getNext() != null && currentPosition < position - 1) {
            current = current.getNext();
            currentPosition++;
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
        System.out.println("Added " + data + " at position " + (currentPosition + 1));
        return head;
    }

    public static Node insertAtFront(Node head, int data) {
        Node front = new Node(data);
        front.setNext(head);
        System.out.println("Added " + data + " at the front");
        return front;
    }

    public static Node insertAtEnd(Node head, int data) {
        Node end = new Node(data);
        if (head == null) {
            return end;
        }

        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(end);
        System.out.println("Added " + data + " at the end");
        return head;
    }

    public static Node insertAtMiddle(Node head, int data) {
        Node mid = new Node(data);
        if (head == null) {
            System.out.println("Added " + data + " as the head");
            return mid;
        }

        Node slow = head;
        Node fast = head.getNext();
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        mid.setNext(slow.getNext());
        slow.setNext(mid);
        System.out.println("Added " + data + " after middle node " + slow.getData());
        return head;
    }

    public static Node deleteAtPosition(Node head, int position) {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }

        if (position == 0) {
            System.out.println("Deleted " + head.getData() + " from front");
            return head.getNext();
        }

        Node current = head;
        int currentPosition = 0;
        while (current.getNext() != null && currentPosition < position - 1) {
            current = current.getNext();
            currentPosition++;
        }

        if (current.getNext() != null) {
            System.out.println("Deleted " + current.getNext().getData() + " from position " + position);
            current.setNext(current.getNext().getNext());
        }
        return head;
    }

    public static Node deleteAtFront(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }
        System.out.println("Deleted " + head.getData() + " from front");
        return head.getNext();
    }

    public static Node deleteFromEnd(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }

        if (head.getNext() == null) {
            System.out.println("Deleted " + head.getData() + " from end");
            return null;
        }

        Node current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }

        System.out.println("Deleted " + current.getNext().getData() + " from end");
        current.setNext(null);
        return head;
    }

    public static Node removeDuplicateNode(Node head) {
        Node current = head;
        while (current != null && current.getNext() != null) {
            if (current.getData() == current.getNext().getData()) {
                System.out.println("Removed duplicate " + current.getNext().getData());
                current.setNext(current.getNext().getNext());
            } else {
                current = current.getNext();
            }
        }
        return head;
    }
}