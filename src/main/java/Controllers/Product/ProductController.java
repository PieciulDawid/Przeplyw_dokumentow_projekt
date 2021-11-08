package Controllers.Product;
import Controllers.Controller;
import Global.UIManager;
import Models.ClientModel;
import Models.ProductModel;
import Views.*;
import Views.Product.AddProductView;
import Views.Product.DeleteProductView;
import Views.Product.ModifyProductView;
import com.googlecode.lanterna.gui2.table.Table;
import com.googlecode.lanterna.gui2.table.TableModel;

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
    public void ModiftProduct(Table<Object> table, AtomicInteger Id){
        View ModifyProductView = new ModifyProductView(table, Id);
        UIManager.addWindow(ModifyProductView);
    }
    
    public void SearchProduct(Table<Object> table, String keyword){
        TableModel<Object> searchedProducts = new TableModel<>("ID", "Nazwa", "Cena", "Ilość");
        ProductModel.search(keyword).values()
                .stream()
                .map(ProductModel::toTableRow)
                .forEachOrdered(searchedProducts::addRow);
        table.setTableModel(searchedProducts);
    }

}
