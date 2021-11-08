package Controllers.Employee;

import Controllers.Controller;
import Models.EmployeeModel;
import Models.ProductModel;
import com.googlecode.lanterna.gui2.table.Table;

public class AddEmployeeController  extends Controller {
    public void AddEmployee(Table<Object> table, String Name, String Surname, String Login, String Password){
        EmployeeModel employeeModel = new EmployeeModel(1, Name, Surname, Login, Password);
        EmployeeModel.add(employeeModel);
        table.getTableModel().addRow(employeeModel.toTableRow());
    }
}
