package net.webhack.game.shared;

public interface WebhackUI {
	void clearNhWindow(Display.WindowType window);

	boolean command(char letter);

	void displayNhWindow(Display.WindowType window, boolean blocking);

	void docrt();

	void init(Dungeon dungeon, You you, Flags flags);

	void initNhWindows(Webhack webhack);

	void newsym(int x, int y);

	void pline(String line);

	void setCommand(Command command);

	char ynFunction(String question, char[] choices, char theDefault);

}
