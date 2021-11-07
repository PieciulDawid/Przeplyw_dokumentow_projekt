package Controllers.Client;

import Controllers.Controller;
import Models.ClientModel;
import Models.ProductModel;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.concurrent.atomic.AtomicInteger;

public class DeleteClientController extends Controller {

    public void DeleteClient(Table<Object> table, AtomicInteger Id){
        ClientModel.delete((int)table.getTableModel().getCell(0,Id.intValue()));
        table.getTableModel().removeRow(Id.intValue());
    }

}
