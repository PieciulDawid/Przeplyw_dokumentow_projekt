package Views.Product;

import Controllers.Product.AddProductController;
import Controllers.Product.ModifyProductController;
import Models.ProductModel;
import Views.View;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class ModifyProductView extends View {

    public ModifyProductView(Table<Object> table, AtomicInteger Id) {
        super("Modyfikuj produkt");

        String name     = String.valueOf(table.getTableModel().getCell(1,Id.intValue()));
        String price    = String.valueOf(table.getTableModel().getCell(2,Id.intValue()));
        String amount   = String.valueOf(table.getTableModel().getCell(3,Id.intValue()));
        TextBox Name    = new TextBox(name, TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));
        TextBox Price   = new TextBox(price, TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));
        TextBox Amount  = new TextBox(amount, TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));

        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2).setVerticalSpacing(1).setTopMarginSize(1));

        panel.addComponent(new Label("Nazwa"));
        panel.addComponent(Name);

        panel.addComponent(new Label("Cena"));
        panel.addComponent(Price);

        panel.addComponent(new Label("Ilość"));
        panel.addComponent(Amount);

        panel.addComponent(new Button("Anuluj",()->{
            Controller.CancelAction();
        }));

        panel.addComponent(new Button("Modifikuj",()->{

            ((ModifyProductController)Controller).ModifyProduct(table, Name.getText(), Price.getText(), Amount.getText(), Id);
            Controller.CancelAction();
        }));

        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(panel);
    }
}
