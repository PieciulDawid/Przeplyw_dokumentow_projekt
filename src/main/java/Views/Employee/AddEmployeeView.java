package Views.Employee;

import Controllers.Employee.AddEmployeeController;
import Controllers.Product.AddProductController;
import Views.View;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.Arrays;

public class AddEmployeeView  extends View {
    public AddEmployeeView(Table<Object> table) {
        super("Dodaj nowego pracownika");

        TextBox Name    = new TextBox("", TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));
        TextBox Surname = new TextBox("", TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));
        TextBox Login = new TextBox("", TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));
        TextBox Password = new TextBox("", TextBox.Style.SINGLE_LINE).setPreferredSize(new TerminalSize(30,1));

        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2).setVerticalSpacing(1).setTopMarginSize(1));

        panel.addComponent(new Label("Imie"));
        panel.addComponent(Name);

        panel.addComponent(new Label("Nazwisko"));
        panel.addComponent(Surname);

        panel.addComponent(new Label("Login"));
        panel.addComponent(Login);

        panel.addComponent(new Label("Hasło"));
        panel.addComponent(Password);

        panel.addComponent(new Button("Anuluj",()->{
            Controller.CancelAction();
        }));

        panel.addComponent(new Button("Dodaj",()->{

            ((AddEmployeeController)Controller).AddEmployee(table, Name.getText(), Surname.getText(), Login.getText(), Password.getText());
            Controller.CancelAction();
        }));

        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(panel);
    }

}
