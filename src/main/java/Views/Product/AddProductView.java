package Views.Product;

import Views.View;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import java.util.Arrays;

public class AddProductView extends View {
    public AddProductView() {
        super("Dodaj nowy produkt");

        TextBox Name = new TextBox("", TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));
        TextBox Price = new TextBox("", TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));
        TextBox Amount = new TextBox("", TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));

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

        panel.addComponent(new Button("Dodaj"));

        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(panel);
    }
}
