package Views;

import Controllers.MainMenuController;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import java.util.Arrays;

public class MainMenuView extends View {
	
	public MainMenuView() {
		super("Menu");
		Panel panel = new Panel();
		panel.setLayoutManager(new GridLayout(2));
		panel.addComponent(new Label("Zalogowano : "));
		panel.addComponent(new Label("lukasz"));
		panel.addComponent(new EmptySpace(new TerminalSize(0,1)));
		panel.addComponent(new EmptySpace(new TerminalSize(0,1)));

		/*panel.addComponent(new Button("Produkty", ()->{
			((MainMenuController)Controller).ToProduct();
		}));
		panel.addComponent(new EmptySpace(new TerminalSize(0,0)));

		panel.addComponent(new Button("Klienci"));
		panel.addComponent(new EmptySpace(new TerminalSize(0,0)));

		panel.addComponent(new Button("Pracownicy", ()->{
			((MainMenuController)Controller).ToEmployee();
		}));
		panel.addComponent(new EmptySpace(new TerminalSize(0,0)));

		panel.addComponent(new Button("Zamowienia"));
		panel.addComponent(new EmptySpace(new TerminalSize(0,0)));*/

		panel.addComponent(new ActionListBox()
				.addItem("Produkty", ()->{
					((MainMenuController)Controller).ToProduct();
				})
				.addItem("Kilenci", () -> {
					((MainMenuController)Controller).ToClient();})
				.addItem("Pracownicy", ()->{
					((MainMenuController)Controller).ToEmployee();
				})
				.addItem("Zamowienia", () -> {return;})
				.addItem("O nas", ()->{
					((MainMenuController)Controller).ToAbout();
				})
		);
		
		
		panel.addComponent(new EmptySpace(new TerminalSize(0,2)));
		panel.addComponent(new EmptySpace(new TerminalSize(0,2)));

		panel.addComponent(new EmptySpace(new TerminalSize(0,0))); // Empty space underneath labels
		panel.addComponent(new EmptySpace(new TerminalSize(0,0)));
		panel.addComponent(new Button("Wyloguj", () ->{
			((MainMenuController)Controller).Logout();
		}));
		
		
		setHints(Arrays.asList(Window.Hint.CENTERED));
		setComponent(panel);
	}
}
