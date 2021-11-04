package Global;

import Views.TestView;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public  static void main(String[] args) throws IOException {
        
        UIManager.setup(); // Setup UIManagera
        ControllerCont.TestController.Show(); // Wyświetlenie pierwszego widoku
    }
}
