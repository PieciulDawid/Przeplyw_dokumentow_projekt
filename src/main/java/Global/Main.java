package Global;

import Backend.DBActivities;
import Models.EmployeeModel;
import Models.ProductModel;
import Views.CRUDView;
import Views.LoginView;

import java.io.IOException;

public class Main {

    public  static void main(String[] args) throws IOException {
        System.out.println("____________________     ________  ________       ________ __________ \n" +
                "\\______   \\______   \\    \\______ \\ \\______ \\      \\______ \\\\______   \\\n" +
                " |    |  _/|    |  _/     |    |  \\ |    |  \\      |    |  \\|     ___/\n" +
                " |    |   \\|    |   \\     |    `   \\|    `   \\     |    `   \\    |    \n" +
                " |______  /|______  /____/_______  /_______  /____/_______  /____|    \n" +
                "        \\/        \\/_____/       \\/        \\/_____/       \\/          \n" +
                "\n" +
                "|--------------------------------------------------------------------|\n" +
                "|      Bartłomiej Busłowski    Dawid Dmitruk     Dawid Pieciul       |\n" +
                "|--------------------------------------------------------------------|");
        //  Test bazy danych dla ProductModel
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
        // Test bazy danych dla EmployeeModel
        /*
        EmployeeModel.getAll().forEach((x, y) -> System.out.println(y));
        EmployeeModel.add(new EmployeeModel(0, "Piotr", "Koło", "kolo", "okrag"));
        EmployeeModel.add(new EmployeeModel(0, "Piotr", "Okrąg", "okrag", "kolo"));
        EmployeeModel.searchEmployee("piot").forEach((x, y) -> System.out.println(y));
        EmployeeModel.delete(3);
        EmployeeModel.searchEmployee("piot").forEach((x, y) -> System.out.println(y));
        EmployeeModel.saveChanges();
       */
        
        /*DBActivities.addProduct(new ProductModel(12, "perwol", (float)12.89,4));
        DBActivities.getProducts().stream().forEachOrdered(System.out::println);
        DBActivities.saveChangesProduct();*/
        
        UIManager.setup(); // Setup UIManagera
        UIManager.addWindow(new LoginView()); // Wyświetlenie pierwszego widoku
    }
}


