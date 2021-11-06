package Controllers.Client;

import Controllers.Controller;
import Global.UIManager;
import Views.Client.AddClientView;
import Views.View;

public class ClientController  extends Controller {
    public void AddClient(){
        View AddEmployeeView = new AddClientView();
        UIManager.addWindow(AddEmployeeView);
    }
}
