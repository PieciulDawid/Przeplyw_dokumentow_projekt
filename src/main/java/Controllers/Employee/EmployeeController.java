package Controllers.Employee;

import Controllers.Controller;
import Global.UIManager;
import Views.Employee.AddEmployeeView;
import Views.View;

public class EmployeeController extends Controller {
    public void AddEmployee(){
        View AddEmployeeView = new AddEmployeeView();
        UIManager.addWindow(AddEmployeeView);
    }
}
