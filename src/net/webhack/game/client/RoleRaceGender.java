/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class RoleRaceGender extends PopupPanel {
	public RoleRaceGender() {
		super(true);
		setGlassEnabled(true);

		setWidget(new Label("Choose Race"));
	}
}
