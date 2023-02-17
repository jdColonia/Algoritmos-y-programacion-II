import java.util.Scanner;

public class Main {

    public Scanner sc;
    public ListaCircular lista;

    public static void main(String[] args) {
        Main manager = new Main();
        manager.showMainMenu();
    }

    public Main() {
        sc = new Scanner(System.in);
        lista = new ListaCircular();
    }

    public void showMainMenu() {
        System.out.println("BIENVENIDO A BANCOLOMBIA");
        boolean stopFlag = false;

        while (!stopFlag) {
            System.out.println("************************************************");
            System.out.print("MENÚ PRINCIPAL:"
                    + "\n[1] Dar turno"
                    + "\n[2] Mostrar turno actual"
                    + "\n[3] Pasar turno"
                    + "\n[4] Seguir"
                    + "\n[5] Salir");
            System.out.print("\nSelect an option: ");
            int mainOption = sc.nextInt();
            System.out.println("************************************************");
            switch (mainOption) {
                case 1:
                    String id = String.valueOf(lista.countNode()+1);
                    lista.addNode(new Node (id));
                    System.out.println("Turno agregado");
                    break;
                case 2:
                    lista.print1();
                    System.out.println("---");
                    lista.print();
                    break;
                case 3:
                    lista.passTurn();
                    break;
                case 4:
                    lista.delete();
                    System.out.println("Se ha eliminado el turno de la lita");
                    break;
                case 5:
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