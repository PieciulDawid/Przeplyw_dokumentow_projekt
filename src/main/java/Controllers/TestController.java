package Controllers;

import Global.UIManager;
import Views.MainMenuView;
import Views.TestView;
import Views.View;

import java.util.Objects;

public class TestController extends Controller{
	public void Show() {
		UIManager.addWindow(new TestView());
	}
	public void Login(String login, String password) {
		// weryfikacja, czyli logowanie
		if(!Objects.equals(login, "admin") && !Objects.equals(password, "admin")) {
			return;
		}
		
		// zalogowano więc towrzymy model pracownika poprzez wywołanie backendowej rzeczy
		
		// Dodanie na szczyt stosu okna z głównym menu
		// (i wyjątkowo w tym przypadku zabranie ze stosu poprzedniego widoku)
		
		View MainMenu = new MainMenuView(/* ewentualne argumenty konstruktora*/);
		UIManager.popWindow();
		UIManager.addWindow(MainMenu);
	}
}
