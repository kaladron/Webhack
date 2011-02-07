package net.webhack.game.shared.command;

import net.webhack.game.shared.Bindery;

public class DoPickup extends Command {

	private final Bindery bindery;

	public DoPickup(final Bindery bindery) {
		this.bindery = bindery;
	}

	@Override
	public void execute() {
		if (!bindery.webhack.dungeon.dlevel.getLoc(bindery.you.ux,
				bindery.you.uy).obj_at()) {
			bindery.ui.pline("There is nothing here to pick up.");
			return;
		}

		bindery.webhack.dungeon.dlevel.pickup();
		return;
	}

}
