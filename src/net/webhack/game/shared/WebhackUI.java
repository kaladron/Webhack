package net.webhack.game.shared;

public interface WebhackUI {
	void clearNhWindow(Display.WindowType window);

	void displayNhWindow(Display.WindowType window, boolean blocking);

	void docrt();

	void init(Dungeon dungeon, You you);

	void initNhWindows();
}
