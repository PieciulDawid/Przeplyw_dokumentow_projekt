package Controllers.Client;

import Controllers.Controller;
import Controllers.Client.ModifyClientController;
import Global.UIManager;
import Models.ClientModel;
import Views.Client.AddClientView;
import Views.Client.DeleteClientView;
import Views.Client.ModifyClientView;
import Views.Product.ModifyProductView;
import Views.View;
import com.googlecode.lanterna.gui2.table.Table;
import com.googlecode.lanterna.gui2.table.TableModel;

import java.util.concurrent.atomic.AtomicInteger;

public class ClientController  extends Controller {
    public void AddClient(Table<Object> table){
        View AddClientView = new AddClientView(table);
        UIManager.addWindow(AddClientView);
    }
    public void ModifyClient(Table<Object> table, AtomicInteger Id){
        View ModifyClientView = new ModifyClientView(table,Id);
        UIManager.addWindow(ModifyClientView);
    }
    public void DeleteClient(Table<Object> table, AtomicInteger Id){
        View DeleteClientView = new DeleteClientView(table, Id);
        UIManager.addWindow(DeleteClientView);
    }
    public void SearchClient(Table<Object> table, String keyword){
        TableModel<Object> searchedProducts = new TableModel<>("ID", "Email", "Adres", "Telefon");
        ClientModel.search(keyword).values()
                .stream()
                .map(ClientModel::toTableRow)
                .forEachOrdered(searchedProducts::addRow);
        table.setTableModel(searchedProducts);
    }
}
