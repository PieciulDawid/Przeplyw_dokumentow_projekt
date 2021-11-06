package Global;

import Views.CRUDView;
import Views.LoginView;

import java.io.IOException;

public class Main {

    public  static void main(String[] args) throws IOException {
        
        UIManager.setup(); // Setup UIManagera
        UIManager.addWindow(new LoginView()); // Wyświetlenie pierwszego widoku
    }
}
