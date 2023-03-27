package storage;

import entity.Treasure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InFileTreasureStorage {

    public void save(Treasure treasure) {
        try (FileWriter fileWriter = new FileWriter("storage", true)) {
            fileWriter.write(convertToString(treasure));
            fileWriter.write("\n");
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Treasure> findAll() {
        List<Treasure> entities = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("storage"))) {
            String input;
            while ((input = reader.readLine()) != null) {

                Treasure treasure = convertToEntity(input);
                entities.add(treasure);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    protected String convertToString(Treasure treasure) {
        return String.format("%s=%s", treasure.getNameTreasure(), treasure.getPrice());
    }

    public Optional<Treasure> findTreasureMaxPrice() {
        Treasure maxPrice = new Treasure();
        try (BufferedReader reader = new BufferedReader((new FileReader("storage")))) {
            String input;
            while ((input = reader.readLine()) != null) {
                Treasure treasure = convertToEntity(input);
                maxPrice = (maxPrice.getPrice() < treasure.getPrice()) ? treasure : maxPrice;

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return (maxPrice.getPrice() == 0) ? Optional.empty() : Optional.of(maxPrice);
    }

    public Treasure convertToEntity(String treasure) {
        String[] split = treasure.split("=");
        return new Treasure(split[0], Integer.parseInt(split[1]));

    }
}





