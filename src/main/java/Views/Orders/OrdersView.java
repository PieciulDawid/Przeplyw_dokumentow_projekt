package Views.Orders;

import Views.View;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import java.util.Arrays;

public class OrdersView extends View {
    public OrdersView() {
        super("Zamówienia");

        Panel panel = Panels.vertical();

        panel.addComponent(new EmptySpace(new TerminalSize(0,1)));
        panel.addComponent(new Label("Ten moduł zostanie zaimplementowany w przyszłości."));
        panel.addComponent(new EmptySpace(new TerminalSize(0,1)));
        Panel panel2 = Panels.horizontal();
        panel2.addComponent(new EmptySpace(new TerminalSize(21,1)));
        panel2.addComponent(new Button("Cofnij",()->{
            Controller.CancelAction();
        }));
        panel.addComponent(panel2);


        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(panel);
    }


}
