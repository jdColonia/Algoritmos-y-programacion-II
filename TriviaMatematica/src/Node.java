public class Node {

    //Datos
    private String id;
    private Player player;
    private String question;
    private int answer;
    private Status status;

    //Enlaces
    private Node next;
    private Node previous;

    public Node(String id) {
        this.id = id;
        this.player = null;
        createQuestion();
        this.status = Status.NO_RESPONDIDO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public void createQuestion() {
        int A = (int)(Math.random()*100); //Genera número aleatorio entre 0 y 100, excluyendo el 100
        int B = (int)(Math.random()*100); //Genera número aleatorio entre 0 y 100, excluyendo el 100
        int opt = (int)(Math.random()*2); //Genera como aleatorio ó el "0" ó el "1"
        String operador = (opt == 0) ? "+" : "*"; //Define la operación del problema
        question = "\n¿Cuánto es: " + A + operador + B + "?"; //Diseña la pregunta
        answer = (opt == 0) ? A+B : A*B; //Resuelve el problema
    }

}
