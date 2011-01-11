/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared.command;

import net.webhack.game.shared.Bindery;
import net.webhack.game.shared.Coordinate;
import net.webhack.game.shared.Display.WindowType;
import net.webhack.game.shared.Location;
import net.webhack.game.shared.LocationType.Door;
import net.webhack.game.shared.Stub;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class DoClose extends Command {

	private final Bindery bindery;

	public DoClose(final Bindery bindery) {
		this.bindery = bindery;
	}

	@Stub
	@Override
	public boolean callback(final int cmdKey) {

		// TODO(jeffbailey): We need to consume the movement character after
		// it's used. Right now closing the door in a random direction where
		// there isn't
		// a door *also* moves the character. DoOpen gets this right.

		bindery.ui.setCommand(null);

		final Coordinate cc = bindery.webhack.dungeon.dlevel.getAdjacentLoc(
				cmdKey, null, bindery.you.ux, bindery.you.uy);

		if (cc == null) {
			return true;
		}
		final Location door = bindery.webhack.dungeon.dlevel.getLoc(cc.x, cc.y);

		final int x = bindery.you.ux + bindery.you.dx;
		final int y = bindery.you.uy + bindery.you.dy;
		if ((x == bindery.you.ux) && (y == bindery.you.uy)) {
			bindery.ui.pline("You are in the way!");
			return (false);
		}

		if (!door.typ.isDoor()) {
			bindery.ui.pline("You see no door there.");
			return (false);
		}

		if (door.doormask == Door.NODOOR) {
			bindery.ui.pline("This doorway has no door.");
			return (false);
		}

		if (door.doormask == Door.BROKEN) {
			bindery.ui.pline("This door is broken.");
			return (false);
		}

		if (door.doormask == Door.CLOSED || door.doormask == Door.LOCKED) {
			bindery.ui.pline("This door is already closed.");
			return (false);
		}

		bindery.ui.pline("The door closes.");
		door.doormask = Door.CLOSED;
		bindery.ui.newsym(x, y);

		// TODO(jeffbailey): Remove this:
		bindery.ui.displayNhWindow(WindowType.MAP, false);

		return true;
	}

	@Override
	public void execute() {
		bindery.ui.ynFunction("In what direction?",
				new char[] { 'a', 'b', 'c' }, 'a');
		bindery.ui.setCommand(this);
	}

}
