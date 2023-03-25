package storage;

import entity.Treasure;

import java.io.*;
import java.util.Optional;
import java.util.Set;

public class InFileTreasureStorage {

    public void save(Treasure treasure) {
        try (FileWriter fileWriter = new FileWriter("storage", true)) {
            fileWriter.write(treasure.toString());
            fileWriter.write("\n");
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Treasure> findAll() {
        try (FileInputStream fileInputStream = new FileInputStream("storage")) {
            int i;
            while ((i = fileInputStream.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    public void findPrice() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("storage.txt"));
        BufferedReader reader = new BufferedReader(new FileReader(br.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(br.readLine()));

        StringBuilder builder = new StringBuilder();

        while (br.ready()) {
            builder.append((char) reader.read());
        }

        String s = builder.toString();

        String[] parts = s.split("[^0-9]");

        for (int i = 0; i < parts.length; i++) {
            if (!parts[i].equals("")) {
                writer.write(parts[i]+" ");
            }
        }

        reader.close();
        br.close();
        writer.close();
    }
}


