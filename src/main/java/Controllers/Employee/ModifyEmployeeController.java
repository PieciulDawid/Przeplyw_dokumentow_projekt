package Controllers.Employee;

import Controllers.Controller;
import Models.EmployeeModel;
import Models.ProductModel;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.concurrent.atomic.AtomicInteger;

public class ModifyEmployeeController extends Controller {
    public void ModifyEmployee(Table<Object> table, String Name, String Surname,String Login, String Password, AtomicInteger Id){
        EmployeeModel employeeModel = new EmployeeModel(1, Name, Surname, Login, Password);
        employeeModel.setId((Integer) table.getTableModel().getCell(0,Id.intValue()));
        EmployeeModel.modify(employeeModel);
        table.getTableModel().setCell(1,Id.intValue(),Name);
        table.getTableModel().setCell(2,Id.intValue(),Surname);

    }
}
