package Views.Client;

import Controllers.Client.AddClientController;
import Controllers.Product.AddProductController;
import Views.View;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.Arrays;

public class AddClientView extends View {
    public AddClientView(Table<Object> table) {
        super("Dodaj nowego klienta");

        TextBox Email = new TextBox("", TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));
        TextBox Address = new TextBox("", TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));
        TextBox TelephoneNumber = new TextBox("", TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));

        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2).setVerticalSpacing(1).setTopMarginSize(1));

        panel.addComponent(new Label("Email"));
        panel.addComponent(Email);

        panel.addComponent(new Label("Adres"));
        panel.addComponent(Address);

        panel.addComponent(new Label("numer telefonu"));
        panel.addComponent(TelephoneNumber);

        panel.addComponent(new Button("Anuluj",()->{
            Controller.CancelAction();
        }));

        panel.addComponent(new Button("Dodaj",()->{

            ((AddClientController)Controller).AddClient(table, Email.getText(), Address.getText(), TelephoneNumber.getText());
            Controller.CancelAction();
        }));

        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(panel);
    }
}
