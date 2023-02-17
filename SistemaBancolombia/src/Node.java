public class Node {

    //Datos
    private String id;

    //Enlaces
    private Node next;
    private Node previous;
    private int numCall;
    private boolean status;

    public Node(String id) {
        this.id = id;
        this.numCall = 0;
        this.status = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumCall() {
        return numCall;
    }

    public void setNumCall(int numCall) {
        this.numCall += numCall;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

}
