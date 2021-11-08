package Views.Client;

import Controllers.Client.ClientController;
import Controllers.Product.ProductController;
import Models.ClientModel;
import Models.ProductModel;
import Views.View;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientView extends View {
    public ClientView() {
        super("Zarządzanie klientami");
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

        searchPanel.addComponent(searchTextBox);

        AtomicInteger Id = new AtomicInteger();

        Table<Object> table = new Table<Object>("");
        Button searchButton = new Button("Szukaj", () -> {((ClientController)Controller).SearchClient(table, searchTextBox.getText());});
        searchPanel.addComponent(searchButton);
        table.setSelectAction(() ->{
            Id.set(table.getSelectedRow());
            actionList.setEnabled(true);
            setFocusedInteractable(actionList);
            searchTextBox.setEnabled(false);
            searchButton.setEnabled(false);

        });

        actionList
                .addItem("Dodaj", () -> {
                    table.setEnabled(true);
                    searchTextBox.setEnabled(true);
                    searchButton.setEnabled(true);
                    setFocusedInteractable(table);
                    actionList.setEnabled(false);
                    ((ClientController)Controller).AddClient(table);
                })
                .addItem("Modyfikuj", () -> {
                    table.setEnabled(true);
                    searchTextBox.setEnabled(true);
                    searchButton.setEnabled(true);
                    setFocusedInteractable(table);
                    actionList.setEnabled(false);
                    ((ClientController)Controller).ModifyClient(table, Id);
                })
                .addItem("Usuń", () -> {
                    table.setEnabled(true);
                    searchTextBox.setEnabled(true);
                    searchButton.setEnabled(true);
                    setFocusedInteractable(table);
                    actionList.setEnabled(false);
                    ((ClientController)Controller).DeleteClient(table, Id);
                })
                .setPreferredSize(new TerminalSize(10,25))
                .setEnabled(false);
    
        ((ClientController)Controller).SearchClient(table, "");

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