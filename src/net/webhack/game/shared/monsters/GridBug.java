/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared.monsters;

import net.webhack.game.shared.RandomHelper;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class GridBug extends Monster {
	public GridBug(final RandomHelper random) {
		super(random, 115, "grid bug", 'x', 0, 12, 9, 0, 0, 0, 15, 10, 0, 0, 0,
				0, 0, 0, 0, 0);
	}
}
