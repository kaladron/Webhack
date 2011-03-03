package net.webhack.game.shared;

public class VisionSimple extends Vision {

	@Override
	void view_from(final int y, final int x) {
		for (int lx = x - 3; lx <= x + 3; lx++) {
			for (int ly = y - 3; ly <= y + 3; ly++) {
				if (bindery.webhack.dungeon.dlevel.isOk(lx, ly)) {
					viz_array[ly][lx] = true;
				}
			}
		}

	}
}
