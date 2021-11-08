package Controllers.Employee;

import Controllers.Controller;
import Global.UIManager;
import Models.ClientModel;
import Models.EmployeeModel;
import Views.Employee.AddEmployeeView;
import Views.Employee.DeleteEmployeeView;
import Views.Employee.ModifyEmployeeView;
import Views.Product.AddProductView;
import Views.Product.DeleteProductView;
import Views.Product.ModifyProductView;
import Views.View;
import com.googlecode.lanterna.gui2.table.Table;
import com.googlecode.lanterna.gui2.table.TableModel;

import java.util.concurrent.atomic.AtomicInteger;

public class EmployeeController extends Controller {

    public void AddEmployee(Table<Object> table){
        View AddEmployeeView = new AddEmployeeView(table);
        UIManager.addWindow(AddEmployeeView);
    }
    public void DeleteEmployee(Table<Object> table, AtomicInteger Id){
        View DeleteEmployeeView = new DeleteEmployeeView(table, Id);
        UIManager.addWindow(DeleteEmployeeView);
    }
    public void ModifyEmployee(Table<Object> table, AtomicInteger Id){
        View ModifyEmployeetView = new ModifyEmployeeView(table, Id);
        UIManager.addWindow(ModifyEmployeetView);
    }
    
    public void SearchEmployee(Table<Object> table, String keyword){
        TableModel<Object> searchedProducts = new TableModel<>("ID", "Imię", "Nazwisko");
        EmployeeModel.search(keyword).values()
                .stream()
                .map(EmployeeModel::toTableRow)
                .forEachOrdered(searchedProducts::addRow);
        table.setTableModel(searchedProducts);
    }
}
