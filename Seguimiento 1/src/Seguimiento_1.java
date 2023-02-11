public class Seguimiento_1 {

    public static void main(String[] args) {

        System.out.println("SOLUCIÓN SEGUIMIENTO 1");
        //Punto 1: Cree un método llamado sum que reciba un arreglo de enteros y que calcule la sumatoria de todos los números del arreglo
        int[] arraySum = new int[]{12, -1, 15, 2, 4 , 14};
        System.out.println("Ejercicio 1" + "\nLa sumatoria de todos los números del arreglo es: " + sumArray(arraySum, 0));

        //Punto 2: Desarrolle un método recursivo que permita revertir un String de entrada
        String word = "gato";
        System.out.println("Ejercicio 2" + "\nLa palabra '" + word + "' al reverso es: " + stringReverse(word, word.length()));

        //Punto 3: Desarrolle un método recursivo que permita sacar el promedio de un arreglo
        double[] arrayProm = new double[]{1, 2, 3, 4, 5, 6};
        System.out.println("Ejercicio 3" + "\nEl promedio de todos los números del arreglo es: " + promArray(arrayProm, 0));

        //Punto 4: Desarrolle un método recursivo que devuelva la posición de un número en el arreglo
        int[] arrayPos = new int[]{1, 15, 8, 19, 21, 40, -4, 10};
        int posArray = posArray(arrayPos, 0, 19);
        if(posArray!=-1) {
            System.out.println("Ejercicio 4" + "\nLa posición del número es: " + posArray);
        } else {
            System.out.println("Ejercicio 4" + "\nEl número buscado no se encuentra en el arreglo");
        }

        //Punto 5: Desarrolle un método recursivo que muestre por consola el resultado de la división entera y el residuo a partir de la división usando restas sucesivas
        int division = divisionRecursiva(7,3);
        int residuo = residuoRecursivo(7,3);
        if(division!=-1) {
            System.out.println("Ejercicio 5" + "\nEl resultado de la división es: " + division + " y el residuo es: " + residuo);
        } else {
            System.out.println("Ejercicio 5" + "\nNo es posible realizar la división");
        }

        //Punto 6: Desarrolle un método recursivo que calcule el máximo común divisor de los números
        System.out.println("Ejercicio 6" + "\nEl máximo común divisor (MCD) es: " + MCD(50, 120));

    }

    //EJERCICIO 1
    public static int sumArray(int[] array, int i) {

        //Casos base
        if(i==array.length-1) {
            return array[array.length-1];
        }
        //Operación + Llamado recursivo
        return array[i] + sumArray(array, i+1);

    }

    //EJERCICIO 2
    public static String stringReverse(String word, int i) {

        //Casos base
        if(i==0) {
            return "";
        }
        //Operación + Llamado recursivo
        return word.charAt(i-1) + stringReverse(word, i-1);

    }

    //EJERCICIO 3
    public static double promArray(double[] array, int i) {

        //Casos base
        if(i==array.length-1) {
            return array[array.length-1]/array.length;
        }
        //Operación + Llamado recursivo
        return array[i]/array.length + promArray(array, i+1);

    }

    //EJERCICIO 4
    public static int posArray(int[] array, int i, int num) {

        //Casos base
        if(i==array.length || array[i]==num) {
            if(i==array.length){
                return -1;
            } else {
                return i;
            }
        }
        //Operación + Llamado recursivo
        return posArray(array, i+1, num);

    }

    //EJERCICIO 5
    public static int divisionRecursiva(int dividendo, int divisor) {

        //Casos bases
        if (divisor <= 0) {
            return -1;
        } else {
            if (dividendo < divisor) {
                return 0;
            } else {
                //Operación + Llamado recursivo
                return 1 + divisionRecursiva(dividendo - divisor, divisor);
            }
        }

    }

    public static int residuoRecursivo(int dividendo, int divisor) {

        //Casos bases
        if (divisor <= 0) {
            return -1;
        } else {
            if (dividendo < divisor) {
                return dividendo;
            } else {
                //Operación + Llamado recursivo
                return residuoRecursivo(dividendo - divisor, divisor);
            }
        }

    }

    //EJERCICIO 6
    public static int MCD(int a, int b) {

        //Casos bases
        if (b == 0) {
            return a;
        }
        //Operación + Llamado recursivo
        return MCD(b, a % b);

    }

}