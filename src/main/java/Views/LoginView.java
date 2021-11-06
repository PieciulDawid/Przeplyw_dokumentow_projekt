package Views;

import Controllers.LoginController;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import java.util.Arrays;


public class LoginView extends View{
	public LoginView() {
		super("Logowanie");
		Panel panel = new Panel();
		panel.setLayoutManager(new GridLayout(2));
		
		
		TextBox login = new TextBox("", TextBox.Style.SINGLE_LINE);
		TextBox password = new TextBox("", TextBox.Style.SINGLE_LINE);
		panel.addComponent(new EmptySpace(new TerminalSize(0,1)));
		panel.addComponent(new EmptySpace(new TerminalSize(0,1)));
		panel.addComponent(new Label("Login"));
		panel.addComponent(login);
		
		panel.addComponent(new Label("Hasło"));
		panel.addComponent(password.setMask('*'));
		
		panel.addComponent(new EmptySpace(new TerminalSize(0,0))); // Empty space underneath labels
		panel.addComponent(new EmptySpace(new TerminalSize(0,1)));
		panel.addComponent(new EmptySpace(new TerminalSize(0,1)));
		panel.addComponent(new Button("Zaloguj", () -> {
			// TODO walidacja
			
			((LoginController)Controller).Login(login.getText(), password.getText());
		}));
		
		setHints(Arrays.asList(Window.Hint.CENTERED));
		setComponent(panel);
	}
}
