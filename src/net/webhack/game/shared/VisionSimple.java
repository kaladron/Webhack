package net.webhack.game.shared;

public class VisionSimple implements Vision {

	private Bindery bindery;

	public boolean cansee(final int x, final int y) {
		if (Math.abs(bindery.you.ux - x) < 3
				&& Math.abs(bindery.you.uy - y) < 3) {
			return true;
		}
		return false;
	}

	public void setBindery(final Bindery bindery) {
		this.bindery = bindery;
	}

	public void vision_recalc(final int control) {
		for (int x = bindery.you.ux - 3; x <= bindery.you.ux + 3; x++) {
			for (int y = bindery.you.uy - 3; y <= bindery.you.uy + 3; y++) {
				if (bindery.webhack.dungeon.dlevel.isOk(x, y)) {
					bindery.ui.newsym(x, y);
				}
			}
		}
	}

}
