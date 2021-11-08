package Controllers.Employee;

import Controllers.Controller;
import Models.EmployeeModel;
import Models.ProductModel;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.concurrent.atomic.AtomicInteger;

public class DeleteEmployeeController extends Controller {
    public void DeleteEmployee(Table<Object> table, AtomicInteger Id){
        EmployeeModel.delete(EmployeeModel.search((String)table.getTableModel().getCell(1,Id.intValue())).firstKey());
        table.getTableModel().removeRow(Id.intValue());
    }
}
