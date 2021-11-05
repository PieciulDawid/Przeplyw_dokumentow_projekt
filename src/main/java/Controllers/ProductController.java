package Controllers;
import Global.UIManager;
import Views.*;
public class ProductController extends Controller{

    public void AddProduct(){
        View AddProductView = new AddProductView();
        UIManager.addWindow(AddProductView);
    }


}
