package Controllers;
import Global.UIManager;
import Views.*;
public class ProductController extends Controller{

        public void GoBack(){
            View MainMenu = new MainMenuView(/* ewentualne argumenty konstruktora*/);
            UIManager.popWindow();
            UIManager.addWindow(MainMenu);
        }
}
