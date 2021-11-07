package Controllers.Product;

import Controllers.Controller;
import Models.ProductModel;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.concurrent.atomic.AtomicInteger;

public class DeleteProductController  extends Controller {

    public void DeleteProduct(Table<Object> table, AtomicInteger Id){
        ProductModel.delete((int)table.getTableModel().getCell(0,Id.intValue()));
        table.getTableModel().removeRow(Id.intValue());
    }

}
