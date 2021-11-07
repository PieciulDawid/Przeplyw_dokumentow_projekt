package Controllers;

import Global.UIManager;
import Models.EmployeeModel;
import Views.MainMenuView;
import Views.LoginView;
import Views.View;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;

import java.util.Objects;

public class LoginController extends Controller{
	public void Show() {
		UIManager.addWindow(new LoginView());
	}
	public void Login(String login, String password) {
		// weryfikacja, czyli logowanie
		if(EmployeeModel.login(login, password) == null) {
			View LoginView = new LoginView();
			UIManager.popWindow();
			UIManager.addWindow(LoginView);
			UIManager.showMessageDialog("", "Błąd logowania", MessageDialogButton.OK);
			return;
		}
		
		// zalogowano więc towrzymy model pracownika poprzez wywołanie backendowej rzeczy
		
		// Dodanie na szczyt stosu okna z głównym menu
		// (i wyjątkowo w tym przypadku zabranie ze stosu poprzedniego widoku)
		
		View MainMenu = new MainMenuView(/* ewentualne argumenty konstruktora*/);
		UIManager.popWindow();
		UIManager.addWindow(MainMenu); // widok zawsze powinien być tworzony przez popowaniem poprzedniego
	}
}
