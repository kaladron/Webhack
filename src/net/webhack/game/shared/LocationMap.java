/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public interface LocationMap {
	Location getLoc(int x, int y);

	boolean monAt(int x, int y);

	boolean youAt(int x, int y);
}
