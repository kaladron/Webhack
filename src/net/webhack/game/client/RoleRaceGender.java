/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class RoleRaceGender extends PopupPanel implements ClickHandler {

	final ListBox roleSelector;

	public RoleRaceGender() {
		super(false);
		setGlassEnabled(true);

		final VerticalPanel panel = new VerticalPanel();
		panel.add(new Label("Choose Role"));

		roleSelector = new ListBox();
		roleSelector.addItem("Archeologist");
		roleSelector.addItem("Wizard");

		roleSelector.setVisibleItemCount(1);

		panel.add(roleSelector);

		final Button okButton = new Button("Start", this);
		panel.add(okButton);

		setWidget(panel);

	}

	public void onClick(final ClickEvent event) {
		// System.out.println(roleSelector.getValue(roleSelector
		// .getSelectedIndex()));

		this.hide();
	}
}
