/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.client;

import java.util.EnumSet;

import net.webhack.game.shared.Role;
import net.webhack.game.shared.Role.Roles;
import net.webhack.game.shared.Webhack;

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
	final EnumSet<Role.Roles> roleSet;
	final Webhack game;

	public RoleRaceGender(final Webhack game) {
		super(false);
		setGlassEnabled(true);
		this.center();

		this.game = game;

		final VerticalPanel panel = new VerticalPanel();
		panel.add(new Label("Choose Role"));

		roleSet = EnumSet.allOf(Role.Roles.class);

		roleSelector = new ListBox();
		for (final Role.Roles role : roleSet) {
			roleSelector.addItem(role.toString());
		}

		roleSelector.setVisibleItemCount(1);

		panel.add(roleSelector);

		final Button okButton = new Button("Start", this);
		panel.add(okButton);

		setWidget(panel);

	}

	public void onClick(final ClickEvent event) {
		final String value = roleSelector.getValue(roleSelector
				.getSelectedIndex());
		final Roles myRole = Role.Roles.valueOf(value);
		game.flags.initrole = Role.newRole(myRole);

		this.hide();

		game.main();

	}
}
