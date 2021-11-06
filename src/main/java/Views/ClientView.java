package Views;

import Controllers.ClientController;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import java.util.Arrays;

public class ClientView extends View {
    public ClientView() {
        super("Zarządzanie pracownikami");
        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2));
        panel.addComponent(new EmptySpace(new TerminalSize(0,1)));
        panel.addComponent(new EmptySpace(new TerminalSize(0,1)));

        panel.addComponent(new Button("Dodaj",()->{
            ((ClientController)Controller).AddClient();
        }).setPreferredSize(new TerminalSize(7,1)));
        panel.addComponent(new EmptySpace(new TerminalSize(0,0)));

        panel.addComponent(new Button("Wyświetl"));
        panel.addComponent(new EmptySpace(new TerminalSize(0,0)));

        panel.addComponent(new Button("Modyfikuj"));
        panel.addComponent(new EmptySpace(new TerminalSize(0,0)));

        panel.addComponent(new Button("Usuń "));
        panel.addComponent(new EmptySpace(new TerminalSize(0,0)));

        panel.addComponent(new Button("Dodaj wiele"));
        panel.addComponent(new EmptySpace(new TerminalSize(0,0)));

        panel.addComponent(new EmptySpace(new TerminalSize(0,0)));
        panel.addComponent(new Button("Cofnij",()->{
            Controller.GoBack();
        }));
        panel.addComponent(new EmptySpace(new TerminalSize(0,0)));


        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(panel);
    }
}
