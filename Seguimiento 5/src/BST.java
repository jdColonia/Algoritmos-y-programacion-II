import java.util.ArrayList;

public class BST {
    private Node root;
    private ArrayList<String> arrLeft;
    private ArrayList<String> arrRight;

    public BST() {
        this.root = null;
        this.arrLeft = new ArrayList<>();
        this.arrRight = new ArrayList<>();
    }

    //Método para agregar elementos al árbol a partir de un array dado
    public void add(ArrayList<String> array, int start, int end) {
        if (start > end) {
            return;
        }

        int mid = (start + end) / 2; // Calcula el valor medio para obtener el nodo raíz del subárbol actual

        if (root == null) {
            root = new Node(array.get(mid));
        } else {
            int midRight = arrRight(array, mid); // Calcula los valores medios para los nodos del subárbol derecho
            add(root, new Node(arrRight.get(midRight))); // Agrega el nodo correspondiente al subárbol derecho
            add(array, mid+1, end); // Agrega los nodos restantes del subárbol derecho
            int midLeft = arrLeft(array, mid); // Calcula los valores medios para los nodos del subárbol izquierdo
            add(root, new Node(arrLeft.get(midLeft))); // Agrega el nodo correspondiente al subárbol izquierdo
            add(array, start, mid-1); // Agrega los nodos restantes del subárbol izquierdo
            return;
        }
        add(array, start, end-1);
    }

    // Método para obtener el valor medio de los nodos del subárbol derecho
    private int arrRight(ArrayList<String> array, int mid) {
        for (int i = mid + 1; i < array.size(); i++) {
            arrRight.add(array.get(i));
        }
        return (mid + 1) / 2;
    }

    // Método para obtener el valor medio de los nodos del subárbol izquierdo
    private int arrLeft(ArrayList<String> array, int mid) {
        for (int i = 0; i < mid - 1; i++) {
            arrLeft.add(array.get(i));
        }
        return (mid - 1) / 2;
    }

    // Método que agrega un nodo al árbol
    private void add(Node current, Node node) {
        if (node.getKey().compareTo(current.getKey()) < 0) {
            //Meter a la izquierda
            if (current.getLeft() == null) {
                current.setLeft(node);
            } else {
                add(current.getLeft(), node);
            }
        } else if (node.getKey().compareTo(current.getKey()) > 0) {
            //Meter a la derecha
            if (current.getRight() == null) {
                current.setRight(node);
            } else {
                add(current.getRight(), node);
            }
        } else {
            //No hacer nada
        }
    }

    // Método de activación para el inorder reverso
    public void traverseInOrder() {
        traverseInOrder(root);
    }

    // Método encargado de imprimir el inorder reverso
    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.getRight());
            System.out.print(node.getKey() + " ");
            traverseInOrder(node.getLeft());
        }
    }

    // Método de activación para calcular la cantidad de niveles del BST
    public int depth () {
        if (root == null) {
            return 0;
        }
        return depth(root);
    }

    // Método calculador de la cantidad de niveles del BST
    private int depth (Node node) {
        if (node == null) {
            return 0;
        } else {
            // Calcular la cantidad de niveles de cada subárbol
            int leftDepth = depth(node.getLeft());
            int rightDepth = depth(node.getRight());

            // Verifica cuál subárbol es más grande
            if (leftDepth > rightDepth) {
                return (leftDepth + 1);
            } else {
                return (rightDepth + 1);
            }
        }
    }
}

