package Views.Product;

import Controllers.Product.ProductController;
import Views.View;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import java.util.Arrays;


public class ProductView extends View {
    public ProductView() {
        super("Zarządzanie produktami");
        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2));
        panel.addComponent(new EmptySpace(new TerminalSize(0,1)));
        panel.addComponent(new EmptySpace(new TerminalSize(0,1)));

        panel.addComponent(new Button("Dodaj",()->{
            ((ProductController)Controller).AddProduct();

        }).setPreferredSize(new TerminalSize(7,1)));
        panel.addComponent(new EmptySpace(new TerminalSize(0,0)));

        panel.addComponent(new Button("Wyświetl"));
        panel.addComponent(new EmptySpace(new TerminalSize(0,0)));

        panel.addComponent(new Button("Modyfikuj"));
        panel.addComponent(new EmptySpace(new TerminalSize(0,0)));

        panel.addComponent(new Button("Usuń").setPreferredSize(new TerminalSize(6,1)));
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
