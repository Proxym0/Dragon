package entity;

public class Treasure {
    private String nameTreasure;
    private int priceTreasure;

    public Treasure() {
    }

    public Treasure(String nameTreasure, int priceTreasure) {
        this.nameTreasure = nameTreasure;
        this.priceTreasure = priceTreasure;
    }

    public String getNameTreasure() {
        return nameTreasure;
    }

    public int getPrice() {
        return priceTreasure;
    }

    public void setNameTreasure(String nameTreasure) {
        this.nameTreasure = nameTreasure;
    }

    public void setPriceTreasure(int priceTreasure) {
        this.priceTreasure = priceTreasure;
    }

    @Override
    public String toString() {
        return "Treasure{" +
                "nameTreasure='" + nameTreasure + '\'' +
                ", priceTreasure=" + priceTreasure +
                '}';
    }
}
