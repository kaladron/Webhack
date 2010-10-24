/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class AboutBox extends PopupPanel implements ClickHandler {

	public AboutBox() {
		super(false);
		setGlassEnabled(true);
		this.center();

		final VerticalPanel panel = new VerticalPanel();
		panel.add(new Label("It's Webhack, yo!"));

		final Button okButton = new Button("OK", this);
		panel.add(okButton);

		setWidget(panel);

	}

	public void onClick(final ClickEvent event) {
		this.hide();
	}

}
