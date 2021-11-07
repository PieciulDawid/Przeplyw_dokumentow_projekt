package Controllers;
import Global.UIManager;
import Views.*;
import Views.Client.ClientView;
import Views.Employee.EmployeeView;
import Views.Product.ProductView;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;

public class MainMenuController extends Controller{
	
	public void Logout() {
		View LoginView = new LoginView(/* ewentualne argumenty konstruktora*/);
		
		UIManager.popWindow();
		UIManager.addWindow(LoginView);
		UIManager.showMessageDialog("", "Wylogowano", MessageDialogButton.OK);
	}

	public void ToProduct(){
		View ProductView = new ProductView(/* ewentualne argumenty konstruktora*/);
		UIManager.hideTop();
		UIManager.addWindow(ProductView);
	}

	public void ToEmployee(){
		View EmployeeView = new EmployeeView(/* ewentualne argumenty konstruktora*/);
		UIManager.hideTop();
		UIManager.addWindow(EmployeeView);
	}

	public void ToClient(){
		View ClientView = new ClientView(/* ewentualne argumenty konstruktora*/);
		UIManager.hideTop();
		UIManager.addWindow(ClientView);
	}

	public void ToAbout() throws InterruptedException {
		View AboutView = new AboutView(/* ewentualne argumenty konstruktora*/);
		UIManager.hideTop();
		UIManager.addWindow(AboutView);
	}
	
}
