import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.virtual.DefaultVirtualTerminal;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.input.KeyType;



import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public  static void main(String[] args) throws IOException {
        //System.out.println("hi");
//
        //Terminal terminal = new DefaultTerminalFactory().createTerminal();
        //Screen screen = new TerminalScreen(terminal);
        //TextGraphics tg = screen.newTextGraphics();
//
        //screen.startScreen();
//
        //tg.putString(10, 5, "Hello Lanterna!");
//
        //screen.refresh();
        //screen.readInput();
        //screen.stopScreen();
//
        ////tg.drawRectangle()


               /*
        In this second tutorial, we'll expand on how to use the Terminal interface to provide more advanced
        functionality.
        */
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        //TerminalSize terminal = new TerminalSize(80, 50);
        Terminal terminal = null;
        try {
            terminal = defaultTerminalFactory.createTerminal();
            /*
            Most terminals and terminal emulators supports what's known as "private mode" which is a separate buffer for
            the text content that does not support any scrolling. This is frequently used by text editors such as nano
            and vi in order to give a "fullscreen" view. When exiting from private mode, the previous content is usually
            restored, including the scrollback history. Emulators that don't support this properly might at least clear
            the screen after exiting.
            You can use the enterPrivateMode() to activate private mode, but you'll need to remember to also exit
            private mode afterwards so that you don't leave the terminal in a weird state when the application exists.
            The usual close() at the end will do this automatically, but you can also manually call exitPrivateMode()
            and finally Lanterna will register a shutdown hook that tries to restore the terminal (including exiting
            private mode, if necessary) as well.
             */
            terminal.enterPrivateMode();

            /*
            The terminal content should already be cleared after switching to private mode, but in case it's not, the
            clear method should make all content set to default background color with no characters and the input cursor
            in the top-left corner.
             */
            terminal.clearScreen();

            /*
            It's possible to tell the terminal to hide the text input cursor
             */
            terminal.setCursorVisible(false);

            /*
            Instead of manually writing one character at a time like we did in the previous tutorial, an easier way is
            to use a TextGraphic object. You'll see more of this object later on, it's reused on the Screen and TextGUI
            layers too.
             */
            final TextGraphics textGraphics = terminal.newTextGraphics();

            /*
            The TextGraphics object keeps its own state of the current colors, separate from the terminal. You can use
            the foreground and background set methods to specify it and it will take effect on all operations until
            further modified.
             */
            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
            textGraphics.setBackgroundColor(TextColor.ANSI.BLUE);
            /*
            putString(..) exists in a couple of different flavors but it generally works by taking a string and
            outputting it somewhere in terminal window. Notice that it doesn't take the current position of the text
            cursor when doing this.
             */
            textGraphics.putString(2, 1, "Kalkulator", SGR.BOLD);
            textGraphics.setForegroundColor(TextColor.ANSI.DEFAULT);
            textGraphics.setBackgroundColor(TextColor.ANSI.DEFAULT);
            //textGraphics.putString(terminal.getTerminalSize().getColumns()/2, 3, "Terminal Size: ", SGR.BOLD);
            //textGraphics.putString(terminal.getTerminalSize().getColumns()/2 + "Terminal Size: ".length(), 3, terminal.getTerminalSize().toString());

            /*
            You still need to flush for changes to become visible
             */
            terminal.flush();

            /*
            You can attach a resize listener to your Terminal object, which will invoke a callback method (usually on a
            separate thread) when it is informed of the terminal emulator window changing size. Notice that maybe not
            all implementations supports this. The UnixTerminal, for example, relies on the WINCH signal being sent to
            the java process, which might not make it though if you remote shell isn't forwarding the signal properly.
             */
            /*terminal.addResizeListener((terminal1, newSize) -> {
                // Be careful here though, this is likely running on a separate thread. Lanterna is threadsafe in
                // a best-effort way so while it shouldn't blow up if you call terminal methods on multiple threads,
                // it might have unexpected behavior if you don't do any external synchronization
                textGraphics.drawLine(5, 3, newSize.getColumns() - 1, 3, ' ');
                textGraphics.putString(newSize.getColumns()/2, 3, "Terminal Size: ", SGR.BOLD);
                textGraphics.putString(newSize.getColumns()/2 + "Terminal Size: ".length(), 3, newSize.toString());


                try {
                    terminal1.flush();
                }
                catch(IOException e) {
                    // Not much we can do here
                    throw new RuntimeException(e);
                }
            });*/

            textGraphics.putString(5, 4, "Podana liczba: ", SGR.BOLD);
            textGraphics.putString(5 + "Podana liczba: ".length(), 4, "<Wpisz Następną liczbę>");
            textGraphics.putString(5, 5, "Lista liczb: ", SGR.BOLD);
            textGraphics.putString(5 + "Lista liczb; ".length(), 5, "<Brak liczb>");
            textGraphics.putString(5, 6, "Suma: ", SGR.BOLD);
            textGraphics.putString(5 + "Suma: ".length(), 6, "<Tu będzie suma>");
            terminal.flush();


            /*
            Now let's try reading some input. There are two methods for this, pollInput() and readInput(). One is
            blocking (readInput) and one isn't (pollInput), returning null if there was nothing to read.
             */

            KeyStroke keyStroke1 = terminal.readInput();
            /*
            The KeyStroke class has a couple of different methods for getting details on the particular input that was
            read. Notice that some keys, like CTRL and ALT, cannot be individually distinguished as the standard input
            stream doesn't report these as individual keys. Generally special keys are categorized with a special
            KeyType, while regular alphanumeric and symbol keys are all under KeyType.Character. Notice that tab and
            enter are not considered KeyType.Character but special types (KeyType.Tab and KeyType.Enter respectively)
             */

            int suma = 0;
            List lista = new ArrayList();
            while (keyStroke1.getKeyType() != KeyType.Escape){
                String tekst = "";


                KeyStroke keyStroke = terminal.readInput();
                while(keyStroke.getKeyType() != KeyType.Enter) {
                    textGraphics.drawLine(5, 4, terminal.getTerminalSize().getColumns() - 1, 4, ' ');
                    textGraphics.putString(5, 4, "Podana liczba: ", SGR.BOLD);
                    textGraphics.putString(5 + "Podana liczba: ".length(), 4, tekst += keyStroke.getCharacter().toString());

                    terminal.flush();
                    keyStroke = terminal.readInput();
                }
                terminal.clearScreen();
                System.out.println(Integer.parseInt(tekst));
                lista.add(Integer.parseInt(tekst));
                suma += Integer.parseInt(tekst);

                textGraphics.putString(2, 1, "Kalkulator", SGR.BOLD);
                textGraphics.setForegroundColor(TextColor.ANSI.DEFAULT);
                textGraphics.setBackgroundColor(TextColor.ANSI.DEFAULT);
                textGraphics.putString(5, 4, "Podana liczba: ", SGR.BOLD);
                textGraphics.putString(5 + "Podana liczba: ".length(), 4, "<Wpisz Następną liczbę>");
                textGraphics.putString(5, 5, "Lista liczb: ", SGR.BOLD);
                textGraphics.putString(5 + "Lista liczb: ".length(), 5, String.valueOf(lista));
                textGraphics.putString(5, 6, "Suma: ", SGR.BOLD);
                textGraphics.putString(5 + "Suma: ".length(), 6, String.valueOf(suma));
                terminal.flush();
            }


        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            if(terminal != null) {
                try {
                    /*
                    The close() call here will exit private mode
                     */
                    terminal.close();
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
