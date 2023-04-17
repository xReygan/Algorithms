// Необходимо реализовать метод разворота связного списка
// (двухсвязного или односвязного на выбор)

public class list {
    Node head;
    Node tail;

    public void add(int value){
        Node node = new Node();
        node.value = value;
        if (head == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }
    
    public void add(int value, Node node){
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null){
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }
    }
    
    public void delete (Node node){
        Node previous = node.previous;
        Node next = node.next;
        if (previous == null){
            next.previous = null;
            head = next;
        } else {
            if (next == null){
                previous = null;
                tail = previous;
            } else {
                previous.next = next;
                next.previous = previous;
            }
        }
        
    }
    
    public Node find(int value){
        Node currentNode = head;
        while (currentNode != null){
            if (currentNode.value == value){
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public void revers (){
        Node currentNode = head;
        while (currentNode != null){
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null){
                tail = currentNode;
            }
            if (next == null){
                head = currentNode;
            }
            currentNode = next;
        }
    }
    
    public class Node{
        int value;
        Node next;
        Node previous;
    }
}
