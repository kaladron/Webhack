/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared.command;

import net.webhack.game.shared.Coordinate;
import net.webhack.game.shared.Display.WindowType;
import net.webhack.game.shared.Dungeon;
import net.webhack.game.shared.Location;
import net.webhack.game.shared.LocationType.Door;
import net.webhack.game.shared.Stub;
import net.webhack.game.shared.You;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class DoClose extends Command {

	private final Dungeon dungeon;
	private final You you;

	public DoClose(final Dungeon dungeon, final You you) {
		this.dungeon = dungeon;
		this.you = you;
	}

	@Stub
	@Override
	public boolean callback(final char letter) {

		// TODO(jeffbailey): We need to consume the movement character after
		// it's used. Right now closing the door in a random direction where
		// there isn't
		// a door *also* moves the character. DoOpen gets this right.

		dungeon.ui.setCommand(null);

		final Coordinate cc = dungeon.dlevel.getAdjacentLoc(letter, null,
				you.ux, you.uy);

		if (cc == null) {
			return true;
		}
		final Location door = dungeon.dlevel.getLoc(cc.x, cc.y);

		final int x = you.ux + you.dx;
		final int y = you.uy + you.dy;
		if ((x == you.ux) && (y == you.uy)) {
			dungeon.ui.pline("You are in the way!");
			return (false);
		}

		if (!door.typ.isDoor()) {
			dungeon.ui.pline("You see no door there.");
			return (false);
		}

		if (door.doormask == Door.NODOOR) {
			dungeon.ui.pline("This doorway has no door.");
			return (false);
		}

		if (door.doormask == Door.BROKEN) {
			dungeon.ui.pline("This door is broken.");
			return (false);
		}

		if (door.doormask == Door.CLOSED || door.doormask == Door.LOCKED) {
			dungeon.ui.pline("This door is already closed.");
			return (false);
		}

		dungeon.ui.pline("The door closes.");
		door.doormask = Door.CLOSED;
		dungeon.ui.newsym(x, y);

		// TODO(jeffbailey): Remove this:
		dungeon.ui.displayNhWindow(WindowType.MAP, false);

		return true;
	}

	@Override
	public void execute() {
		dungeon.ui.ynFunction("In what direction?",
				new char[] { 'a', 'b', 'c' }, 'a');
		dungeon.ui.setCommand(this);
	}

}
