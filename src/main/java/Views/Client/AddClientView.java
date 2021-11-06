package Views.Client;

import Views.View;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import java.util.Arrays;

public class AddClientView extends View {
    public AddClientView() {
        super("Dodaj nowego klienta");

        TextBox Name    = new TextBox("", TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));
        TextBox Surname = new TextBox("", TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));
        TextBox Id   = new TextBox("", TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));
        TextBox Orders  = new TextBox("", TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));

        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2).setVerticalSpacing(1).setTopMarginSize(1));

        panel.addComponent(new Label("Imie"));
        panel.addComponent(Name);

        panel.addComponent(new Label("Nazwisko"));
        panel.addComponent(Surname);

        panel.addComponent(new Label("Pesel"));
        panel.addComponent(Id);

        panel.addComponent(new Label("Zamówienia"));
        panel.addComponent(Orders);

        panel.addComponent(new Button("Anuluj",()->{
            Controller.CancelAction();
        }));

        panel.addComponent(new Button("Dodaj"));

        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(panel);
    }
}
