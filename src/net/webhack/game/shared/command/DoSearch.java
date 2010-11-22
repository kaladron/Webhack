package net.webhack.game.shared.command;

import net.webhack.game.shared.Dungeon;

public class DoSearch extends Command {

	private final Dungeon dungeon;

	public DoSearch(final Dungeon dungeon) {
		this.dungeon = dungeon;
	}

	@Override
	public void execute() {
		dungeon.dlevel.search(false);
	}

}
