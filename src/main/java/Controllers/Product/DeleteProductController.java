package Controllers.Product;

import Controllers.Controller;
import Models.ProductModel;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.concurrent.atomic.AtomicInteger;

public class DeleteProductController  extends Controller {

    public void DeleteProduct(Table<Object> table, AtomicInteger Id){
/*        //System.out.println(Id);
        //System.out.println(ProductModel.get(Id.intValue()+1));
        //System.out.println(table.getTableModel().getRow(Id.intValue()));
        System.out.println(table.getTableModel());
        //ProductModel productModel = (ProductModel) table.getTableModel().getRow(Id.intValue());
        //ProductModel.delete(productModel);
//        ProductModel.delete(Id.intValue()+1);
        table.getTableModel().removeRow(Id.intValue());*/
    }

}
