package Views.Employee;

import Controllers.Employee.ModifyEmployeeController;
import Controllers.Product.ModifyProductController;
import Models.EmployeeModel;
import Views.View;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class ModifyEmployeeView extends View {
    public ModifyEmployeeView(Table<Object> table, AtomicInteger Id) {
        super("Zmodyfikuj pracownika");
        EmployeeModel tmp = EmployeeModel.get((int)table.getTableModel().getCell(0,Id.intValue()));

        String name     = tmp.getName();
        String surname    =tmp.getSurname();
        String login    = tmp.getSurname();
        String password    = tmp.getPassword();
        TextBox Name    = new TextBox(name, TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));
        TextBox Surname   = new TextBox(surname, TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));

        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2).setVerticalSpacing(1).setTopMarginSize(1));

        panel.addComponent(new Label("Nazwa"));
        panel.addComponent(Name);

        panel.addComponent(new Label("Cena"));
        panel.addComponent(Surname);

        panel.addComponent(new Button("Anuluj",()->{
            Controller.CancelAction();
        }));

        panel.addComponent(new Button("Modifikuj",()->{

            ((ModifyEmployeeController)Controller).ModifyEmployee(table, Name.getText(), Surname.getText(),login, password, Id);
            Controller.CancelAction();
        }));

        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(panel);
    }
}
