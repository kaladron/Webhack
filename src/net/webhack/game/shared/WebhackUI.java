package net.webhack.game.shared;

import net.webhack.game.shared.command.Command;

public interface WebhackUI {
	void clearNhWindow(Display.WindowType window);

	boolean command(int cmdKey);

	void displayNhWindow(Display.WindowType window, boolean blocking);

	void docrt();

	void init(Dungeon dungeon, You you, Flags flags);

	void initNhWindows(Webhack webhack);

	void newsym(int x, int y);

	void pline(String line);

	void setBindery(Bindery bindery);

	void setCommand(Command command);

	void showMapSpot(int zx, int zy);

	void updateStats();

	void vision_recalc(final int control);

	char ynFunction(String question, char[] choices, char theDefault);

}
