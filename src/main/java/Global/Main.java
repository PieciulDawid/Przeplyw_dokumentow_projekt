package Global;

import Views.CRUDView;

import java.io.IOException;

public class Main {

    public  static void main(String[] args) throws IOException {
        
        UIManager.setup(); // Setup UIManagera
        UIManager.addWindow(new CRUDView()); // Wyświetlenie pierwszego widoku
    }
}
