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
public class DoOpen extends Command {

	private final Bindery bindery;

	public DoOpen(final Bindery bindery) {
		this.bindery = bindery;
	}

	@Stub
	@Override
	public boolean callback(final int cmdKey) {

		final Coordinate cc = bindery.webhack.dungeon.dlevel.getAdjacentLoc(
				cmdKey, null, bindery.you.ux, bindery.you.uy);

		if (cc == null) {
			bindery.ui.setCommand(null);
			return true;
		}
		final Location door = bindery.webhack.dungeon.dlevel.getLoc(cc.x, cc.y);

		if (!door.typ.isDoor()) {
			bindery.ui.pline("You see no door there.");
			bindery.ui.setCommand(null);
			return true;
		}

		if (door.doormask != LocationType.Door.CLOSED) {
			switch (door.doormask) {
			case BROKEN:
				bindery.ui.pline("This door is broken.");
				break;
			case NODOOR:
				bindery.ui.pline("This doorway has no door.");
				break;
			case ISOPEN:
				bindery.ui.pline("This door is already open.");
				break;
			default:
				bindery.ui.pline("This door is locked");
				break;
			}
			bindery.ui.setCommand(null);
			return true;
		}

		door.doormask = LocationType.Door.ISOPEN;
		bindery.ui.pline("The door opens.");
		bindery.ui.newsym(cc.x, cc.y);

		// TODO(jeffbailey): Remove this:
		bindery.ui.displayNhWindow(WindowType.MAP, false);

		bindery.ui.setCommand(null);
		return true;
	}

	@Override
	public void execute() {
		bindery.ui.ynFunction("In what direction?",
				new char[] { 'a', 'b', 'c' }, 'a');
		bindery.ui.setCommand(this);
	}
}
