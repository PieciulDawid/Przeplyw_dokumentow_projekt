package Controllers;

import Global.UIManager;
import Views.AddEmployeeView;
import Views.View;

public class EmployeeController extends Controller {
    public void AddEmployee(){
        View AddEmployeeView = new AddEmployeeView();
        UIManager.addWindow(AddEmployeeView);
    }
}
