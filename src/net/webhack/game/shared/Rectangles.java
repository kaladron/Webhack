/*
 * Copyright 2010 Google Inc.  Nethack Public License.
 */

package net.webhack.game.shared;

/**
 * @author Jeff Bailey <jeffbailey@google.com>
 * 
 */
class Rectangles {
	private static int MAX_RECT = 50;
	private int rectCnt;
	private Rectangle[] rect = new Rectangle[MAX_RECT];
	private final RandomHelper random;

	Rectangles(RandomHelper random) {
		this.random = random;
		// FIXME(jeffbailey): initialize this right
		rect[0] = new Rectangle();
		rectCnt = 1;
		rect[0].lx = rect[0].ly = 0;
		rect[0].hx = Webhack.COLNO - 1;
		rect[0].hy = Webhack.ROWNO - 1;
	}

	/**
	 * Add a Rectangle to the list.
	 */
	void addRect(Rectangle r) {
		if (rectCnt >= MAX_RECT) {
			return;
		}
		/* Check that this Rectangle is not included in another one */
		if (getRect(r) != null) {
			return;
		}
		rect[rectCnt] = r;
		rectCnt++;
	}

	/**
	 * Search a free rectangle that include the one given in arg
	 * 
	 * @param r
	 *            Rectangle to search in
	 * 
	 * @return Rectangle or null if not found.
	 */
	Rectangle getRect(Rectangle r) {
		for (int i = 0; i < rectCnt; i++) {
			if (r.lx >= rect[i].lx && r.ly >= rect[i].ly && r.hx <= rect[i].hx
					&& r.hy <= rect[i].hy) {
				return rect[i];
			}
		}
		return null;
	}

	/**
	 * Remove a rectangle from the list of free Rectangles.
	 * 
	 * @param r
	 *            Rectangle to remove.
	 */
	void removeRect(Rectangle r) {
		int ind = getRectInd(r);
		if (ind >= 0) {
			rect[ind] = rect[--rectCnt];
		}
	}

	/**
	 * Get some random Rectangle from the list.
	 * 
	 * @returns null if no rectangles in list.
	 */
	Rectangle rndRect() {
		return rectCnt > 0 ? rect[random.rn2(rectCnt)] : null;
	}

	/**
	 * Okay, here we have two rectangles (r1 & r2). r1 was already in the list
	 * and r2 is included in r1. What we want is to allocate r2, that is split
	 * r1 into smaller rectangles then remove it.
	 * 
	 * @param r1
	 *            Rectangle already in the Rectangles list
	 * @param r2
	 *            Sub-rectangle to sub split out of r1
	 */
	void splitRects(Rectangle r1, Rectangle r2) {
		Rectangle old_r = new Rectangle(r1);
		removeRect(r1);

		/* Walk down since rect_cnt & rect[] will change... */
		for (int i = rectCnt - 1; i >= 0; i--) {
			Rectangle r = new Rectangle();
			if (intersect(rect[i], r2, r)) {
				splitRects(rect[i], r);
			}
		}

		if (r2.ly - old_r.ly - 1 > (old_r.hy < Webhack.ROWNO - 1 ? 2 * Webhack.YLIM
				: Webhack.YLIM + 1) + 4) {
			Rectangle r = new Rectangle(old_r);
			r.hy = r2.ly - 2;
			addRect(r);
		}
		if (r2.lx - old_r.lx - 1 > (old_r.hx < Webhack.COLNO - 1 ? 2 * Webhack.XLIM
				: Webhack.XLIM + 1) + 4) {
			Rectangle r = new Rectangle(old_r);
			r.hx = r2.lx - 2;
			addRect(r);
		}
		if (old_r.hy - r2.hy - 1 > (old_r.ly > 0 ? 2 * Webhack.YLIM
				: Webhack.YLIM + 1) + 4) {
			Rectangle r = new Rectangle(old_r);
			r.ly = r2.hy + 2;
			addRect(r);
		}
		if (old_r.hx - r2.hx - 1 > (old_r.lx > 0 ? 2 * Webhack.XLIM
				: Webhack.XLIM + 1) + 4) {
			Rectangle r = new Rectangle(old_r);
			r.lx = r2.hx + 2;
			addRect(r);
		}
	}

	/**
	 * Search Index of one precise Rectangle.
	 * 
	 * @param r
	 *            Rectangle to search for.
	 * @return Index number or -1 if not found.
	 */
	private int getRectInd(Rectangle r) {
		for (int i = 0; i < rectCnt; i++) {
			if (r.lx == rect[i].lx && r.ly == rect[i].ly && r.hx == rect[i].hx
					&& r.hy == rect[i].hy) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Search intersection between two rectangles (r1 & r2).
	 * 
	 * @param r1
	 *            First comparison rectangle
	 * @param r2
	 *            Second comparison rectangle
	 * @param r3
	 *            Result rectangle
	 * 
	 * @return True if intersection exist and put it in r3. otherwise returns
	 *         false
	 */
	private boolean intersect(Rectangle r1, Rectangle r2, Rectangle r3) {
		if (r2.lx > r1.hx || r2.ly > r1.hy || r2.hx < r1.lx || r2.hy < r1.ly) {
			return false;
		}

		r3.lx = (r2.lx > r1.lx ? r2.lx : r1.lx);
		r3.ly = (r2.ly > r1.ly ? r2.ly : r1.ly);
		r3.hx = (r2.hx > r1.hx ? r1.hx : r2.hx);
		r3.hy = (r2.hy > r1.hy ? r1.hy : r2.hy);

		if (r3.lx > r3.hx || r3.ly > r3.hy) {
			return false;
		}
		return true;
	}
}
