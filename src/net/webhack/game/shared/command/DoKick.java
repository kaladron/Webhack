/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared.command;

import net.webhack.game.shared.Bindery;
import net.webhack.game.shared.Coordinate;
import net.webhack.game.shared.Display.WindowType;
import net.webhack.game.shared.Location;
import net.webhack.game.shared.LocationType;
import net.webhack.game.shared.Stub;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class DoKick extends Command {
	private final Bindery bindery;

	public DoKick(final Bindery bindery) {
		this.bindery = bindery;
	}

	@Stub
	@Override
	public boolean callback(final int cmdKey) {

		bindery.ui.setCommand(null);

		final Coordinate cc = bindery.webhack.dungeon.dlevel.getAdjacentLoc(
				cmdKey, null, bindery.you.ux, bindery.you.uy);

		if (cc == null) {
			return true;
		}
		final Location mapLoc = bindery.webhack.dungeon.dlevel.getLoc(cc.x,
				cc.y);

		if (!mapLoc.typ.isDoor()) {
			bindery.ui.pline("You see no door there.");
			return true;
		}

		if (mapLoc.doormask == LocationType.Door.ISOPEN
				|| mapLoc.doormask == LocationType.Door.BROKEN
				|| mapLoc.doormask == LocationType.Door.NODOOR) {

			bindery.ui.pline("You kick at empty space.");
			return false;
		}

		bindery.ui.pline("As you kick the door, it crashes open!");
		mapLoc.doormask = LocationType.Door.BROKEN;

		bindery.ui.newsym(cc.x, cc.y);

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
