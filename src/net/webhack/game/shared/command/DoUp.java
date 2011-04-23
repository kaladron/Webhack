package net.webhack.game.shared.command;

import net.webhack.game.shared.Bindery;
import net.webhack.game.shared.Stub;

public class DoUp extends Command {

	private final Bindery bindery;

	public DoUp(final Bindery bindery) {
		this.bindery = bindery;
	}

	@Override
	@Stub
	public void execute() {
		bindery.ui.pline("Can't go up right now");
	}

}
