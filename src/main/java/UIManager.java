import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class UIManager {
	private static UIManager instance;
	private MultiWindowTextGUI Gui;
	
	static void setup() throws IOException {
		instance = new UIManager();
	}
	
	private UIManager() throws IOException {
		Terminal terminal = new DefaultTerminalFactory().createTerminal();
		Screen screen = new TerminalScreen(terminal);
		screen.startScreen();
		Gui = new MultiWindowTextGUI(new SeparateTextGUIThread.Factory(),
				screen, new DefaultWindowManager(),
				new WindowShadowRenderer(),
				new EmptySpace(TextColor.ANSI.CYAN));
		((AsynchronousTextGUIThread)Gui.getGUIThread()).start();
	}
	
	public static synchronized void addWindow(Window window) {
		instance.Gui.addWindow(window);
	}
	
	public static synchronized void popWindow() {
		instance.Gui.getActiveWindow().close();
	}
	
}
