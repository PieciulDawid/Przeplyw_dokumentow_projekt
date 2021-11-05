package Views;

import Controllers.*;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import java.util.Arrays;

public class MainMenuView extends View {
	
	public MainMenuView() {
		super();
		Panel panel = new Panel();
		panel.setLayoutManager(new GridLayout(2));
		
		
		panel.addComponent(new Label("Zalogowano!"));
		panel.addComponent(new EmptySpace(new TerminalSize(0,0))); // Empty space underneath labels
		
		
		panel.addComponent(new Button("Wyloguj", () ->{
			((MainMenuController)Controller).Logout();
		}));
		
		
		setHints(Arrays.asList(Window.Hint.CENTERED));
		setComponent(panel);
	}
}
