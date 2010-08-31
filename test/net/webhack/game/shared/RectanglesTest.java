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
	
	@Test
	public void addRectangle() {
		Rectangles rectangles = new Rectangles(new MockRandom());
		Rectangle r = new Rectangle(10, 20, 30, 40);
		Rectangle s = rectangles.getRect(r);
		assertEquals(s, null);
		rectangles.addRect(r);
		s = rectangles.getRect(r);
		assertTrue(s == r);
	}
	
	@Test
	public void removeRectangle() {
		Rectangles rectangles = new Rectangles(new MockRandom());
		Rectangle r = new Rectangle(10, 20, 30, 40);
		rectangles.addRect(r);
		Rectangle s = rectangles.getRect(r);
		assertTrue(r == s);
		rectangles.removeRect(r);
		s = rectangles.getRect(r);
		assertTrue(s == null);
	}
	
	@Test
	public void copyRectangle() {
		Rectangle r = new Rectangle(10, 20, 30, 40);
		Rectangle s = new Rectangle(r);
		assertEquals(r, s);
		// These should be different objects.
		assertTrue(r != s);
	}
}
