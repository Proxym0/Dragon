package console;

import entity.Treasure;
import service.TreasureService;
import storage.InFileTreasureStorage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static console.ConsoleReader.readInteger;
import static console.ConsoleReader.readString;
import static console.ConsoleWriter.writer;

public class ConsoleApplication {
    InFileTreasureStorage inFileTreasureStorage = new InFileTreasureStorage();
    TreasureService treasureService = new TreasureService();

    public void run() throws IOException {

        writer("Select operation type\n1.Give the treasure to the dragon\n2." +
                "Collect all dragon treasures\n3." +
                "Retrieve the most precious treasure\n4.Collect treasure worth");
        while (true) {
            switch (readInteger()) {
                case 1:
                    writer("Enter the name of the treasure");
                    String nameTreasure = readString();
                    writer("Enter the value of the treasure");
                    int priceTreasure = readInteger();
                    Treasure treasure = new Treasure(nameTreasure, priceTreasure);
                    treasureService.create(treasure);
                case 2:
                    inFileTreasureStorage.findAll();
                    return;
                case 3:
                  inFileTreasureStorage.findPrice();



            }

        }
    }
}