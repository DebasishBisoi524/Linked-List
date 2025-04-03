package node;

/**
 * Represents a node in a singly linked list.
 * The node's data is immutable after creation, while the next reference remains mutable
 * to allow for list manipulation.
 */
public class Node {
    private final int data;  // Immutable data field
    private Node next;       // Mutable next reference

    /**
     * Constructs a node with the specified data and null next reference.
     * @param data The integer value to store in this node
     */
    public Node(int data) {
        this(data, null);
    }

    /**
     * Constructs a node with the specified data and next reference.
     * @param data The integer value to store in this node
     * @param next The next node in the list
     */
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    /**
     * @return The data contained in this node
     */
    public int getData() {
        return data;
    }

    /**
     * @return The next node in the list
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets the next node reference
     * @param next The node that should follow this one in the list
     */
    public void setNext(Node next) {
        this.next = next;
    }
}