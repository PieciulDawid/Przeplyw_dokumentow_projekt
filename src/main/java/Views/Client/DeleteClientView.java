package Views.Client;

import Controllers.Client.DeleteClientController;
import Controllers.Product.DeleteProductController;
import Views.View;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class DeleteClientView extends View {

    public DeleteClientView(Table<Object> table, AtomicInteger Id) {
        super("Usuń klienta");

        Panel panel = new Panel();
        panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
        panel.setLayoutManager(new LinearLayout(Direction.VERTICAL));
        panel.addComponent(new Label("Czy na pewno chcesz usunąć?"));
        panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
        Panel panel2 = new Panel();
        panel.addComponent(panel2);
        panel2.setLayoutManager(new LinearLayout(Direction.HORIZONTAL));
        panel2.addComponent(new EmptySpace(new TerminalSize(0, 1)));


        panel2.addComponent(new Button("Anuluj", () -> {
            Controller.CancelAction();
        }));
        panel2.addComponent(new EmptySpace(new TerminalSize(7, 1)));
        panel2.addComponent(new Button("Usuń", () -> {

            ((DeleteClientController) Controller).DeleteClient(table, Id);
            /*table.getTableModel().*/
            Controller.CancelAction();
        }));

        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(panel);
    }
}
