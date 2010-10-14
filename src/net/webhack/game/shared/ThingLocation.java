package net.webhack.game.shared;

import net.webhack.game.shared.things.Thing;

public class ThingLocation {
	Thing thing;
	int qty;
	int x, y;

	public ThingLocation(final Thing thing, final int x, final int y) {
		this.thing = thing;
		this.x = x;
		this.y = y;

	}

}
