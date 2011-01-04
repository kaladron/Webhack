/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
public class RectanglesTest {

	Bindery bindery = new Bindery(null, new WebhackRandom(), null, null);

	@Test
	public void addRectangle() {
		final Rectangles rectangles = new Rectangles(new MockRandom());
		final Rectangle r = new Rectangle(10, 20, 30, 40);
		Rectangle s = rectangles.getRect(r);
		assertEquals(s, null);
		rectangles.addRect(r);
		s = rectangles.getRect(r);
		assertTrue(s == r);
	}

	@Test
	public void copyRectangle() {
		final Rectangle r = new Rectangle(10, 20, 30, 40);
		final Rectangle s = new Rectangle(r);
		assertEquals(r, s);
		// These should be different objects.
		assertTrue(r != s);
	}

	public void hugeTest() {
		final RandomHelper random = new WebhackRandom();
		new DungeonLevel(random, new You(null, null, null, bindery), null);
	}

	/**
	 * Test method for
	 * {@link net.webhack.game.shared.Rectangles#Rectangles(net.webhack.game.shared.Rectangle)}
	 * .
	 */
	@Test
	public void initialRectangle() {
		final Rectangles rectangles = new Rectangles(new MockRandom());
		final Rectangle r = rectangles.rndRect();
		// Initial rectangle should be the size of the level.
		final Rectangle s = new Rectangle(0, 0, Webhack.COLNO - 1,
				Webhack.ROWNO - 1);
		assertEquals(r, s);
	}

	@Test
	public void removeRectangle() {
		final Rectangles rectangles = new Rectangles(new MockRandom());
		final Rectangle r = new Rectangle(10, 20, 30, 40);
		rectangles.addRect(r);
		Rectangle s = rectangles.getRect(r);
		assertTrue(r == s);
		rectangles.removeRect(r);
		s = rectangles.getRect(r);
		assertTrue(s == null);
	}

	@Test
	public void splitRects() {
		final Rectangles rects = new Rectangles(new MockRandom());
		// Always just the first one here.
		final Rectangle r = rects.rndRect();
		final Rectangle s = new Rectangle(1, 1, 10, 10);
		rects.splitRects(r, s);
		System.out.println(rects);
		assertTrue(rects.getRect(new Rectangle(0, 12, 79, 20)) != null);
		assertTrue(rects.getRect(new Rectangle(12, 0, 79, 20)) != null);

	}
}
