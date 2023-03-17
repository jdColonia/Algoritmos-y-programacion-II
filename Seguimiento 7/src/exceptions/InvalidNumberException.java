package exceptions;

public class InvalidNumberException extends RuntimeException{

    public InvalidNumberException(){
        super("No es posible agregar pesos negativos");
    }

}
