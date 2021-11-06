package Models;

public class ProductModel {
    private int Id;
    private String Name;
    private String Price;
    private String Amount;

    public ProductModel(int id, String name, String price, String amount) {
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
    public String getAmount() {
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
    public void setAmount(String amount) {
        Amount = amount;
    }
}
