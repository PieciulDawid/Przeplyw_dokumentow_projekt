package Global;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class UIManager {
	private static UIManager instance;
	private final MultiWindowTextGUI Gui;

	
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
				new EmptySpace(new TextColor.RGB(9,101,184)));
		((AsynchronousTextGUIThread)Gui.getGUIThread()).start();
	}
	
	public static void addWindow(Window window) {
		synchronized(UIManager.class) {
			instance.Gui.addWindow(window);
		}
	}
	
	public static void popWindow() {
		synchronized(UIManager.class) {
			instance.Gui.getActiveWindow().close();
		}
	}

	public static void hideTop() {
		synchronized(UIManager.class) {
			instance.Gui.getActiveWindow().setVisible(false);
		}
	}

	public static void showTop() {
		synchronized(UIManager.class) {
			instance.Gui.getActiveWindow().setVisible(true);
		}
	}
	
	public static void showMessageDialog(String title, String text, MessageDialogButton button) {
		synchronized(UIManager.class) {
			MessageDialog.showMessageDialog(instance.Gui, title, text, button);
		}
	}
	
	public static void closeGui() {
		synchronized(UIManager.class) {
			try {
				instance.Gui.getScreen().close();
				((TerminalScreen)instance.Gui.getScreen()).getTerminal().close();
			}
			catch(IOException e) {
			}
		}
	}
}
