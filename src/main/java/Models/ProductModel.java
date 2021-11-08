package Models;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductModel implements Model {
    private int Id;
    private String Name;
    private float Price;
    private int Amount;

    public ProductModel(int id, String name, float price, int amount) {
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
    public float getPrice() {
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
    public void setPrice(float price) {
        Price = price;
    }
    public void setAmount(int amount) {
        Amount = amount;
    }
    
    @Override
    public String toString() {
        return "ProductModel{" + "Id=" + Id + ", Name='" + Name + '\'' + ", Price=" + Price + ", Amount=" + Amount + '}';
    }
    
    public Object[] toTableRow() {
        return new Object[] { (Integer)Id, Name, (Float)Price, (Integer)Amount };
    }

    private static TreeMap<Integer,ProductModel> productModels = null;

    public static TreeMap<Integer,ProductModel> getAll() {
        if(productModels != null) {
            return productModels;
        }

        try {
            List<String[]> productsRaw = new CSVReader(new FileReader("products.csv")).readAll();
            productModels = productsRaw.stream()
                    .map((String[] raw)->
                            new ProductModel(
                                    Integer.parseInt(raw[0]),
                                    raw[1],
                                    Float.parseFloat(raw[2]),
                                    Integer.parseInt(raw[3])
                            ))
                    .collect(Collectors.toMap(
                            ProductModel::getId,
                            Function.identity(),
                            (a, b)-> a,
                            TreeMap::new));
        }
        catch(IOException | CsvException e) {
            e.printStackTrace();
        }

        return productModels;
    }

    public static TreeMap<Integer,ProductModel> search(String keyword) {
        String keywordLowerCase = keyword.toLowerCase(Locale.ROOT);
        TreeMap<Integer,ProductModel> result = getAll().values().stream()
                .filter((ProductModel item)->
                        item.getName().toLowerCase(Locale.ROOT).startsWith(keywordLowerCase))
                .collect(Collectors.toMap(
                        ProductModel::getId,
                        Function.identity(),
                        (a, b)-> a,
                        TreeMap::new));
        return result;
    }

    public static ProductModel get(int id) {
        return getAll().get(id);
    }

    public static void add(ProductModel product) {
        TreeMap<Integer,ProductModel> products = getAll();
        product.setId(products.lastKey()+1);
        products.put(product.getId(), product);
        saveChanges();
    }

    public static void modify(ProductModel product) {
        getAll().replace(product.getId(), product);
        saveChanges();
    }


    public static void delete(ProductModel product) {
        getAll().remove(product.getId());
        saveChanges();
    }

    public static void delete(int id) {
        getAll().remove(id);
        saveChanges();
    }

    public static void saveChanges() {
        TreeMap<Integer,ProductModel> products = getAll();
        try {
            ICSVWriter writer = new CSVWriterBuilder(new FileWriter("products.csv")).build();
            List<String[]> rawProducts = products.values().stream()
                    .map((ProductModel product)->{
                        String[] rawProduct = new String[4];
                        rawProduct[0] = String.valueOf(product.getId());
                        rawProduct[1] = product.getName();
                        rawProduct[2] = String.valueOf(product.getPrice());
                        rawProduct[3] = String.valueOf(product.getAmount());
                        return rawProduct;
                    })
                    .collect(Collectors.toList());

            writer.writeAll(rawProducts);
            writer.flushQuietly();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static ProductModel getLast(){
        return  getAll().get(getAll().lastKey());
    }
}
