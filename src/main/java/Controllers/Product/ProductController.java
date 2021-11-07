package Controllers.Product;
import Controllers.Controller;
import Global.UIManager;
import Views.*;
import Views.Product.AddProductView;
import com.googlecode.lanterna.gui2.table.Table;

public class ProductController extends Controller {

    public void AddProduct(Table<Object> table){
        View AddProductView = new AddProductView(table);
        UIManager.addWindow(AddProductView);
    }
    public void DeleteProduct(Table<Object> table){

    }


}
