package Controllers;
import Global.UIManager;
import Views.*;
import Views.Client.ClientView;
import Views.Employee.EmployeeView;
import Views.Product.ProductView;

public class MainMenuController extends Controller{
	
	public void Logout() {
		View TestView = new LoginView(/* ewentualne argumenty konstruktora*/);
		
		UIManager.popWindow();
		UIManager.addWindow(TestView);
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

	public void ToAbout(){
		View AboutView = new AboutView(/* ewentualne argumenty konstruktora*/);
		UIManager.hideTop();
		UIManager.addWindow(AboutView);
	}
	
}
