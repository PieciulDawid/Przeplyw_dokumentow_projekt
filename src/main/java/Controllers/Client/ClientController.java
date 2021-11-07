package Controllers.Client;

import Controllers.Controller;
import Global.UIManager;
import Views.Client.AddClientView;
import Views.Client.DeleteClientView;
import Views.View;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.concurrent.atomic.AtomicInteger;

public class ClientController  extends Controller {
    public void AddClient(Table<Object> table){
        View AddClientView = new AddClientView(table);
        UIManager.addWindow(AddClientView);
    }
    public void DeleteClient(Table<Object> table, AtomicInteger Id){
        View DeleteClientView = new DeleteClientView(table, Id);
        UIManager.addWindow(DeleteClientView);
    }
}
