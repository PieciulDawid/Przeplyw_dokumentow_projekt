package Controllers;
import Global.UIManager;
import Views.*;

public class MainMenuController extends Controller{
	
	public void Logout() {
		View TestView = new TestView(/* ewentualne argumenty konstruktora*/);
		
		UIManager.popWindow();
		UIManager.addWindow(TestView);
	}

	public void ToProduct(){
		View ProductView = new ProductView(/* ewentualne argumenty konstruktora*/);

		UIManager.popWindow();
		UIManager.addWindow(ProductView);
	}
	
}
