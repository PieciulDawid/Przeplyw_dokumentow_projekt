package Views;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.Arrays;

public class CRUDView extends View{
	public CRUDView() {
		super("CRUD");
		Panel basePanel = new Panel();
		basePanel.setLayoutManager(new GridLayout(2));
		basePanel.addComponent(new ActionListBox()
				.addItem("Akcja1", () -> {return;})
				.addItem("Akcja2", () -> {return;})
				.addItem("Akcja3", () -> {return;})
				.addItem("Akcja4", () -> {return;})
				.setPreferredSize(new TerminalSize(10,25))
		);
		
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
		
		Table<String> table = new Table<>("Imie", "Nazwisko");
		table.getTableModel()
				.addRow("Adrian", "Nowak")
				.addRow("Jan", "Kowalski");
		
		searchAndTablePanel.addComponent(table
				.setPreferredSize(new TerminalSize(50, 20))
				.withBorder(Borders.singleLine("Elementy"))
		);
		
		setHints(Arrays.asList(Window.Hint.CENTERED));
		setComponent(basePanel);
	}
}
