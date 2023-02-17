public class ListaCircular {

    private Node head;


    //Conocer la cantidad de turnos en el sistema
    public int countNode() {
        return countNode(head);
    }

    private int countNode(Node current) {
        if(current == null) {
            return 0;
        } else if (current.getNext() == head){
            return 1;
        }
        return 1 + countNode(current.getNext());
    }

    public void addNode(Node node) {
        if (head == null) {
            head = node;
            head.setNext(head);
            head.setPrevious(head);
            head.setStatus(true);
        } else {
            Node tail = head.getPrevious();
            node.setNext(head);
            head.setPrevious(node);
            tail.setNext(node);
            node.setPrevious(tail);
        }
    }

    //Muestra la lista completa
    public void print1(){
        if(head == null){
            System.out.println("Lista vacia");
        }else{
            print1(head);
        }
    }

    private void print1(Node current){
        if(current == head.getPrevious()){
            System.out.println(current.getId());
            return;
        }
        System.out.println(current.getId());
        print1(current.getNext());
    }
    //Muestra el turno actual
    public void print() {
        if (head == null) {
            System.out.println("No hay turnos aún");
        } else {
            print(head);
        }
    }

    private void print(Node current) {
        if(current.isStatus()) {
            if (current == head.getPrevious()) {
                System.out.println(current.getId());
                return;
            }
            System.out.println(current.getId());
            return;
        }
        print(current.getNext());
    }

    //Pasar al siguiente turno
    public void passTurn(){
        passTurn(head);
    }

    private void passTurn(Node current) {
        if(current == null){
            System.out.println("No hay turnos aún");
            return;
        }
        if(current.isStatus()){
            if(current.getNumCall()+1 == 3) {
                delete(current);
                System.out.println("Se ha eliminado el turno de la lita");
                return;
            } else {
                current.setStatus(false);
                current.setNumCall(1);
                current.getNext().setStatus(true);
                System.out.println("Se ha pasado al siguiente turno");
                return;
            }
        }
        passTurn(current.getNext());
    }

    public void delete() {
        if (head == null) {
            print();
        } else if (head == head.getNext()) {
            head = null;
        } else {
            delete(head);
        }
    }

    private void delete(Node current) {
        if (current.isStatus()) {
            if (current.getNext() == head) {
                return;
            }
            //Eliminar la cabeza
            if (current == head) {
                head.getNext().setPrevious(head.getPrevious());
                head.getPrevious().setNext(head.getNext());
                head = head.getNext();
                head.setStatus(true);
            } else {
                //Eliminar cualquier elemento
                Node previous = current.getPrevious();
                Node next = current.getNext();
                previous.setNext(next);
                next.setPrevious(previous);
                next.setStatus(true);
            }
            return;
        }
        delete(current.getNext());
    }
}
