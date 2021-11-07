package Controllers.Client;

import Controllers.Controller;
import Models.ClientModel;
import Models.ProductModel;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.concurrent.atomic.AtomicInteger;

public class DeleteClientController extends Controller {

    public void DeleteClient(Table<Object> table, AtomicInteger Id){
        ClientModel.delete(ClientModel.search((String)table.getTableModel().getCell(1,Id.intValue())).firstKey());
        table.getTableModel().removeRow(Id.intValue());
    }

}
