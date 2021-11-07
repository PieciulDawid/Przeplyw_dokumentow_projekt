package Controllers.Client;

import Controllers.Controller;
import Models.ClientModel;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.concurrent.atomic.AtomicInteger;

public class ModifyClientController extends Controller {
    public void ModifyClient(Table<Object> table, String Name, String Adress, String Telnum, AtomicInteger Id){
        ClientModel clientModel = new ClientModel(1, Name, Adress, Integer.parseInt(Telnum));
        clientModel.setId((Integer) table.getTableModel().getCell(0,Id.intValue()));
        ClientModel.modify(clientModel);
        table.getTableModel().setCell(1,Id.intValue(),Name);
        table.getTableModel().setCell(2,Id.intValue(),Adress);
        table.getTableModel().setCell(3,Id.intValue(),Telnum);

    }
}
