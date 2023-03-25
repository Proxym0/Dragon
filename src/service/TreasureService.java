package service;

import entity.Treasure;
import storage.InFileTreasureStorage;

public class TreasureService {
    InFileTreasureStorage inFileTreasureStorage = new InFileTreasureStorage();

    public void create(Treasure treasure) {
        inFileTreasureStorage.save(treasure);

    }
}
