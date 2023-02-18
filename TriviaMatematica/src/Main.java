import java.util.Scanner;

public class Main {

    public Scanner sc;
    public DobleEnlace lista;

    public static void main(String[] args) {
        Main manager = new Main();
        manager.showMainMenu();
    }

    public Main() {
        sc = new Scanner(System.in);
        lista = new DobleEnlace();
    }

    public void showMainMenu() {
        System.out.println("BIENVENIDO A TRIVIA MATEMÁTICA");
        boolean stopFlag = false;

        while (!stopFlag) {
            System.out.println("************************************************");
            System.out.print("MENÚ PRINCIPAL:"
                    + "\n[1] Iniciar juego"
                    + "\n[2] Salir");
            System.out.print("\nSelect an option: ");
            int mainOption = sc.nextInt();
            System.out.println("************************************************");
            switch (mainOption){
                case 1:
                    //Crea el juego
                    int questionPass = 0;
                    System.out.println("Ingrese el nombre del jugador: "); //Para pedir el nombre del jugador
                    sc.nextLine();
                    String namePlayer = sc.nextLine();
                    Player player = new Player(namePlayer);
                    System.out.println("Ingrese el número de problemas: "); //Para obtener la cantidad de problemas a resolver
                    int numProblems = sc.nextInt();
                    for(int i = 0; i < numProblems; i++){ //Para crear la lista enlazada que contenga los problemas matemáticos
                        lista.addNode(
                                new Node (String.valueOf(i+1))
                        );
                    }
                    lista.getHead().setPlayer(player); //Añade el jugador al juego
                    //Empieza el juego
                    System.out.println("************************************************");
                    System.out.println("INICIO DEL JUEGO: ");
                    for(int i = 0; i < numProblems; i++) { //Recorre los problemas
                        lista.display(); //Muestra el tablero con el jugador
                        lista.askQuestion(String.valueOf(i+1));
                        System.out.print("Ingrese 'PASO' para saltar la pregunta" + "\nDigite su respuesta: ");
                        String answer = sc.next();
                        if(answer.equalsIgnoreCase("PASO")){
                            questionPass++; //Contador de pasadas
                        }
                        lista.checkAnswer(String.valueOf(i+1), answer, player);
                    }
                    System.out.println("************************************************");
                    System.out.println("TABLERO FINAL: ");
                    lista.display(); //Mostrar el tablero con todos los aciertos, errores y problemas pasados
                    System.out.print("\nPUNTAJE: ");
                    lista.score(0, questionPass, namePlayer);
                    stopFlag = true;
                    break;
                case 2:
                    stopFlag = true;
                    System.out.println("Salida exitosa");
                    break;
                default:
                    System.out.println("Tú opción no se encuentra disponible");
                    stopFlag = true;
                    break;
            }
        }
    }

}