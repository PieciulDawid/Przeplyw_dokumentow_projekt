package Views.Product;

import Controllers.Product.ProductController;
import Views.View;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.Arrays;


public class ProductView extends View {
    public ProductView() {
        super("Zarządzanie produktami");
        Panel basePanel = new Panel();
        basePanel.setLayoutManager(new GridLayout(2));

        ActionListBox actionList = new ActionListBox();
        basePanel.addComponent(actionList);

        Panel searchAndTablePanel = new Panel();
        searchAndTablePanel.setLayoutManager(new LinearLayout(Direction.VERTICAL));
        searchAndTablePanel.setPreferredSize(new TerminalSize(50,25));
        basePanel.addComponent(searchAndTablePanel);

        Panel searchPanel = new Panel();
        searchPanel.setLayoutManager(new LinearLayout(Direction.HORIZONTAL));
        searchAndTablePanel.addComponent(searchPanel
                .withBorder(Borders.singleLine("Wyszukiwanie"))
                .setPreferredSize(new TerminalSize(50, 3))
        );

        TextBox searchTextBox = new TextBox().setPreferredSize(new TerminalSize(40,1));
        Button searchButton = new Button("Szukaj", () -> {return;});

        searchPanel.addComponent(searchTextBox);
        searchPanel.addComponent(searchButton);

        Table<Object> table = new Table<Object>("Imie", "Nazwisko");
        table.setSelectAction(() ->{
            actionList.setEnabled(true);
            setFocusedInteractable(actionList);
            searchTextBox.setEnabled(false);
            searchButton.setEnabled(false);
            // TODO tworzenie i przekazanie modelu
        });

        actionList
                .addItem("Akcja1", () -> {
                    table.setEnabled(true);
                    searchTextBox.setEnabled(true);
                    searchButton.setEnabled(true);
                    setFocusedInteractable(table);
                    actionList.setEnabled(false);
                })
                .addItem("Akcja2", () -> {
                    table.setEnabled(true);
                    searchTextBox.setEnabled(true);
                    searchButton.setEnabled(true);
                    setFocusedInteractable(table);
                    actionList.setEnabled(false);
                })
                .addItem("Akcja3", () -> {
                    table.setEnabled(true);
                    searchTextBox.setEnabled(true);
                    searchButton.setEnabled(true);
                    setFocusedInteractable(table);
                    actionList.setEnabled(false);
                })
                .addItem("Akcja4", () -> {
                    table.setEnabled(true);
                    searchTextBox.setEnabled(true);
                    searchButton.setEnabled(true);
                    setFocusedInteractable(table);
                    actionList.setEnabled(false);
                })
                .setPreferredSize(new TerminalSize(10,25))
                .setEnabled(false);


        table.getTableModel()
                .addRow("Adrian", "Nowak")
                .addRow("Jan", "Kowalski");

        searchAndTablePanel.addComponent(table
                .setPreferredSize(new TerminalSize(50, 20))
                .withBorder(Borders.singleLine("Elementy"))
        );

        basePanel.addComponent(new Button("Cofnij",()->{
            Controller.GoBack();
        }));

        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(basePanel);
    }
}
