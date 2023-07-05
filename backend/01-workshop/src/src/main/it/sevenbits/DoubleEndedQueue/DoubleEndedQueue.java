package src.main.it.sevenbits.DoubleEndedQueue;

public class DoubleEndedQueue {
    private final Node head;

    public DoubleEndedQueue() {
        this.head = new Node(null);
        this.head.next = this.head;
        this.head.prev = this.head;
    }

    public Node getFirst(){
        return head.next;
    }

    public Node getLast(){
        return head.prev;
    }

    public void addFirst(Node nodeToAdd){
        Node formerFirstNode = head.next;
        head.next = nodeToAdd;
        nodeToAdd.prev = head;
        nodeToAdd.next = formerFirstNode;
        formerFirstNode.prev = nodeToAdd;
    }

    public void addLast(Node nodeToAdd){
        Node formerLastNode = head.prev;
        nodeToAdd.next = head;
        head.prev = nodeToAdd;
        nodeToAdd.prev = formerLastNode;
        formerLastNode.next = nodeToAdd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = head.next;
        while(currentNode != head) {
            sb.append(currentNode.toString());
            sb.append("\n");
            currentNode = currentNode.next;
        }
        return sb.toString();
    }
}
