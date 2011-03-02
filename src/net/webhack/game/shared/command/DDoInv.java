package net.webhack.game.shared.command;

import net.webhack.game.shared.Bindery;
import net.webhack.game.shared.Stub;

public class DDoInv extends Command {

	private final Bindery bindery;

	public DDoInv(final Bindery bindery) {
		this.bindery = bindery;
	}

	@Override
	@Stub
	public void execute() {
		bindery.webhack.display_inventory();
	}
}
