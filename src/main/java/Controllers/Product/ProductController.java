package Controllers.Product;
import Controllers.Controller;
import Global.UIManager;
import Views.*;
import Views.Product.AddProductView;
import Views.Product.DeleteProductView;
import Views.Product.ModifyProductView;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.concurrent.atomic.AtomicInteger;

public class ProductController extends Controller {

    public void AddProduct(Table<Object> table){
        View AddProductView = new AddProductView(table);
        UIManager.addWindow(AddProductView);
    }
    public void DeleteProduct(Table<Object> table, AtomicInteger Id){
        View DeleteProductView = new DeleteProductView(table, Id);
        UIManager.addWindow(DeleteProductView);
    }
    public void ModifyProduct(Table<Object> table, AtomicInteger Id){
        View ModifyProductView = new ModifyProductView(table, Id);
        UIManager.addWindow(ModifyProductView);
    }


}
