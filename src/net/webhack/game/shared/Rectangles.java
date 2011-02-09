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
	public int rectCnt;
	public Rectangle[] rect = new Rectangle[MAX_RECT];
	private final WebhackRandom random;

	Rectangles(final WebhackRandom random) {
		this.random = random;
		rect[0] = new Rectangle();
		rectCnt = 1;
		rect[0].lowX = rect[0].lowY = 0;
		rect[0].highX = Webhack.COLNO - 1;
		rect[0].highY = Webhack.ROWNO - 1;
	}

	@Override
	public String toString() {
		String out = "";
		for (int x = 0; x < rectCnt; x++) {
			out += rect[x].toString() + "\n";
		}
		return out;
	}

	/**
	 * Add a Rectangle to the list.
	 */
	void addRect(final Rectangle r) {
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
	Rectangle getRect(final Rectangle r) {
		for (int i = 0; i < rectCnt; i++) {
			if (r.lowX >= rect[i].lowX && r.lowY >= rect[i].lowY
					&& r.highX <= rect[i].highX && r.highY <= rect[i].highY) {
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
	void removeRect(final Rectangle r) {
		final int ind = getRectInd(r);
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
	void splitRects(final Rectangle r1, final Rectangle r2) {
		final Rectangle old_r = new Rectangle(r1);
		removeRect(r1);

		/* Walk down since rect_cnt & rect[] will change... */
		for (int i = rectCnt - 1; i >= 0; i--) {
			final Rectangle r = new Rectangle();
			if (intersect(rect[i], r2, r)) {
				splitRects(rect[i], r);
			}
		}

		if (r2.lowY - old_r.lowY - 1 > (old_r.highY < Webhack.ROWNO - 1 ? 2 * Webhack.YLIM
				: Webhack.YLIM + 1) + 4) {
			final Rectangle r = new Rectangle(old_r);
			r.highY = r2.lowY - 2;
			addRect(r);
		}
		if (r2.lowX - old_r.lowX - 1 > (old_r.highX < Webhack.COLNO - 1 ? 2 * Webhack.XLIM
				: Webhack.XLIM + 1) + 4) {
			final Rectangle r = new Rectangle(old_r);
			r.highX = r2.lowX - 2;
			addRect(r);
		}
		if (old_r.highY - r2.highY - 1 > (old_r.lowY > 0 ? 2 * Webhack.YLIM
				: Webhack.YLIM + 1) + 4) {
			final Rectangle r = new Rectangle(old_r);
			r.lowY = r2.highY + 2;
			addRect(r);
		}
		if (old_r.highX - r2.highX - 1 > (old_r.lowX > 0 ? 2 * Webhack.XLIM
				: Webhack.XLIM + 1) + 4) {
			final Rectangle r = new Rectangle(old_r);
			r.lowX = r2.highX + 2;
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
	private int getRectInd(final Rectangle r) {
		for (int i = 0; i < rectCnt; i++) {
			if (r.lowX == rect[i].lowX && r.lowY == rect[i].lowY
					&& r.highX == rect[i].highX && r.highY == rect[i].highY) {
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
	private boolean intersect(final Rectangle r1, final Rectangle r2,
			final Rectangle r3) {
		if (r2.lowX > r1.highX || r2.lowY > r1.highY || r2.highX < r1.lowX
				|| r2.highY < r1.lowY) {
			return false;
		}

		r3.lowX = (r2.lowX > r1.lowX ? r2.lowX : r1.lowX);
		r3.lowY = (r2.lowY > r1.lowY ? r2.lowY : r1.lowY);
		r3.highX = (r2.highX > r1.highX ? r1.highX : r2.highX);
		r3.highY = (r2.highY > r1.highY ? r1.highY : r2.highY);

		if (r3.lowX > r3.highX || r3.lowY > r3.highY) {
			return false;
		}
		return true;
	}
}
