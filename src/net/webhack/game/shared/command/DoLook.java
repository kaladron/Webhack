package net.webhack.game.shared.command;

import net.webhack.game.shared.Bindery;

public class DoLook extends Command {

	private final Bindery bindery;

	public DoLook(final Bindery bindery) {
		this.bindery = bindery;
	}

	@Override
	public void execute() {
		bindery.dlevel.lookHere(0, false);
	}

}
