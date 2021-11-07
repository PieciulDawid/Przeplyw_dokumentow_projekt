package Controllers.Client;

import Controllers.Controller;
import Models.ClientModel;
import Models.ProductModel;
import com.googlecode.lanterna.gui2.table.Table;

public class AddClientController extends Controller {
    public void AddClient(Table<Object> table, String Email, String Address, String TelephonNumber){
        ClientModel clientModel = new ClientModel(1, Email, Address, Integer.parseInt(TelephonNumber));
        ClientModel.add(clientModel);
        table.getTableModel().addRow(clientModel.toTableRow());
    }
}
