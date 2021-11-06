package Views;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import java.util.Arrays;

public class AboutView extends View {
    public AboutView() {
        super("O nas");
        Panel panel = Panels.vertical();

        panel.setLayoutData(BorderLayout.Location.CENTER);
        panel.addComponent(new Label(
                "____________________     ________  ________       ________ __________ \n" +
                "\\______   \\______   \\    \\______ \\ \\______ \\      \\______ \\\\______   \\\n" +
                " |    |  _/|    |  _/     |    |  \\ |    |  \\      |    |  \\|     ___/\n" +
                " |    |   \\|    |   \\     |    `   \\|    `   \\     |    `   \\    |    \n" +
                " |______  /|______  /____/_______  /_______  /____/_______  /____|    \n" +
                "        \\/        \\/_____/       \\/        \\/_____/       \\/          "));

        panel.addComponent(new Label("Dawid Dmitruk").setLayoutData(BorderLayout.Location.CENTER));
        panel.addComponent(new Label("Bartłomiej Busłowski"));
        panel.addComponent(new Label("Dawid Pieciul"));
        panel.addComponent(new Label("PS 3")).setLayoutData(BorderLayout.Location.CENTER);
        panel.addComponent(new EmptySpace(new TerminalSize(0,2)));

        panel.addComponent(new Button("Cofnij",()->{
            Controller.GoBack();
        }));



        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(panel);
    }
}
