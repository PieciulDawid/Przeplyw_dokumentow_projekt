package Controllers;

import Global.UIManager;
import Views.AddClientView;
import Views.AddEmployeeView;
import Views.View;

public class ClientController  extends Controller {
    public void AddClient(){
        View AddEmployeeView = new AddClientView();
        UIManager.addWindow(AddEmployeeView);
    }
}
