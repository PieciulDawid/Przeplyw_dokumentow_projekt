package Views;

import Global.ControllerCont;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import java.util.Arrays;


public class TestView extends View{
	public TestView() {
		super();
		Panel panel = new Panel();
		panel.setLayoutManager(new GridLayout(2));
		
		
		TextBox login = new TextBox("", TextBox.Style.SINGLE_LINE);
		TextBox password = new TextBox("", TextBox.Style.SINGLE_LINE);
		
		panel.addComponent(new Label("Login"));
		panel.addComponent(login);
		
		panel.addComponent(new Label("Password"));
		panel.addComponent(password.setMask('*'));
		
		panel.addComponent(new EmptySpace(new TerminalSize(0,0))); // Empty space underneath labels
		
		panel.addComponent(new Button("Submit", () -> {
			// TODO walidacja
			System.out.println(login.getText() + password.getText());
			ControllerCont.TestController.Login(login.getText(), password.getText());
		}));
		
		setHints(Arrays.asList(Window.Hint.CENTERED));
		setComponent(panel);
	}
}
