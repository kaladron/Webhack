package net.webhack.game.shared.command;

import net.webhack.game.shared.Bindery;

public class DoSearch extends Command {

	private final Bindery bindery;

	public DoSearch(final Bindery bindery) {
		this.bindery = bindery;
	}

	@Override
	public void execute() {
		bindery.dlevel.search(false);
	}

}
