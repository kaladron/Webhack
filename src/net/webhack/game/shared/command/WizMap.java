package net.webhack.game.shared.command;

import net.webhack.game.shared.Bindery;

public class WizMap extends Command {

	private final Bindery bindery;

	public WizMap(final Bindery bindery) {
		this.bindery = bindery;
	}

	@Override
	public void execute() {
		if (bindery.flags.debug) {
			// struct trap *t;
			// long save_Hconf = HConfusion,
			// save_Hhallu = HHallucination;

			// HConfusion = HHallucination = 0L;
			// for (t = ftrap; t != 0; t = t->ntrap) {
			// t->tseen = 1;
			// map_trap(t, TRUE);
			// }
			bindery.dlevel.doMapping();
			// HConfusion = save_Hconf;
			// HHallucination = save_Hhallu;
		} else {
			bindery.ui.pline("Unavailable command '^F'.");
		}
		return;
	}

}
