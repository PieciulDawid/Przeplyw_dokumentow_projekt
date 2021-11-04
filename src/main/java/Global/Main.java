package Global;

import Views.TestView;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public  static void main(String[] args) throws IOException {


        // Setup terminal and screen layers
        /*Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();*/

        // Create panel to hold components
        /*Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2));

        panel.addComponent(new Label("Forename"));
        panel.addComponent(new TextBox());

        panel.addComponent(new Label("Surname"));
        panel.addComponent(new TextBox().setMask('*'));

        panel.addComponent(new EmptySpace(new TerminalSize(0,0))); // Empty space underneath labels


        // Create window to hold the panel
        BasicWindow window = new BasicWindow();

        window.setHints(Arrays.asList(Window.Hint.CENTERED));
        window.setComponent(panel);*/

        // Create gui and start gui
        /*MultiWindowTextGUI gui = new MultiWindowTextGUI(new SeparateTextGUIThread.Factory(),
                screen, new DefaultWindowManager(),
                new WindowShadowRenderer(),
                new EmptySpace(TextColor.ANSI.CYAN));
        panel.addComponent(new Button("Submit", new Runnable() {
            @Override
            public void run() {
                Window wind = new BasicWindow();
                System.out.println(Thread.currentThread().getId());
                System.out.println((gui.getGUIThread().getThread().getId()));
                wind.setFixedSize(new TerminalSize(10,10));
                gui.addWindow(wind);
            }
        }));
        gui.addWindow(window);
        ((AsynchronousTextGUIThread)gui.getGUIThread()).start();

        System.out.println((gui.getGUIThread().getThread().getId()));
        System.out.println(Thread.currentThread().getId());*/

        UIManager.setup();/*
        UIManager.addWindow(window);*/
        ControllerCont.TestController.Show();
        
        /*panel.addComponent(new Button("Submit", new Runnable() {
            @Override
            public void run() {
                Window wind = new BasicWindow();
                System.out.println(Thread.currentThread().getId());
                wind.setFixedSize(new TerminalSize(10,10));
                UIManager.addWindow(wind);
            }
        }));*/
    }
}
