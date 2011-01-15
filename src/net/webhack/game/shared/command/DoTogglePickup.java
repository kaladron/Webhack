package net.webhack.game.shared.command;

import net.webhack.game.shared.Bindery;
import net.webhack.game.shared.Stub;

public class DoTogglePickup extends Command {

	private final Bindery bindery;

	public DoTogglePickup(final Bindery bindery) {
		this.bindery = bindery;
	}

	@Override
	@Stub
	public void execute() {
		bindery.flags.pickup = !bindery.flags.pickup;

		String buf;
		// TODO(jeffbailey): Forcing this for $ objects for now.
		if (bindery.flags.pickup) {
			buf = "ON for $ objects";
		} else {
			buf = "OFF";
		}
		bindery.ui.pline("Autopickup: " + buf);
	}
}
