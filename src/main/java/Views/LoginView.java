package Views;

import Controllers.LoginController;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.PropertyTheme;
import com.googlecode.lanterna.graphics.SimpleTheme;
import com.googlecode.lanterna.gui2.*;

import java.util.Arrays;


public class LoginView extends View{
	public LoginView() {
		super("Logowanie");

		Panel panel = Panels.horizontal();
		Panel leftPanel = Panels.vertical();
		Panel rightPanel = Panels.vertical();
		panel.addComponent(leftPanel).addComponent(rightPanel);
		
		TextBox login = new TextBox("", TextBox.Style.SINGLE_LINE);
		TextBox password = new TextBox("", TextBox.Style.SINGLE_LINE);
		leftPanel.addComponent(new EmptySpace(new TerminalSize(0,1)));
		rightPanel.addComponent(new EmptySpace(new TerminalSize(0,1)));
		leftPanel.addComponent(new Label("Login"));
		rightPanel.addComponent(login);
		
		leftPanel.addComponent(new Label("Hasło"));
		rightPanel.addComponent(password.setMask('*'));
		
		leftPanel.addComponent(new EmptySpace(new TerminalSize(0,1))); // Empty space underneath labels
		rightPanel.addComponent(new EmptySpace(new TerminalSize(0,1)));
		leftPanel.addComponent(new Button("Wyjdź", () -> {
			((LoginController)Controller).Exit();
		}));
		rightPanel.addComponent(new Button("Zaloguj", () -> {
			((LoginController)Controller).Login(login.getText(), password.getText());
		}));
		
		setHints(Arrays.asList(Window.Hint.CENTERED));
		setComponent(panel);
		setFocusedInteractable(login);
	}
}
