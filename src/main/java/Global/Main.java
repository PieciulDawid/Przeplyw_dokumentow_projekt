package Global;

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
        UIManager.setup(); // Setup UIManagera
        UIManager.addWindow(new LoginView()); // Wyświetlenie pierwszego widoku
    }
}


