/*
 * Copyright 2011 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

public interface Vision {
	boolean cansee(final int x, final int y);

	void setBindery(Bindery bindery);

	void vision_recalc(int control);
}
