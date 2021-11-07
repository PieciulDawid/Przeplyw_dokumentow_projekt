package Views;

import Controllers.AboutController;
import Controllers.FrogController;
import Controllers.Product.ProductController;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import org.apache.commons.collections.functors.WhileClosure;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class AboutView extends View {
    public AboutView() throws InterruptedException {
        super("O nas");
        Panel panel = Panels.vertical();

        panel.setLayoutData(BorderLayout.Location.CENTER);
        panel.addComponent(new Label(
                "____________________     ________  ________       ________ __________ \n" +
                        "\\______   \\______   \\    \\______ \\ \\______ \\      \\______ \\\\______   \\\n" +
                        " |    |  _/|    |  _/     |    |  \\ |    |  \\      |    |  \\|     ___/\n" +
                        " |    |   \\|    |   \\     |    `   \\|    `   \\     |    `   \\    |    \n" +
                        " |______  /|______  /____/_______  /_______  /____/_______  /____|    \n" +
                        "        \\/        \\/_____/       \\/        \\/_____/       \\/          \n" +
                        "\n" +
                        "|--------------------------------------------------------------------|\n" +
                        "|      Bartłomiej Busłowski    Dawid Dmitruk     Dawid Pieciul       |\n" +
                        "|--------------------------------------------------------------------|"));


        panel.addComponent(new EmptySpace(new TerminalSize(0,2)));
        panel.addComponent(new Button("Żaba",()->{
            ((AboutController)Controller).AddFrog();

        }));
        panel.addComponent(new Button("Cofnij",()->{
            Controller.GoBack();
        }));

        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(panel);
    }
}
