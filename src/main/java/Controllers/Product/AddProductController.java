package Controllers.Product;

import Controllers.Controller;
import Models.ProductModel;
import com.googlecode.lanterna.gui2.TextBox;
import com.googlecode.lanterna.gui2.table.Table;

public class AddProductController extends Controller {

    public void AddProduct(Table<Object> table, String Name, String Price, String Amount){
        ProductModel productModel = new ProductModel(1, Name, Float.parseFloat(Price), Integer.parseInt(Amount));
        ProductModel.add(productModel); //TODO AKCJA KONTROLERA (MODYFIKACJA DANYCH!!!!!!)
        table.getTableModel().addRow(productModel.toTableRow());
    }
}
