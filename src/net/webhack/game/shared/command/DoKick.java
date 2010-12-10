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
public class DoKick extends Command {
	private final Dungeon dungeon;
	private final You you;

	public DoKick(final Dungeon dungeon, final You you) {
		this.dungeon = dungeon;
		this.you = you;
	}

	@Stub
	@Override
	public boolean callback(final int cmdKey) {

		dungeon.ui.setCommand(null);

		final Coordinate cc = dungeon.dlevel.getAdjacentLoc(cmdKey, null,
				you.ux, you.uy);

		if (cc == null) {
			return true;
		}
		final Location mapLoc = dungeon.dlevel.getLoc(cc.x, cc.y);

		if (!mapLoc.typ.isDoor()) {
			dungeon.ui.pline("You see no door there.");
			return true;
		}

		if (mapLoc.doormask == LocationType.Door.ISOPEN
				|| mapLoc.doormask == LocationType.Door.BROKEN
				|| mapLoc.doormask == LocationType.Door.NODOOR) {

			dungeon.ui.pline("You kick at empty space.");
			return false;
		}

		dungeon.ui.pline("As you kick the door, it crashes open!");
		mapLoc.doormask = LocationType.Door.BROKEN;

		dungeon.ui.newsym(cc.x, cc.y);

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
