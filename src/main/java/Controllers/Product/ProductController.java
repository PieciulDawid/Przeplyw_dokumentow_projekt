package Controllers.Product;
import Controllers.Controller;
import Global.UIManager;
import Views.*;
import Views.Product.AddProductView;

public class ProductController extends Controller {

    public void AddProduct(){
        View AddProductView = new AddProductView();
        UIManager.addWindow(AddProductView);
    }


}
