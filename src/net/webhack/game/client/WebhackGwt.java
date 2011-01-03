package net.webhack.game.client;

import net.webhack.game.shared.Flags;
import net.webhack.game.shared.Webhack;
import net.webhack.game.shared.WebhackUI;

import com.google.gwt.core.client.EntryPoint;

/**
 * GWT Entry Point for Webhack. This does nothing more than bootstrap into the
 * game.
 * 
 * A classic game entrance might read configs off of a file on disk. This isn't
 * an option for us. Instead, we might have some configs stored in LocalStorage
 * on the client, or might have defaults set up here.
 */
public class WebhackGwt implements EntryPoint {

	final Flags flags;

	public WebhackGwt() {
		this.flags = new Flags();
	}

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// Read config

		// Init UI
		final WebhackUI ui = new WebhackGnomeLike();

		// Init game
		final Webhack game = new Webhack(ui, flags);

		// Determine Role, Race, Gender
		new RoleRaceGender(game.bindery).show();
	}
}
