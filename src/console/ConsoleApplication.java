package console;

import entity.Treasure;
import service.TreasureService;
import storage.InFileTreasureStorage;

import java.io.IOException;
import java.util.*;

import static console.ConsoleReader.readInteger;
import static console.ConsoleReader.readString;
import static console.ConsoleWriter.writer;

public class ConsoleApplication {
    InFileTreasureStorage inFileTreasureStorage = new InFileTreasureStorage();
    TreasureService treasureService = new TreasureService();

    public void run(){

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
                    break;
                case 2:
                    List<Treasure> all = inFileTreasureStorage.findAll();
                    ListIterator<Treasure> listIterator = all.listIterator();
                    while (listIterator.hasNext()) {
                        writer(listIterator.next().toString());
                    }

                    break;
                case 3:
                    Optional<Treasure> treasureMaxPrice = inFileTreasureStorage.findTreasureMaxPrice();
                    if(treasureMaxPrice.isPresent()) {
                        writer(treasureMaxPrice.get().toString());
                    }else{
                        writer("Treasure not found");
                    }


            }

        }
    }
}