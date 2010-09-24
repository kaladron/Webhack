package net.webhack.game.client;

import net.webhack.game.shared.Display;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class WebhackGnomeLike extends Display {

	Command sayHello = new Command() {
		public void execute() {
			Window.alert("Hello");
		}
	};

	public WebhackGnomeLike() {
	}

	public void clearNhWindow(final Display.WindowType window) {

	}

	public void displayNhWindow(final Display.WindowType window,
			final boolean blocking) {
		for (final Gbuf[] rows : gbuf) {
			for (final Gbuf cell : rows) {
				System.out.print(cell.glyph + " ");
			}
			System.out.println();
		}

	}

	public void initNhWindows() {
		final VerticalPanel basePanel = new VerticalPanel();
		final MenuBar menu = new MenuBar();
		menu.addItem("Game", sayHello);
		menu.addItem("Edit", sayHello);
		menu.addItem("Apparel", sayHello);
		menu.addItem("Action", sayHello);
		menu.addItem("Magic", sayHello);
		menu.addItem("Help", sayHello);
		basePanel.setWidth("100%");
		basePanel.setHeight("100%");
		basePanel.add(menu);

		final HorizontalPanel statusPanel = new HorizontalPanel();
		statusPanel.add(new Label("foo"));
		basePanel.add(statusPanel);

		RootPanel.get().add(basePanel);
	}
}
