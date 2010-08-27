package net.webhack.game.client;

import net.webhack.game.shared.Webhack;

import com.google.gwt.core.client.EntryPoint;

/**
 * GWT Entry Point for Webhack.  This does nothing more than bootstrap into the game.
 * 
 * A classic game entrance might read configs off of a file on disk.  This isn't
 * an option for us.  Instead, we might have some configs stored in LocalStorage on 
 * the client, or might have defaults set up here.
 */
public class WebhackGwt implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// Read config
		
		// Init UI
		WebhackUI ui = new WebhackGnomeLike();
		
		// Init game
		Webhack game = new Webhack(ui);
		
		game.main();
	}
}
