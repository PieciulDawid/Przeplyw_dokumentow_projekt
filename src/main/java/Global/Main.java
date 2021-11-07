package Global;

import Backend.DBActivities;
import Models.ProductModel;
import Views.CRUDView;
import Views.LoginView;

import java.io.IOException;

public class Main {

    public  static void main(String[] args) throws IOException {
        //  Test bazy danych dla products
        /*
            DBActivities.getProducts().forEach((x, y) -> System.out.println(y));
            DBActivities.searchProducts("pap").forEach((x, y) -> System.out.println(y));
            DBActivities.deleteProduct(5);
            DBActivities.getProducts().forEach((x, y) -> System.out.println(y));
            DBActivities.searchProducts("pap").forEach((x, y) -> System.out.println(y));
            DBActivities.addProduct(new ProductModel(1, "papaja", (float)18.99, 5));
            DBActivities.getProducts().forEach((x, y) -> System.out.println(y));
            DBActivities.searchProducts("pap").forEach((x, y) -> System.out.println(y));
            System.out.println(DBActivities.getProduct(4));
            ProductModel item = DBActivities.getProduct(1);
            item.setAmount(item.getAmount()+1);
            DBActivities.modifyProduct(item);
            DBActivities.getProducts().forEach((x, y) -> System.out.println(y));
            DBActivities.saveChangesProduct();
        */
        
        //  Test logowania
        /*
            System.out.println(DBActivities.login("admin","admin"));
            System.out.println(DBActivities.getLoggedUser());
            DBActivities.logout();
            System.out.println(DBActivities.getLoggedUser());
            System.out.println(DBActivities.login("", ""));
            DBActivities.logout();
            System.out.println(DBActivities.getLoggedUser());
        */
        
        /*DBActivities.addProduct(new ProductModel(12, "perwol", (float)12.89,4));
        DBActivities.getProducts().stream().forEachOrdered(System.out::println);
        DBActivities.saveChangesProduct();*/
        
        /*UIManager.setup(); // Setup UIManagera
        UIManager.addWindow(new CRUDView()); // Wyświetlenie pierwszego widoku*/
    }
}
