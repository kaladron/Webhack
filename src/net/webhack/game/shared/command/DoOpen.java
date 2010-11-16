/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared.command;

import net.webhack.game.shared.Coordinate;
import net.webhack.game.shared.Display.WindowType;
import net.webhack.game.shared.Dungeon;
import net.webhack.game.shared.Location;
import net.webhack.game.shared.LocationType;
import net.webhack.game.shared.Stub;
import net.webhack.game.shared.You;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class DoOpen extends Command {

	private final Dungeon dungeon;
	private final You you;

	public DoOpen(final Dungeon dungeon, final You you) {
		this.dungeon = dungeon;
		this.you = you;
	}

	@Stub
	@Override
	public boolean callback(final char letter) {

		final Coordinate cc = dungeon.dlevel.getAdjacentLoc(letter, null,
				you.ux, you.uy);

		if (cc == null) {
			dungeon.ui.setCommand(null);
			return true;
		}
		final Location door = dungeon.dlevel.getLoc(cc.x, cc.y);

		if (!door.typ.isDoor()) {
			dungeon.ui.pline("You see no door there.");
			dungeon.ui.setCommand(null);
			return true;
		}

		if (door.doormask != LocationType.Door.CLOSED) {
			switch (door.doormask) {
			case BROKEN:
				dungeon.ui.pline("This door is broken.");
				break;
			case NODOOR:
				dungeon.ui.pline("This doorway has no door.");
				break;
			case ISOPEN:
				dungeon.ui.pline("This door is already open.");
				break;
			default:
				dungeon.ui.pline("This door is locked");
				break;
			}
			dungeon.ui.setCommand(null);
			return true;
		}

		door.doormask = LocationType.Door.ISOPEN;
		dungeon.ui.pline("The door opens.");
		dungeon.ui.newsym(cc.x, cc.y);

		// TODO(jeffbailey): Remove this:
		dungeon.ui.displayNhWindow(WindowType.MAP, false);

		dungeon.ui.setCommand(null);
		return true;
	}

	@Override
	public void execute() {
		dungeon.ui.ynFunction("In what direction?",
				new char[] { 'a', 'b', 'c' }, 'a');
		dungeon.ui.setCommand(this);
	}
}
