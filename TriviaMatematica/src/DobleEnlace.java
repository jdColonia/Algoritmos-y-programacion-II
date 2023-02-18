public class DobleEnlace {

    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void addNode(Node node) {
        if(head==null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
    }

    //Mostrar el juego
    public void display() {
        display(head);
    }

    private void display(Node current) {
        if(current == null) {
            return;
        } else if (current.getPlayer() != null) {
            if(current == tail) {
                if(current.getStatus() == Status.INCORRECTO) {
                    System.out.print("[" + "X" + "]" + "");
                } else if(current.getStatus() == Status.CORRECTO) {
                    System.out.print("[" + "+" + "]" + "");
                } else {
                    System.out.print("[" + current.getId() + "*]" + "");
                }
            } else {
                System.out.print("[" + current.getId() + "*]" + "");
            }
        } else {
            if(current.getStatus() == Status.INCORRECTO) {
                System.out.print("[" + "X" + "]" + "");
            } else if(current.getStatus() == Status.CORRECTO) {
                System.out.print("[" + "+" + "]" + "");
            } else {
                System.out.print("[" + current.getId() + "]" + "");
            }
        }
        display(current.getNext());
    }

    public void askQuestion(String id){
        askQuestion(head, id);
    }

    private void askQuestion(Node current, String id){
        if(current == null){
            System.out.println("Pregunta no encontrada");
            return;
        } if(current.getId().equals(id)){
            System.out.println(current.getQuestion());
            return;
        }
        askQuestion(current.getNext(), id);
    }

    public void checkAnswer(String id, String answer, Player player){
        checkAnswer(head, id, answer, player);
    }

    private void checkAnswer(Node current, String id, String answer, Player player){
        if(current == null){
            return;
        }
        if(current.getId().equals(id)){
            if(String.valueOf(current.getAnswer()).equals(answer)){
                current.setStatus(Status.CORRECTO);
                if(current.getNext() != null){
                    current.getNext().setPlayer(player);
                    current.setPlayer(null);
                }
                return;
            } else if (answer.equalsIgnoreCase("PASO")) {
                if (head == tail) { // Caso especial: solo hay un nodo en la lista
                    head = tail = null; // Establece la cabeza y la cola en null
                }else if(current == head){
                    //Elimina la cabeza
                    head.getNext().setPrevious(null);
                    head = head.getNext();
                    head.setPlayer(player);
                }else if(current == tail){
                    //Elimina la cola
                    tail.getPrevious().setNext(null);
                    tail = tail.getPrevious();
                }else{
                    // Elimina un nodo intermedio
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                    current.getNext().setPlayer(player);
                }
                return;
            } else {
                current.setStatus(Status.INCORRECTO);
                if(current.getNext() != null){
                    current.getNext().setPlayer(player); //Mueve el jugador al siguiente problema
                    current.setPlayer(null); //Elimina al jugador del problema anterior
                }
                return;
            }
        }
        checkAnswer(current.getNext(), id, answer, player);
    }

    //Calcular los puntajes
    public void score(int n, int questionPass, String namePlayer){
        scoreString(head, n, questionPass, namePlayer);
    }

    public int score(Node current, int n){
        if(current == null){
            return n;
        }
        if(current.getStatus() == Status.CORRECTO){
            System.out.print(current.getQuestion() + " CORRECTO");
            n++;
        } else {
            System.out.print(current.getQuestion() + " INCORRECTO");
        }
        return score(current.getNext(), n);
    }

    //Conversión a String
    public void scoreString(Node current, int n, int questionPass, String namePlayer){
        String score = String.valueOf(score(current, n) + (questionPass*-3));
        System.out.println("\nPasó " + questionPass + " problema");
        System.out.print("\n" + namePlayer + ", su puntaje fue: " + score);
    }

}
