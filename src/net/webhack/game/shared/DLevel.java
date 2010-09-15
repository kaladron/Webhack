/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class DLevel {
	/** dungeon number */
	final int dnum;
	/** level number */
	final int dlevel;

	public DLevel(int dnum, int dlevel) {
		this.dnum = dnum;
		this.dlevel = dlevel;
	}
}
