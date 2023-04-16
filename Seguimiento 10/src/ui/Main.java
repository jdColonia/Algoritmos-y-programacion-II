package ui;

import model.OlympicGames;
import color.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final OlympicGames olympicGames = new OlympicGames();

    public static void main(String[] args) throws IOException {
        olympicGames.load();
        int option = 0;
        while (option != 5) {
            String menu = Color.YELLOW_BOLD + "MENU DE OPCIONES: \n" + Color.RESET +
                    Color.YELLOW_BOLD + "[1]" + Color.RESET + " Ingresar un país\n" +
                    Color.YELLOW_BOLD + "[2]" + Color.RESET + " Mostrar medallería\n" +
                    Color.YELLOW_BOLD + "[3]" + Color.RESET + " Mostrar total de medallas\n" +
                    Color.YELLOW_BOLD + "[4]" + Color.RESET + " Mostrar países\n" +
                    Color.YELLOW_BOLD + "[5]" + Color.RESET + " Salir\n" +
                    Color.GREEN_BOLD + "> " + Color.RESET;
            System.out.print(menu);
            try {
                option = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println(Color.RED_BOLD + "Opción inválida. Intente de nuevo." + Color.RESET);
                continue;
            }
            switch (option) {
                case 1:
                    try {
                        System.out.println("Ingrese el país, medalla y cantidad (PAIS::MEDALLA::CANTIDAD)");
                        System.out.print(Color.GREEN_BOLD + "> " + Color.RESET);
                        String[] input = reader.readLine().split("::");
                        // Válida que se pasen todos los valores sin errores
                        if (input.length != 3) {
                            throw new IllegalArgumentException(Color.RED_BOLD + "Error, se deben ingresar tres valores separados por '::'" + Color.RESET);
                        }
                        // Válida que la medalla sea de oro, plata o bronce
                        String typeMedalString = input[1].toUpperCase();
                        if (!typeMedalString.equals("ORO") && !typeMedalString.equals("PLATA") && !typeMedalString.equals("BRONCE")) {
                            throw new IllegalArgumentException(Color.RED_BOLD + "Error, tipo de medalla inválido. Las opciones son oro, plata o bronce." + Color.RESET);
                        }
                        // Válida que la cantidad es un número y que es mayor a 0
                        int quantity;
                        try {
                            quantity = Integer.parseInt(input[2]);
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Error, la cantidad debe ser un número entero");
                        }
                        if (quantity <= 0) {
                            throw new IllegalArgumentException("Error, la cantidad debe ser un mayor a 0");
                        }
                        // Añade el país si todo es correcto
                        olympicGames.addCountry(input[0].toUpperCase(), typeMedalString, quantity);
                        olympicGames.save();
                    } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    olympicGames.showMedalsTable();
                    break;
                case 3:
                    olympicGames.showTotalMedalsTable();
                    break;
                case 4:
                    olympicGames.showAlphabeticalTable();
                    break;
                case 5:
                    olympicGames.save();
                    System.out.println(Color.RED_BOLD + "Programa finalizado." + Color.RESET);
                    break;
                default:
                    System.out.println(Color.RED_BOLD + "Opción inválida. Intente de nuevo." + Color.RESET);
                    break;
            }
        }
    }
}