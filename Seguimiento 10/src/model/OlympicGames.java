package model;

import color.Color;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.google.gson.Gson;

public class OlympicGames {

    static String folder = "dataBase";
    static String path = "database/data.txt";
    private ArrayList<Country> countries;

    public OlympicGames() {
        this.countries = new ArrayList<>();
        File folder = new File(this.folder);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    public void addCountry(String nameCountry, String typeMedal, int numMedals) {
        // Busca si el pais existe y si es asi, añade el numero de medallas
        for (Country country : countries) {
            if (country.getName().equalsIgnoreCase(nameCountry)) {
                switch (typeMedal) {
                    case "ORO":
                        country.setGold(numMedals);
                        return;
                    case "PLATA":
                        country.setSilver(numMedals);
                        return;
                    case "BRONCE":
                        country.setBronze(numMedals);
                        return;
                }
            }
        }
        // Si no existe añade el pais crea el pais
        switch (typeMedal) {
            case "ORO":
                countries.add(new Country(nameCountry, numMedals, 0, 0, numMedals));
                break;
            case "PLATA":
                countries.add(new Country(nameCountry, 0, numMedals, 0, numMedals));
                break;
            case "BRONCE":
                countries.add(new Country(nameCountry, 0, 0, numMedals, numMedals));
                break;
        }
    }

    public void showMedalsTable() {
        Collections.sort(countries);
        System.out.println(Color.RED_BOLD + "Tabla de medallería convencional:" + Color.RESET);
        System.out.format("| %-20s | %-10s | %-10s | %-10s |\n", "País", "Oros", "Platas", "Bronces");
        for (Country country : countries) {
            System.out.format("| %-20s | %-10s | %-10s | %-10s |\n", country.getName(), country.getGold(), country.getSilver(), country.getBronze());
        }
    }

    public void showTotalMedalsTable() {
        Collections.sort(countries, (a, b) -> {
            return b.getTotal() - a.getTotal();
        });
        System.out.println(Color.RED_BOLD + "Tabla de total de medallas:" + Color.RESET);
        System.out.format("| %-20s | %-10s |\n", "País", "Total");
        for (Country country : countries) {
            System.out.format("| %-20s | %-10s |\n", country.getName(), country.getTotal());
        }
    }

    public void showAlphabeticalTable() {
        insertionSort(countries);
        System.out.println(Color.RED_BOLD + "Tabla de medallería por orden alfabético:" + Color.RESET);
        System.out.format("| %-20s | %-10s | %-10s | %-10s |\n", "País", "Oros", "Platas", "Bronces");
        for (Country country : countries) {
            System.out.format("| %-20s | %-10s | %-10s | %-10s |\n", country.getName(), country.getGold(), country.getSilver(), country.getBronze());
        }
    }

    public void insertionSort(ArrayList<Country> list) {
        for (int i = 1; i < list.size(); i++) {
            Country key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).getName().compareTo(key.getName()) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    public void save() throws IOException {
        try {
            File file = new File(path);
            FileOutputStream fos = new FileOutputStream(file);

            Gson gson = new Gson();
            String data = gson.toJson(countries);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(data);
            writer.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() throws IOException {
        try {
            File file = new File(path);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
                StringBuilder content = new StringBuilder();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }

                Gson gson = new Gson();
                Country[] array = gson.fromJson(content.toString(), Country[].class);
                countries.addAll(Arrays.asList(array));
                fis.close();
            } else {
                File innerFolder = new File(folder);
                if (!innerFolder.exists()) {
                    innerFolder.mkdirs();
                    file.createNewFile();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
