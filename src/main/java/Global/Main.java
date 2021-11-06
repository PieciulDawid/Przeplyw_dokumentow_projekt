package Global;

import Backend.DBActivities;
import Models.ProductModel;
import Views.CRUDView;
import Views.LoginView;

import java.io.IOException;

public class Main {

    public  static void main(String[] args) throws IOException {
        
        DBActivities.getProducts().stream().forEachOrdered(System.out::println);
        
        /*DBActivities.addProduct(new ProductModel(12, "perwol", (float)12.89,4));
        DBActivities.getProducts().stream().forEachOrdered(System.out::println);
        DBActivities.saveChangesProduct();*/
        
        /*UIManager.setup(); // Setup UIManagera
        UIManager.addWindow(new CRUDView()); // Wyświetlenie pierwszego widoku*/
    }
}
