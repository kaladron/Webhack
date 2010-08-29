/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class RectanglesTest {

	/**
	 * Test method for
	 * {@link net.webhack.game.shared.Rectangles#Rectangles(net.webhack.game.shared.Rectangle)}
	 * .
	 */
	@Test
	public void initialRectangle() {
		Rectangles rectangles = new Rectangles(new MockRandom());
		Rectangle r = rectangles.rndRect();
		// Initial rectangle should be the size of the level.
		Rectangle s = new Rectangle(0, 0, Webhack.COLNO - 1, Webhack.ROWNO - 1);
		assertEquals(r, s);
	}
}
