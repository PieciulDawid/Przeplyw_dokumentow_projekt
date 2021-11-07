package Controllers.Product;

import Controllers.Controller;
import Models.ProductModel;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.concurrent.atomic.AtomicInteger;

public class DeleteProductController  extends Controller {

    public void DeleteProduct(Table<Object> table, AtomicInteger Id){
       System.out.println(Id.intValue());
        ProductModel.delete(ProductModel.search((String)table.getTableModel().getCell(1,Id.intValue())).firstKey());
        table.getTableModel().removeRow(Id.intValue());
    }

}
