package Models;

public class ProductModel {
    private int Id;
    private String Name;
    private String Price;
    private int Amount;

    public ProductModel(int id, String name, String price, int amount) {
        Id = id;
        Name = name;
        Price = price;
        Amount = amount;
    }

    //Getters
    public int getId() {
        return Id;
    }
    public String getName() {
        return Name;
    }
    public String getPrice() {
        return Price;
    }
    public int getAmount() {
        return Amount;
    }

    //Setters
    public void setId(int id) {
        Id = id;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setPrice(String price) {
        Price = price;
    }
    public void setAmount(int amount) {
        Amount = amount;
    }
}
