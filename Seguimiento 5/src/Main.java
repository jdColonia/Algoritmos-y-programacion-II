import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        BST tree = new BST();

        System.out.println("Ingrese los nombres:");

        String names = scanner.nextLine();
        String[] array = names.split(" ");
        Collections.addAll(arrayList, array);

        tree.add(arrayList, 0, arrayList.size()-1);
        System.out.println("\nRecorrido inorder reverso:");
        tree.traverseInOrder();
        System.out.println("\n\nProfundidad:");
        System.out.println(tree.depth());

    }

}

