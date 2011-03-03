/*
 * Copyright 2011 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

public abstract class Vision {

	protected Bindery bindery;

	protected Boolean[][] viz_array = new Boolean[Webhack.ROWNO][Webhack.COLNO];

	public Vision() {
		for (int y = 0; y < Webhack.ROWNO; y++) {
			for (int x = 0; x < Webhack.COLNO; x++) {
				viz_array[y][x] = new Boolean(false);
			}
		}
	}

	public boolean cansee(final int x, final int y) {
		return viz_array[y][x];
	}

	public void setBindery(final Bindery bindery) {
		this.bindery = bindery;
	}

	public void vision_recalc(final int control) {
		view_from(bindery.you.uy, bindery.you.ux);

		for (int y = 0; y < Webhack.ROWNO; ++y) {
			for (int x = 0; x < Webhack.COLNO; ++x) {
				if (viz_array[y][x]) {
					bindery.ui.newsym(x, y);
				}
			}
		}
	}

	abstract void view_from(int y, int x);
}
