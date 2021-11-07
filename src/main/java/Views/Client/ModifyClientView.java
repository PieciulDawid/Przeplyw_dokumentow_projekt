package Views.Client;

import Controllers.Product.ModifyProductController;
import Views.View;
import Controllers.Client.ModifyClientController;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class ModifyClientView extends View {
    public ModifyClientView(Table<Object> table, AtomicInteger Id) {
        super("Zmień klienta");

        String email     = String.valueOf(table.getTableModel().getCell(1,Id.intValue()));
        String address    = String.valueOf(table.getTableModel().getCell(2,Id.intValue()));
        String telnum   = String.valueOf(table.getTableModel().getCell(3,Id.intValue()));
        TextBox Email    = new TextBox(email, TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));
        TextBox Address   = new TextBox(address, TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));
        TextBox Telnum  = new TextBox(telnum, TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));

        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2).setVerticalSpacing(1).setTopMarginSize(1));
        panel.addComponent(new Label("Email"));
        panel.addComponent(Email);

        panel.addComponent(new Label("Adres"));
        panel.addComponent(Address);

        panel.addComponent(new Label("Numer telefonu"));
        panel.addComponent(Telnum);

        panel.addComponent(new Button("Anuluj",()->{
            Controller.CancelAction();
        }));

        panel.addComponent(new Button("Modifikuj",()->{

            ((ModifyClientController)Controller).ModifyClient(table, Email.getText(), Address.getText(), Telnum.getText(), Id);
            Controller.CancelAction();
        }));

        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(panel);
    }

}
