package Controllers.Product;

import Controllers.Controller;
import Models.ProductModel;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.concurrent.atomic.AtomicInteger;

public class ModifyProductController  extends Controller {
    public void ModifyProduct(Table<Object> table, String Name, String Price, String Amount, AtomicInteger Id){
        ProductModel productModel = new ProductModel(1, Name, Float.parseFloat(Price), Integer.parseInt(Amount));
        productModel.setId((Integer) table.getTableModel().getCell(0,Id.intValue()));
        ProductModel.modify(productModel);
        table.getTableModel().setCell(1,Id.intValue(),Name);
        table.getTableModel().setCell(2,Id.intValue(),Price);
        table.getTableModel().setCell(3,Id.intValue(),Amount);

    }
}
